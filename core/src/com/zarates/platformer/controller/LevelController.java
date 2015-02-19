package com.zarates.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.zarates.platformer.model.Level;
import com.zarates.platformer.model.Player;
import com.zarates.platformer.model.Sprite;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Array<Body> worldBodies;   private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        level = new Level("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE );//this is for the tile

        gameWorld = new World(new Vector2(0, -10), true);//creates gravity
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();//accessing the sprite batch in our spritebatch

        PlayerController.initializeController();
    }

   public static void draw(){
       spriteBatch.begin();//to know when to begin to draw the player
       PlayerController.draw(spriteBatch);
       spriteBatch.end();//to know when to end the draw
       debugRenderer.render(gameWorld, CameraController.camera.combined);//displaying shapes at the size its supposed to be
   }

    public  static void update(float deltaTime) {
        renderer.setView(CameraController.camera);//sets the camera on the map
        renderer.render();//to draw our map on the screen
        PlayerController.update(deltaTime);
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);//update our game world
    }

    private static void updateWorldBodies(){
        worldBodies.clear();//clears the body
        gameWorld.getBodies(worldBodies);//getting all the bodies and storing them in worldBodies

        for (Body body : worldBodies){ //lets us access the bodies
            Sprite spriteBody = (Sprite)body.getUserData();//gets the body and the bodies classes and stores them in player

            if(spriteBody != null){
                spriteBody.position = body.getPosition();// setting the position of the players body
            }
        }
    }
}
