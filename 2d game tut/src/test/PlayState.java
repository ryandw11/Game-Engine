package test;

import com.ryandw11.core.GameContainer;
import com.ryandw11.core.Renderer;
import com.ryandw11.core.components.ObjectManager;
import com.ryandw11.core.components.State;

public class PlayState extends State{
	

	
	
	public PlayState(){
		manager.addObject(new Player(0,0));
		manager.addObject(new Ball(156, 116));
		manager.addObject(new Enemy(304, 0));
	}

	@Override
	public void update(GameContainer gc, float dt) {
	manager.updateobjects(gc, dt);	
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		manager.renderObjects(gc, r);
	}

	@Override
	public void dispose() {
		manager.disposeObjects();
	}

	public ObjectManager getManager() {
		return manager;
	}

	public void setManager(ObjectManager manager) {
		this.manager = manager;
	}
	
}
