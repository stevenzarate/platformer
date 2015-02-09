package com.zarates.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.zarates.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body physicsBody;
    public Vector2 position; //vector two is a point for x y
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;
    public float stateTime;//the game time
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height){
        this.position = position;//the points where the player shows up
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime,true), position.x, position.y, width, height );//makes a rectangle and draws the picture on the screen
    }

    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
