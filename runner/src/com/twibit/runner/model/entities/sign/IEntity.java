package com.twibit.runner.model.entities.sign;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.IWorld;

/**
 * Describe a basic entity
 */
public interface IEntity {

	/**
	 * Return the containing world
	 * 
	 * @return world
	 */
	public IWorld getWorld();

	/**
	 * Return the entity unique id
	 * 
	 * @return id
	 */
	public String getUID();

	/**
	 * Define the entity name
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Return the entity name
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Define the entity position
	 * 
	 * @param position
	 */
	public void setPosition(Vector2 position);

	/**
	 * Return the entity position
	 * 
	 * @return position
	 */
	public Vector2 getPosition();

	/**
	 * Define the entity dimensions
	 * 
	 * @param dimension
	 */
	public void setDimension(Vector2 dimension);

	/**
	 * Return the entity dimensions
	 * 
	 * @return dimensions
	 */
	public Vector2 getDimension();

	/**
	 * Update the entity state
	 * 
	 * @param delta
	 */
	public void update(float delta);

	/**
	 * Return the rotation angle of the entity
	 * 
	 * @return angle
	 */
	float getRotation();

	/**
	 * Define the rotation angle of the entity
	 * 
	 * @param rotation
	 */
	void setRotation(float rotation);

	/**
	 * Tell if the entity is overlapping with an other
	 * 
	 * @param entity
	 */
	boolean overlaps(IEntity entity);

	Vector2 collisionVector(IEntity entity);

	public float top();

	public float bottom();

	public float left();

	public float right();

}
