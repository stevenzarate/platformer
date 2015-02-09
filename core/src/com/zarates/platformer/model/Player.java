package com.zarates.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.zarates.platformer.controller.LevelController;

public class Player extends Sprite       {

    public Player(Vector2 position, int width, int height) {
        //lines 32-46 creates a body then creates a shape and connects the shape to the body
        super(position, width, height);
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        physicsBody.createFixture(fixtureDefinition);
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



    }

    public void draw(Batch spriteBatch){ //images in our spritesheet are drawn here
        super.draw(spriteBatch);
    }
    public void update(float deltaTime){ //it changes specifics of player
        super.update(deltaTime);
    }
}
