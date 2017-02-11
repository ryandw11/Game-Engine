package test;

import com.ryandw11.core.AbstractGame;
import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Input;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.components.State;
import test.PlayState;

public class GameManager
extends AbstractGame {
    private boolean controls = false;

    public GameManager() {
        this.push(new PlayState());
    }

    @Override
    public void update(GameContainer gc, float dt) {
        this.peek().update(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        this.peek().render(gc, r);
        r.drawString("PONG PONG PING - Single Player", -16711936, 90, 0);
        if (gc.getInput().isKey(90)) {
            boolean bl = this.controls = !this.controls;
        }
        if (this.controls) {
            r.drawString("Controls-", -1, 120, 40);
            r.drawString("Single Player: w - Move up; s - Move down", -1, 90, 55);
            r.drawString("MultiPlayer - ", -1, 90, 65);
            r.drawString("Player 1: W - Move up; S - Move down", -1, 90, 75);
            r.drawString("Player 2: Arrow Up - Move up; Arrow Down - Move down", -1, 90, 85);
        }
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.setWidth(320);
        gc.setHight(240);
        gc.setScale(3.0f);
        gc.setClearScreen(true);
        gc.setDynamicLights(false);
        gc.setLightEnable(false);
        gc.start();
    }
}

