package test;

import java.awt.event.KeyEvent;
import java.util.Stack;

import com.ryandw11.core.AbstractGame;
import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Input;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.components.State;
import com.ryandw11.core.fx.Image;
import com.ryandw11.core.fx.Light;
import com.ryandw11.core.fx.ShadowType;
import com.ryandw11.core.fx.SoundClip;

public class GameManager extends AbstractGame{
	
	
	
	
	public GameManager(){
		push(new PlayState());
	}
	

	@Override
	public void update(GameContainer gc, float dt) {
		peek().update(gc, dt);
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		peek().render(gc, r);
	}
	

	
	public static void main(String args[]){
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHight(240);
		gc.setScale(3);
		gc.setClearScreen(true);
		gc.setDynamicLights(false);
		gc.setLightEnable(false);
		gc.start();
	}
}
