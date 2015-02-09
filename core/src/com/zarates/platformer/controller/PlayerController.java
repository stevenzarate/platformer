package com.zarates.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.zarates.platformer.model.Player;

public class PlayerController {
    public static Player player;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController(){
        player = new Player(new Vector2(3, 3), 70, 100);//the player variable stores postition and spritesheet
    }

    public static void update(float deltaTime){
        handleInput();
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch){
        player.draw(spriteBatch);
    }

    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();//get the current velocity of phiysicsBody and store it in the variable "velocity"
        Vector2 position = player.physicsBody.getPosition();//get the current position of physicsBody and stores it in variable "position"

        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {//checks what key is pressed
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);//if the right key is pressed then the player moves
        }
    }
}
