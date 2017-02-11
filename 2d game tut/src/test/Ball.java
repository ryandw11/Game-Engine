
package test;

import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.components.Collider;
import com.ryandw11.core.components.Component;
import com.ryandw11.core.components.GameObject;

public class Ball
extends GameObject {
    private int enemyScore = 0;
    private int playerScore = 0;
    boolean left = true;
    float speedY = 0.0f;

    public Ball(int x, int y) {
        this.setTag("ball");
        this.x = x;
        this.y = y;
        this.w = 16.0f;
        this.h = 16.0f;
        this.addComponent(new Collider());
    }

    public void nextPoint(String type) {
        if (type.equalsIgnoreCase("enemy")) {
            ++this.enemyScore;
        }
        if (type.equalsIgnoreCase("player")) {
            ++this.playerScore;
        }
    }

    @Override
    public void update(GameContainer gc, float dt) {
        this.x = this.left ? (this.x -= dt * 200.0f) : (this.x += dt * 200.0f);
        this.y += this.speedY;
        if (this.y < 0.0f) {
            this.y = 0.0f;
            this.speedY *= -1.0f;
        }
        if (this.y + this.h > (float)gc.getHeight()) {
            this.y = (float)gc.getHeight() - this.h;
            this.speedY *= -1.0f;
        }
        if (this.x < 0.0f) {
            this.nextPoint("enemy");
            this.x = 156.0f;
            this.y = 116.0f;
        }
        if (this.x > 320.0f) {
            this.nextPoint("player");
            this.x = 156.0f;
            this.y = 116.0f;
        }
        this.updateComponents(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawRect((int)this.x, (int)this.y, (int)this.w, (int)this.h, -16711936);
        r.drawString("Enemy's Score: " + this.enemyScore, -1, 250, 0);
        r.drawString("Your Score: " + this.playerScore, 16777215, 0, 0);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void componentEvent(String name, GameObject object) {
        if (name.equalsIgnoreCase("collider")) {
            this.left = object.getX() >= this.x;
            this.speedY = (- object.getY() + object.getH() / 2.0f - (this.y + this.h / 2.0f)) / (object.getH() / 2.0f);
        }
    }
}

