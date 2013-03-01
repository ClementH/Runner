package com.twibit.runner.model.entities.sign;

import com.badlogic.gdx.math.Vector2;

/**
 * Represent a movable entity with a velocity and a rotation value
 */
public interface IMovableEntity extends IEntity {

	/**
	 * Return the current velocity
	 * 
	 * @return velocity
	 */
	public Vector2 getVelocity();

	/**
	 * Set a new velocity value
	 * 
	 * @param velocity
	 */
	public void setVelocity(Vector2 velocity);

	/**
	 * Return the current speed
	 * 
	 * @return speed
	 */
	public float getSpeed();

	/**
	 * Define the entity speed
	 * 
	 * @param speed
	 */
	public void setSpeed(float speed);

	/**
	 * Update the position according to the velocity
	 * 
	 * @param delta
	 */
	public void applyMovement(float delta);

	/**
	 * Update the position according to the velocity
	 * 
	 * @param delta
	 */
	public void update(float delta);

}
