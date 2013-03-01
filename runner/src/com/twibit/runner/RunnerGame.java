package com.twibit.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.twibit.runner.screens.SplashScreen;

/**
 * Main class of our game. It handle the display of the current screen.
 */
public class RunnerGame extends Game {

	public static final String LOG = RunnerGame.class.getSimpleName();
	public static final String VERSION = "0.0.1-DEV";
	public static final boolean DEBUG = true;

	private FPSLogger fpsLogger;

	@Override
	public void create() {
		Gdx.app.log(RunnerGame.LOG, "Creating game");
		fpsLogger = new FPSLogger();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
		fpsLogger.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(RunnerGame.LOG, "Resizing game to: " + width + " x " + height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
