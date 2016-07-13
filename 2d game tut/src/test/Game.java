package test;

import java.awt.event.KeyEvent;

import com.ryandw11.core.AbstractGame;
import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Input;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.fx.Image;
import com.ryandw11.core.fx.Light;
import com.ryandw11.core.fx.SoundClip;

public class Game extends AbstractGame{
	
	private Image image = new Image("/test.png");
	
	private Light light = new Light(0xffff0000, 60);
	private Light light1 = new Light(0xff00ff00, 60);
	private Light light2 = new Light(0xff0000ff, 60);
	
	private SoundClip clip = new SoundClip("/recording.wav");
	
	public static void main(String args[]){
		GameContainer gc = new GameContainer(new Game());
		gc.setWidth(320);
		gc.setHight(240);
		gc.setScale(3);
		gc.start();
	}
	
	float x = 0;

	@Override
	public void update(GameContainer gc, float dt) {
		if(Input.isKeyPressed((KeyEvent.VK_A))){
			//x += dt * 50;
			if(!clip.isRunning())
			clip.loop();
			else{
				clip.stop();
			}
		}
		if(Input.isKeyPressed((KeyEvent.VK_D))){
			clip.play();
		}
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, 0, 0); // do 128 x 128
		r.drawLight(light, Input.getMouseX(), Input.getMouseY());
		r.drawLight(light1, 50, 50);
		r.drawLight(light2, 75, 50);
		
		
	}
}
