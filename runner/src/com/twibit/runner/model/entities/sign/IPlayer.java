package com.twibit.runner.model.entities.sign;

import com.twibit.runner.model.entities.Player.Orientation;

/**
 * Interface that represent a player entity.
 */
public interface IPlayer extends IMovableEntity {

	public boolean isJumping();

	public boolean isOnFloor();

	public boolean isFalling();

	public Orientation getOrientation();

}
