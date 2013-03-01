package com.twibit.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.twibit.runner.RunnerGame;

/**
 * The base class for all game screens.
 */
public abstract class AScreen implements Screen {

	RunnerGame game;
	SpriteBatch batch;
	BitmapFont font;

	public AScreen(RunnerGame game) {
		this.game = game;
	}

	protected String getName() {
		return getClass().getSimpleName();
	}

	@Override
	public void show() {
		Gdx.app.log(RunnerGame.LOG, "Showing screen: " + getName());
		batch = new SpriteBatch();
		font = new BitmapFont();

	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(RunnerGame.LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void hide() {
		Gdx.app.log(RunnerGame.LOG, "Hiding screen: " + getName());
	}

	@Override
	public void pause() {
		Gdx.app.log(RunnerGame.LOG, "Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log(RunnerGame.LOG, "Resuming screen: " + getName());
	}

	@Override
	public void dispose() {
		Gdx.app.log(RunnerGame.LOG, "Disposing screen: " + getName());
	}
}