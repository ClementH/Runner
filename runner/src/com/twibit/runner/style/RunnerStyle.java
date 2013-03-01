package com.twibit.runner.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.twibit.runner.config.Config;

public class RunnerStyle extends Skin {

	public static final String BACKGROUND = "background";
	public static final String CHAR_STAND = "character_stand";
	public static final String CHAR_RUN_1 = "character_run_1";
	public static final String CHAR_RUN_2 = "character_run_2";
	public static final String CHAR_RUN_3 = "character_run_3";

	public static final int LINE_HEIGHT = 48;
	public static final int COL_WIDTH = 48;

	private Skin runnerSkin;
	private TextButtonStyle runnerTextButtonStyle;

	private static RunnerStyle instance = new RunnerStyle();

	public static RunnerStyle getInstance() {
		return instance;
	}

	private RunnerStyle() {
		super();
		runnerSkin = new Skin();

		Texture skin_texture = new Texture(Gdx.files.internal(Config.SKIN_FILE_PATH));
		runnerSkin.add(CHAR_STAND, new TextureRegion(skin_texture, 0 * LINE_HEIGHT, 0 * COL_WIDTH, 48, 48));
		runnerSkin.add(CHAR_RUN_1, new TextureRegion(skin_texture, 12 * LINE_HEIGHT, 0 * COL_WIDTH, 48, 48));
		runnerSkin.add(CHAR_RUN_2, new TextureRegion(skin_texture, 12 * LINE_HEIGHT, 1 * COL_WIDTH, 48, 48));
		runnerSkin.add(CHAR_RUN_3, new TextureRegion(skin_texture, 12 * LINE_HEIGHT, 2 * COL_WIDTH, 48, 48));
		runnerSkin.add(BACKGROUND, new TextureRegion(skin_texture, 2 * LINE_HEIGHT, 0 * COL_WIDTH, 48, 48));

		runnerTextButtonStyle = new TextButtonStyle();
		runnerTextButtonStyle.font = new BitmapFont();
		runnerTextButtonStyle.fontColor = Color.WHITE;
		runnerTextButtonStyle.pressedOffsetY = 1f;
		runnerTextButtonStyle.downFontColor = new Color(0.8f, 0.8f, 0.8f, 1f);
	}

	public Skin getSkin() {
		return this.runnerSkin;
	}

	public TextButtonStyle getTextButtonStyle() {
		return this.runnerTextButtonStyle;
	}

}
