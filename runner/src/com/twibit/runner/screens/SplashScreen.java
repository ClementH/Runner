package com.twibit.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.twibit.runner.RunnerGame;

public class SplashScreen extends AScreen {
	private Texture splashTexture;
	private Sprite splashSprite;

	private float timer;

	public SplashScreen(RunnerGame game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();

		timer = 0;

		splashTexture = new Texture("data/splashscreen.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		splashSprite = new Sprite(splashTexture);
		splashSprite.setX(Gdx.graphics.getWidth() / 2 - (splashSprite.getWidth() / 2));
		splashSprite.setY(Gdx.graphics.getHeight() / 2 - (splashSprite.getHeight() / 2));
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update(delta);

		batch.begin();
		splashSprite.draw(batch);
		batch.end();
	}

	private void update(float delta) {
		timer += delta;
		if (timer >= 2) {
			game.setScreen(new MainMenuScreen(game));
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
		splashTexture.dispose();
	}
}
