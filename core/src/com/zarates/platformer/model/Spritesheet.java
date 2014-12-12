package com.zarates.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet; // spritesheet is for the player picture
    public TextureRegion[] spriteFrames;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));//getting the spritesheet

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height) ;//it splits up our spritsheet to width and height and stores it in a two dimensional array

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
    }

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed){
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];//storing frames in our new animation array

        for (int index = lastFrame; index >= startFrame; index--){//working backwards from 10 to 0
            animationFrames[--counter] = spriteFrames[index]; // storing it in reverse order
        }

        return new Animation(animationSpeed, animationFrames);//telling animation will last 1 sec
    }

    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY){

    }
}
