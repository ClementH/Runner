package com.twibit.runner.view;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.twibit.runner.RunnerGame;
import com.twibit.runner.model.IWorld;
import com.twibit.runner.model.entities.sign.IPlayer;
import com.twibit.runner.model.entities.sign.IWall;

/**
 * Main view class. It display the world passed to the constructor.
 */
public class WorldRenderer {

	private IWorld world;
	private IPlayer player;
	private List<IWall> walls;

	private SpriteBatch batch;
	private OrthographicCamera cam;

	private TextureRegion playerTexture, wallTexture, backgroundTexture;
	private TextureAtlas playerAtlas, worldAtlas;

	private float width, height;

	public WorldRenderer(IWorld world) {
		this.world = world;

		this.world.setRenderer(this);

		width = Gdx.graphics.getWidth() / 40;
		height = Gdx.graphics.getHeight() / 40;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();

		playerAtlas = new TextureAtlas("data/player.pack");
		worldAtlas = new TextureAtlas("data/world.pack");

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

		playerTexture = playerAtlas.findRegion("standing");
		wallTexture = worldAtlas.findRegion("dirt");
		Texture bg = new Texture(Gdx.files.internal("data/bg.png"));
		backgroundTexture = new TextureRegion(bg, 0, 0, bg.getWidth(), bg.getHeight());
	}

	public void render() {
		Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// Get objects from world
		player = world.getPlayer();
		walls = world.getWalls();

		// Update camera
		cam.position.set(player.getPosition().x, player.getPosition().y, 0);
		cam.update();

		// Set the batch matrix to the camera matrix
		batch.setProjectionMatrix(cam.combined);

		// TODO : Use visitor here
		renderBackground();
		for (IWall w : walls) {
			renderWall(w);
		}

		renderPlayer(player);
		// If we're debugging, draw collision boxes
		if (RunnerGame.DEBUG) {

		}
	}

	private void renderBackground() {
		// Commence rendering
		batch.begin();
		// Drawing the background
		batch.draw(backgroundTexture, cam.position.x - cam.viewportWidth / 2, cam.position.y - cam.viewportHeight / 2, cam.viewportWidth, cam.viewportHeight);
		// Done rendering
		batch.end();
	}

	private void renderPlayer(IPlayer player) {
		// Commence rendering
		batch.begin();
		// Drawing the player
		batch.draw(playerTexture, player.getPosition().x - 0.5f, player.getPosition().y - 1, player.getDimension().x, player.getDimension().y);
		// Done rendering
		batch.end();
	}

	private void renderWall(IWall wall) {
		// Commence rendering
		batch.begin();
		// Drawing the player
		batch.draw(wallTexture, wall.getPosition().x - 0.5f, wall.getPosition().y - 1, wall.getDimension().x, wall.getDimension().y);
		// Done rendering
		batch.end();
	}

	public OrthographicCamera getCamera() {
		return cam;
	}

	public void dispose() {
		batch.dispose();
		playerAtlas.dispose();
	}

}