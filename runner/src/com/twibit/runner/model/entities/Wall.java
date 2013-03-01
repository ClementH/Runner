package com.twibit.runner.model.entities;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IWall;

public class Wall extends Entity implements IWall {

	public Wall(IWorld world, Vector2 position, Vector2 size, float rotation) {
		super(world, "wall", position, size, rotation);

	}

	@Override
	public void update(float delta) {

	}

}
