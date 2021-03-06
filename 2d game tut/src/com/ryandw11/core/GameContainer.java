package com.ryandw11.core;

public class GameContainer  implements Runnable{
	
	private Thread thread;
	private AbstractGame game;
	private Window window;
	private Renderer renderer;
	private Input input;
	
	
	
	private int width = 320, height = 240;
	private float scale = 2.0f;
	private String title = "A Game - By Ryan";
	private double frameCap = 1.0 / 60.0;
	
	private boolean isRunning = false;
	
	public GameContainer(AbstractGame game){
		this.game = game;
	}
	
	public void start(){
		if(isRunning)return;
		
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop(){
		if(!isRunning) return;
		
		isRunning = false;
	}
	
	public void run(){
		isRunning = true;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while(isRunning){
			boolean render = false;
			
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;  //frame counter
			
			while(unprocessedTime >= frameCap){
				game.update(this, (float) frameCap);
				input.update();
				unprocessedTime -= frameCap;
				render = true;
				
				if(frameTime >= 1){ //frame counter
					frameTime = 0;
					fps = frames;
					frames = 0; 
				}
			}
			if(render){
				renderer.clear();
				game.render(this, renderer);
				renderer.combineMaps();
				renderer.drawString("FPS-" + fps, 0xffffffff, 0, 0);
				window.update();
				frames++;
			}
			else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	private void cleanUp(){
		window.cleanUp();
	}
	
	//Do not copy. Do step 2 on notes

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
//===================================================================[Do step 4]=============================================================
	public Window getWindow() {
		return window;
	}
}
