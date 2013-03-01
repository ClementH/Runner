package com.twibit.runner.model.entities;

import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IBlock;

public class Block extends Entity implements IBlock {

	public Block(IWorld world) {
		super(world);

	}

	@Override
	public void update(float delta) {

	}

}
