package com.zarates.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.zarates.platformer.view.GameScreen;

import java.util.HashMap;

public class Player {
    public Vector2 position; //vector two is a point for x y
    public int width;
    public int height;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    public float stateTime;//the game time
    private HashMap<String, Animation> animations;

    public Player() {
        position = new Vector2(4, 5);//the points where the player shows up
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        //lines 32-46 creates a body then creates a shape and connects the shape to the body
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        Body playerBody = GameScreen.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(width / 2f, height / 2f, new Vector2(width / 2f, height / 2f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("stand", spriteSheet.createAnimation(0, 0, .1f));
        animations.put("walk", spriteSheet.createAnimation(9, 10, .1f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, .1f));
        animations.put("duck", spriteSheet.createAnimation(3, 3, .1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, .1f));
        animations.put("idol", spriteSheet.createAnimation(6, 6, .1f));
        animations.put("swim", spriteSheet.createAnimation(7, 8, .1f));
        animations.put("jump", spriteSheet.createAnimation(5, 5, .1f));

        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("idolLeft", spriteSheet.flipAnimation(animations.get("idol"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));

        currentAnimation = "walk";

        stateTime = 0f;

    }

    public void draw(Batch spriteBatch){ //images in our spritesheet are drawn here
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime,true), position.x, position.y, 70  * (1/70f), 100  * (1/70f));//makes a rectangle and draws the picture on the screen

    }
    public void update(float deltaTime){ //it changes specifics of player
        stateTime += deltaTime;

    }
}
