package com.zarates.platformer.view;
//these are the imports
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.zarates.platformer.controller.CameraController;
import com.zarates.platformer.controller.LevelController;
import com.zarates.platformer.model.Player;

//these are variables
public class GameScreen implements Screen {

    public Player player;

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        player = new Player(70, 100);//the player variable stores postition and spritesheet
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.12f, 0.48f, 0.87f, 1f);//that's my color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//clears screen with my chosen color

        LevelController.update(delta);
        CameraController.update();

        player.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
