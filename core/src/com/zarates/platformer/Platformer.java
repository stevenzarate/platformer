package com.zarates.platformer;

import com.badlogic.gdx.Game;
import com.zarates.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
