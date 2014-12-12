package com.zarates.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; //vector two is a point for x y
    public Animation animation;
    public Spritesheet spriteSheet;

    public float stateTime;//the game time

    public Player() {
        position = new Vector2(4, 5);//the points where the player shows up
        spriteSheet = new Spritesheet("img/aliens.png", 70, 100);
        animation = spriteSheet.createAnimation(9, 20, .1f);//using spritesheet object

        stateTime = 0f;

    }

    public void draw(Batch spriteBatch){ //images in our spritesheet are drawn here
        spriteBatch.draw(animation.getKeyFrame(stateTime,true), position.x, position.y, 70  * (1/70f), 100  * (1/70f));//makes a rectangle and draws the picture on the screen

    }
    public void update(float deltaTime){ //it changes specifics of player
        stateTime += deltaTime;
        position.x += deltaTime;
    }
}
