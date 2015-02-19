package com.zarates.platformer.view;
//these are the imports
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.zarates.platformer.controller.CameraController;
import com.zarates.platformer.controller.LevelController;
import com.zarates.platformer.controller.PlayerController;

//these are variables
public class GameScreen implements Screen {

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.12f, 0.48f, 0.87f, 1f);//that's my color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//clears screen with my chosen color

        LevelController.update(delta);
         CameraController.update();

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
