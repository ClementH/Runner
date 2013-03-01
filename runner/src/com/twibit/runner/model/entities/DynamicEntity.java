package com.twibit.runner.model.entities;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IDynamicEntity;

public abstract class DynamicEntity extends MovableEntity implements IDynamicEntity {

	private Vector2 gravityForce;
	private float friction;

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 */
	public DynamicEntity(IWorld runnerWorld) {
		this(runnerWorld, "DynamicDefault");
	}

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 * @param name
	 */
	public DynamicEntity(IWorld runnerWorld, String name) {
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
	public DynamicEntity(IWorld runnerWorld, String name, Vector2 position, Vector2 dimension, float rotation) {
		super(runnerWorld, name, position, dimension, rotation);
		this.gravityForce = new Vector2();
	}

	@Override
	public void setGravityForce(Vector2 gravityForce) {
		this.gravityForce = gravityForce;
	}

	@Override
	public Vector2 getGravityForce() {
		return this.gravityForce;
	}

	@Override
	public void applyGravity(float delta) {
		this.getVelocity().add(gravityForce.tmp().mul(delta));
	}

	@Override
	public void update(float delta) {
		applyGravity(delta);
		applyMovement(delta);
	}

	@Override
	public float getFriction() {
		return this.friction;
	}

	@Override
	public void setFriction(float friction) {
		this.friction = friction;
		if(friction > 1){ this.friction = 1;}
		if(friction < 0){ this.friction = 0;}
	}

	@Override
	public void applyFriction(float delta) {
		float speed = this.getSpeed();
		this.setSpeed(speed - (speed * friction));
	}

}
