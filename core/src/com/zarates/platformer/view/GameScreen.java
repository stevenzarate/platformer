package com.zarates.platformer.view;
//these are the imports
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//these are variables
public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader().load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//this is for the tile
        //gets the height and width of screen
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height/width));//this is for how many tiles display on screen and does something with the aspect
        camera.position.set(camera.viewportWidth/ 2f, camera.viewportHeight/ 2f,0);//it changes the points on the graph so the camera view can change
    }

    @Override
    public void render(float delta) {
        camera.update();// it updates the camera
        renderer.setView(camera);//sets the camera on the map
        renderer.render();//to draw our map on the screen
    }

    @Override
    public void resize(int width, int height) {

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
