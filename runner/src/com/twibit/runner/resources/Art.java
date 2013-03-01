package com.twibit.runner.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Art {

	public static Texture backgroundTexture;
	public static Texture uiTexture;
	public static Texture itemsTexture;

	public static TextureRegion background;

	public static TextureRegion buttonStart;
	public static TextureRegion buttonOption;
	public static TextureRegion buttonQuit;

	public static TextureRegion mainMenu;
	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;
	public static TextureRegion spring;
	public static TextureRegion castle;

	public static Animation coinAnim;
	public static Animation bobJump;
	public static Animation bobFall;
	public static TextureRegion bobHit;
	public static Animation squirrelFly;
	public static TextureRegion platform;
	public static Animation brakingPlatform;
	public static BitmapFont font;

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load() {

		backgroundTexture = loadTexture("data/bg.png");
		background = new TextureRegion(backgroundTexture, 0, 0, 320, 480);

		uiTexture = loadTexture("data/ui.png");
		buttonStart = new TextureRegion(uiTexture, 0, 0, 100, 25);
		buttonOption = new TextureRegion(uiTexture, 0, 25, 100, 25);
		buttonQuit = new TextureRegion(uiTexture, 0, 50, 100, 25);

		itemsTexture = loadTexture("data/items.png");

		gameOver = new TextureRegion(itemsTexture, 352, 256, 160, 96);
		highScoresRegion = new TextureRegion(Art.itemsTexture, 0, 257, 300, 110 / 3);
		logo = new TextureRegion(itemsTexture, 0, 352, 274, 142);
		soundOff = new TextureRegion(itemsTexture, 0, 0, 64, 64);
		soundOn = new TextureRegion(itemsTexture, 64, 0, 64, 64);
		arrow = new TextureRegion(itemsTexture, 0, 64, 64, 64);
		pause = new TextureRegion(itemsTexture, 64, 64, 64, 64);

		spring = new TextureRegion(itemsTexture, 128, 0, 32, 32);
		castle = new TextureRegion(itemsTexture, 128, 64, 64, 64);
		coinAnim = new Animation(0.2f, new TextureRegion(itemsTexture, 128, 32, 32, 32), new TextureRegion(itemsTexture, 160, 32, 32, 32), new TextureRegion(
				itemsTexture, 192, 32, 32, 32), new TextureRegion(itemsTexture, 160, 32, 32, 32));
		bobJump = new Animation(0.2f, new TextureRegion(itemsTexture, 0, 128, 32, 32), new TextureRegion(itemsTexture, 32, 128, 32, 32));
		bobFall = new Animation(0.2f, new TextureRegion(itemsTexture, 64, 128, 32, 32), new TextureRegion(itemsTexture, 96, 128, 32, 32));
		bobHit = new TextureRegion(itemsTexture, 128, 128, 32, 32);
		squirrelFly = new Animation(0.2f, new TextureRegion(itemsTexture, 0, 160, 32, 32), new TextureRegion(itemsTexture, 32, 160, 32, 32));
		platform = new TextureRegion(itemsTexture, 64, 160, 64, 16);
		brakingPlatform = new Animation(0.2f, new TextureRegion(itemsTexture, 64, 160, 64, 16), new TextureRegion(itemsTexture, 64, 176, 64, 16),
				new TextureRegion(itemsTexture, 64, 192, 64, 16), new TextureRegion(itemsTexture, 64, 208, 64, 16));

		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);

	}

}
