package com.twibit.runner.model.entities;

import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IPlayer;
import com.twibit.runner.model.entities.sign.IWall;
import com.twibit.runner.view.InputHandler;

public class Player extends DynamicEntity implements IPlayer {

	public PolygonShape shape;

	public enum Orientation {
		LEFT, RIGHT, FRONT, BACK
	};

	private boolean isJumping;
	private boolean isOnFloor;
	private Orientation orientation;

	public Player(IWorld world, Vector2 position, Vector2 size, float rotation) {
		super(world, "player", position, size, rotation);
		setGravityForce(new Vector2(0, -9.81f));
		setFriction(0.1f);
	}

	@Override
	public void update(float delta) {

		InputHandler input = getWorld().getInput();

		// Input handling
		if (input.buttons[InputHandler.UP]) {

			if (isOnFloor()) {
				this.getVelocity().y += 10;
				setOnFloor(false);
				setJumping(true);
			}
		}
		if (input.buttons[InputHandler.RIGHT]) {
			this.getVelocity().x += 20 * delta;
		}
		if (input.buttons[InputHandler.LEFT]) {
			this.getVelocity().x -= 20 * delta;
		}

		// Calculate forces
		if (!isOnFloor()) {
			applyGravity(delta);
		} else {
			if (!input.buttons[InputHandler.LEFT] && !input.buttons[InputHandler.RIGHT]) {
				applyFriction(delta);
			}
		}

		// Collision detection
		Iterator<IWall> it = getWorld().getWalls().iterator();
		IWall w;
		while (it.hasNext()) {
			w = it.next();
			if (w.overlaps(this)) {
				System.out.println("Overlapping");
				Vector2 collision = this.collisionVector(w);

				// En cas de collision, on diminue la vitesse
				if (Math.abs(collision.x) > 0) {
					getVelocity().mul(0, 1);
				}
				if (Math.abs(collision.y) > 0) {
					getVelocity().mul(1, 0);
					if (collision.y > 0) {
						this.setOnFloor(true);
					}
				}
				this.getPosition().add(collision.mul(1.001f));
			}
		}

		// Move
		applyMovement(delta);
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public boolean isOnFloor() {
		return isOnFloor;
	}

	public void setOnFloor(boolean isOnFloor) {
		System.out.println("isOnFloor : " + isOnFloor);
		this.isOnFloor = isOnFloor;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public boolean isFalling() {
		return !isJumping && !isOnFloor;
	}

}
