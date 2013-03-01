package com.twibit.runner.model.entities;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IMovableEntity;

public abstract class MovableEntity extends Entity implements IMovableEntity {

	private Vector2 velocity;

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 */
	public MovableEntity(IWorld runnerWorld) {
		this(runnerWorld, "MovableDefault");
	}

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 * @param name
	 */
	public MovableEntity(IWorld runnerWorld, String name) {
		this(runnerWorld, name, new Vector2(), new Vector2(), 0);
	}

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 * @param name
	 * @param position
	 * @param dimension
	 * @param rotation
	 */
	public MovableEntity(IWorld runnerWorld, String name, Vector2 position, Vector2 dimension, float rotation) {
		super(runnerWorld, name, position, dimension, rotation);
		this.velocity = new Vector2();
	}

	@Override
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	@Override
	public Vector2 getVelocity() {
		return this.velocity;
	}

	@Override
	public float getSpeed() {
		return this.velocity.len();
	}

	@Override
	public void setSpeed(float speed) {
		this.velocity.nor().mul(speed);
	}

	@Override
	public void applyMovement(float delta) {
		float speed = getSpeed() * delta;
		this.getPosition().add(velocity.tmp().nor().mul(speed));
	}

	@Override
	public void update(float delta) {
		applyMovement(delta);
	}

}
