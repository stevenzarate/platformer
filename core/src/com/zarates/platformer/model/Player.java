package com.zarates.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; //vector two is a point for x y
    public Texture spritesheet; // spritesheet is for the player picture

    public Player() {
        position = new Vector2(0, 0);//the points where the player shows up
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png"));//getting the spritesheet
    }
}
