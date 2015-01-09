package com.zarates.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        map = new TmxMapLoader().load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//this is for the tile
        gameWorld = new World(new Vector2(0, -10), true);//creates gravity
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();//accessing the sprite batch in our spritebatch

    }

   public static void draw(){
       spriteBatch.begin();//to know when to begin to draw the player
       player.draw(spriteBatch);
       spriteBatch.end();//to know when to end the draw
       debugRenderer.render(gameWorld, CameraController.camera.combined);//displaying shapes at the size its supposed to be
   }

    public  static void update(float deltaTime) {
        renderer.setView(CameraController.camera);//sets the camera on the map
        renderer.render();//to draw our map on the screen
        gameWorld.step(1/60f, 1, 1);//update our game world
    }
}
