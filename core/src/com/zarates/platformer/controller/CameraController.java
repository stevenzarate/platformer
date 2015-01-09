package com.zarates.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController(){
        //gets the height and width of screen
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height/width));//this is for how many tiles display on screen and does something with the aspect
        camera.position.set(camera.viewportWidth/ 2f, camera.viewportHeight/ 2f,0);//it changes the points on the graph so the camera view can change
    }

    public static void update(){
        camera.update();// it updates the camera
    }

    public static void resize(int width, int height){
        camera.viewportWidth = 14f;//new height and width of window
        camera.viewportHeight = 14f * height / width;//new window size
        camera.update();//updates the camera
    }
}
