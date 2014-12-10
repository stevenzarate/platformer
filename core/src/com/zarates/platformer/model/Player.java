package com.zarates.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; //vector two is a point for x y
    public Texture spriteSheet; // spritesheet is for the player picture

    public TextureRegion[] spriteFrames; //

    public Animation animation;
    public float stateTime;//the game time

    public Player() {
        position = new Vector2(4, 5);//the points where the player shows up
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));//getting the spritesheet

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100) ;//it splits up our spritsheet to width and height and stores it in a two dimensional array

        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length;row++){//selecting rows that we're on
            for (int column = 0; column < spriteSheetFrames[row].length; column++){//selecting columns for the player
                counter++;// counts the sprites we have in our texture
            }
        }

        spriteFrames = new TextureRegion[counter];//creates  frames in the array

        counter = 0;//sets counter to zero
        for (TextureRegion[] row : spriteSheetFrames){//access to two dimensional and storing it as an array
            for (TextureRegion sprite : row){//taking information from row and storing it in sprite
                spriteFrames[counter++] = sprite; // takes sprite and stores it in spriteframes
            }
        }

        TextureRegion[] animationFrames = new TextureRegion[2];//storing frames in our new animation array
        animationFrames[0] = spriteFrames[1];
        animationFrames[1] = spriteFrames[2];
        animation = new Animation(.1f, animationFrames);//telling animation will last 1 sec
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
