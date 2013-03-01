package com.twibit.runner.model.entities.sign;

import com.badlogic.gdx.math.Vector2;

/**
 * Represent a movable entity with a velocity and a rotation value
 */
public interface IDynamicEntity extends IEntity {

	/**
	 * Return the gravity force vector in m/s
	 * 
	 * @return gravityForce
	 */
	public Vector2 getGravityForce();

	/**
	 * Set a new gravity force
	 * 
	 * @param gravityForce
	 */
	public void setGravityForce(Vector2 gravityForce);

	/**
	 * Update the velocity according to the gravity. This will only change the
	 * velocity. To apply the real movement, we need to call
	 * MovableEntity.applyMovement()
	 * 
	 * @param delta
	 */
	public void applyGravity(float delta);

	/**
	 * Update the velocity according to the gravity
	 * 
	 * @param delta
	 */
	public void update(float delta);

}
