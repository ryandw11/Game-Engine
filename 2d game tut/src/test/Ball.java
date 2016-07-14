package test;

import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.components.Collider;
import com.ryandw11.core.components.GameObject;

public class Ball extends GameObject{
	
	boolean left = true;
	float speedY = 0;
	
	public Ball(int x, int y){
		setTag("ball");
		this.x = x;
		this.y = y;
		w = 16;
		h = 16;
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (left){
			x -= dt * 50;
		}
		else{
			x += dt * 50;
		}
		y += speedY;
		
		if(y < 0){
			y = 0;
			speedY *= -1;
		}
		if(y + h > gc.getHeight()){
			y = gc.getHeight() - h;
			speedY *= -1;
		}
			
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawRect((int)x, (int)y, (int)w, (int)h, 0xff00ff00);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void componentEvent(String name, GameObject object) {
		if(name.equalsIgnoreCase("collider")){
			if(object.getX() < x){
				left = false;
			}
			else{
				left = true;
			}
			
			speedY =  -((object.getY() + (object.getH() / 2)) - (y + (h / 2))) / (object.getH() / 2);
		}
		
	}
	
}
