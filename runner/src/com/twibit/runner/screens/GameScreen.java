package com.twibit.runner.screens;

import com.badlogic.gdx.Gdx;
import com.twibit.runner.RunnerGame;
import com.twibit.runner.model.World;
import com.twibit.runner.view.InputHandler;
import com.twibit.runner.view.WorldRenderer;

public class GameScreen extends AScreen {

	RunnerGame game;
	World world;
	WorldRenderer render;
	InputHandler input;

	public GameScreen(RunnerGame game) {
		super(game);
		world = new World();
		render = new WorldRenderer(world);
		input = new InputHandler(world);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		render.render();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// world.dispose();
		render.dispose();
	}

}