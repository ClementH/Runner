package com.twibit.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.twibit.runner.RunnerGame;

public class MainMenuScreen extends AScreen {

	Stage stage;
	BitmapFont black;
	BitmapFont white;
	TextureAtlas buttonAtlas;
	Skin buttonSkin;
	Label label;

	private TextButton buttonNew;
	private TextButton buttonOptions;
	private TextButton buttonQuit;

	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 70;

	public MainMenuScreen(RunnerGame game) {
		super(game);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(delta);

		batch.begin();
		stage.draw();
		batch.end();
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		buttonAtlas = new TextureAtlas("data/button.pack");
		buttonSkin = new Skin();
		buttonSkin.addRegions(buttonAtlas);
		white = new BitmapFont(Gdx.files.internal("data/fonts/whitefont.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("data/fonts/blackfont.fnt"), false);
	}

	@Override
	public void resize(int width, int height) {
		if (stage == null)
			stage = new Stage(width, height, true);
		stage.clear();

		Gdx.input.setInputProcessor(stage);

		TextButtonStyle style = new TextButtonStyle();
		style.up = buttonSkin.getDrawable("button");
		style.down = buttonSkin.getDrawable("button_pressed");
		style.font = white;

		Table table = new Table();
		stage.addActor(table);
		table.setFillParent(true);
		table.align(Align.center | Align.top);

		LabelStyle ls = new LabelStyle(white, Color.WHITE);
		label = new Label("Runner Game", ls);
		label.setWidth(BUTTON_WIDTH);
		label.setAlignment(Align.center);
		table.row();
		table.add(label);

		buttonNew = new TextButton("New Game", style);
		buttonNew.setWidth(BUTTON_WIDTH);
		buttonNew.setHeight(BUTTON_HEIGHT);
		table.row();
		table.add(buttonNew);

		buttonOptions = new TextButton("Options", style);
		buttonOptions.setWidth(BUTTON_WIDTH);
		buttonOptions.setHeight(BUTTON_HEIGHT);
		table.row();
		table.add(buttonOptions);

		buttonQuit = new TextButton("Quit", style);
		buttonQuit.setWidth(BUTTON_WIDTH);
		buttonQuit.setHeight(BUTTON_HEIGHT);
		table.row();
		table.add(buttonQuit);

		buttonNew.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log(RunnerGame.LOG, "New game requested");
				game.setScreen(new GameScreen(game));
			}
		});

		buttonOptions.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log(RunnerGame.LOG, "Options requested");
			}
		});

		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log(RunnerGame.LOG, "Quit requested");
				game.dispose();
				System.exit(0);
			}
		});

		stage.addActor(table);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
		buttonSkin.dispose();
		buttonAtlas.dispose();
		white.dispose();
		black.dispose();
		stage.dispose();
	}

}