package com.twibit.runner.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.twibit.runner.model.entities.Player;
import com.twibit.runner.model.entities.Wall;
import com.twibit.runner.model.entities.sign.IPlayer;
import com.twibit.runner.model.entities.sign.IWall;
import com.twibit.runner.view.InputHandler;
import com.twibit.runner.view.WorldRenderer;

public class World implements IWorld {

	private IPlayer player;
	private List<IWall> walls;

	private WorldRenderer worldRenderer;
	private InputHandler input;

	public World() {

		player = new Player(this, new Vector2(0, 0), new Vector2(1, 2), 0);

		walls = new ArrayList<IWall>();

		IWall w;
		w = new Wall(this, new Vector2(0, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(0, 1), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(0, 2), new Vector2(1, 1), 0);
		walls.add(w);

		
		w = new Wall(this, new Vector2(1, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(2, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(3, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(4, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(5, 0), new Vector2(1, 1), 0);
		walls.add(w);
		
		w = new Wall(this, new Vector2(-1, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(-2, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(-3, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(-4, 0), new Vector2(1, 1), 0);
		walls.add(w);
		w = new Wall(this, new Vector2(-5, 0), new Vector2(1, 1), 0);
		walls.add(w);
		
		IWall floor = new Wall(this, new Vector2(-500, -5), new Vector2(1000, 3), 0);
		walls.add(floor);

	}

	@Override
	public IPlayer getPlayer() {
		return this.player;
	}

	@Override
	public void addWall(IWall wall) {
		walls.add(wall);
	}

	@Override
	public List<IWall> getWalls() {
		return walls;
	}

	@Override
	public void setRenderer(WorldRenderer worldRenderer) {
		this.worldRenderer = worldRenderer;
	}

	@Override
	public WorldRenderer getRenderer() {
		return this.worldRenderer;
	}

	@Override
	public void update(float delta) {
		player.update(delta);
	}

	@Override
	public void setInput(InputHandler input) {
		this.input = input;
	}

	@Override
	public InputHandler getInput() {
		return input;
	}

}
