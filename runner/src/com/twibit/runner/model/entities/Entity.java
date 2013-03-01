package com.twibit.runner.model.entities;

import java.util.UUID;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IEntity;

/**
 * Represent a game entity with coordinate, size and name
 */
public abstract class Entity implements IEntity {

	/**
	 * The world containing the entity
	 */
	private IWorld runnerWorld;

	/**
	 * Unique ID of the entity.
	 */
	private UUID uuid;

	/**
	 * The entity name.
	 */
	private String name;

	/**
	 * The Entity position
	 */
	private Vector2 position;

	/**
	 * The entity dimension
	 */
	private Vector2 dimension;

	/**
	 * The entity rotation
	 */
	private float rotation;

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 */
	public Entity(IWorld runnerWorld) {
		this(runnerWorld, "default");
	}

	/**
	 * Constructor
	 * 
	 * @param runnerWorld
	 * @param name
	 */
	public Entity(IWorld runnerWorld, String name) {
		this(runnerWorld, name, new Vector2(), new Vector2(), 0);
	}

	/**
	 * Constructor
	 * 
	 * @param world
	 * @param name
	 * @param position
	 * @param dimension
	 */
	public Entity(IWorld runnerWorld, String name, Vector2 position, Vector2 dimension, float rotation) {
		this.uuid = UUID.randomUUID();
		this.runnerWorld = runnerWorld;
		this.name = name;
		this.position = position;
		this.dimension = dimension;
	}

	@Override
	public String getUID() {
		return uuid.toString();
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	@Override
	public Vector2 getPosition() {
		return this.position;
	}

	@Override
	public void setDimension(Vector2 dimension) {
		this.dimension = dimension;
	}

	@Override
	public Vector2 getDimension() {
		return this.dimension;
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	@Override
	public float getRotation() {
		return this.rotation;
	}

	@Override
	public IWorld getWorld() {
		return this.runnerWorld;
	}

	public float top() {
		return this.position.y + this.dimension.y;
	}

	public float bottom() {
		return this.position.y;
	}

	public float left() {
		return this.position.x;
	}

	public float right() {
		return this.position.x + this.dimension.x;
	}

	@Override
	public boolean overlaps(IEntity entity) {
		return !((this.bottom() > entity.top()) || (this.top() < entity.bottom()) || (this.left() > entity.right()) || (this.right() < entity.left()));
	}

	@Override
	public Vector2 collisionVector(IEntity entity) {
		if (!overlaps(entity)) {
			return new Vector2(0, 0);
		} else {

			Vector2 amin = new Vector2(left(), bottom());
			Vector2 amax = new Vector2(right(), top());
			Vector2 bmin = new Vector2(entity.left(), entity.bottom());
			Vector2 bmax = new Vector2(entity.right(), entity.top());

			Vector2 mtd = new Vector2();

			float left = (bmin.x - amax.x);
			float right = (bmax.x - amin.x);
			float top = (bmin.y - amax.y);
			float bottom = (bmax.y - amin.y);

			// box intersect. work out the mtd on both x and y axes.
			if (Math.abs(left) < right)
				mtd.x = left;
			else
				mtd.x = right;

			if (Math.abs(top) < bottom)
				mtd.y = top;
			else
				mtd.y = bottom;

			// 0 the axis with the largest mtd value.
			if (Math.abs(mtd.x) < Math.abs(mtd.y))
				mtd.y = 0;
			else
				mtd.x = 0;

			System.out.println(mtd);
			return mtd;

		}
	}

}
