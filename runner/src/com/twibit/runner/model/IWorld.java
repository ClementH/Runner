package com.twibit.runner.model;

import java.util.List;

import com.twibit.runner.model.entities.sign.IPlayer;
import com.twibit.runner.model.entities.sign.IWall;
import com.twibit.runner.view.InputHandler;
import com.twibit.runner.view.WorldRenderer;

/**
 * Interface for a virtual world
 */
public interface IWorld {

	/**
	 * Add a wall to the world
	 * 
	 * @param entity
	 */
	public void addWall(IWall wall);

	/**
	 * Return all the walls
	 * 
	 * @return entity list
	 */
	public List<IWall> getWalls();

	/**
	 * Return the current player
	 * 
	 * @return
	 */
	public IPlayer getPlayer();

	/**
	 * Update all the world
	 * 
	 * @param delta
	 */
	public void update(float delta);

	/**
	 * Set the current worldRenderer
	 * 
	 * @param worldRenderer
	 */
	public void setRenderer(WorldRenderer worldRenderer);

	/**
	 * Return the current world renderer
	 * 
	 * @return
	 */
	public WorldRenderer getRenderer();

	public InputHandler getInput();

	void setInput(InputHandler input);

}
