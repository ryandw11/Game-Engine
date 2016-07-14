package com.ryandw11.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//             Hover over and add unimplemented methods!
public class Input implements KeyListener, MouseListener, MouseMotionListener{
	
	private GameContainer gc;
	
	private boolean[] keys = new boolean[256];
	private boolean[] keysLast = new boolean[256];
	
	private boolean[] buttions = new boolean[5];
	private boolean[] buttionsLast = new boolean[5];
	
	private int mouseX, mouseY;
	
	public Input(GameContainer gc){
		this.gc = gc;
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
	}
	
	
	
	public void update(){
		keysLast = keys.clone();
		buttionsLast = buttions.clone();
	}
	
	
	public boolean isKey(int keyCode){
		return keys[keyCode];
	}
	
	public boolean isKeyPressed(int keyCode){
		return keys[keyCode] && !keysLast[keyCode];
	}
	public boolean isKeyReleased(int keyCode){
		return !keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isButtion(int buttion){
		return buttions[buttion];
	}
	public boolean isButtionPressed(int buttion){
		return buttions[buttion] && !buttionsLast[buttion];
	}
	public boolean isButtionReleased(int buttion){
		return !buttions[buttion] && buttionsLast[buttion];
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int) (e.getX() / gc.getScale());
		mouseY = (int) (e.getY() / gc.getScale());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int) (e.getX() / gc.getScale());
		mouseY = (int) (e.getY() / gc.getScale());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttions[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttions[e.getButton()] = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}



	public int getMouseX() {
		return mouseX;
	}



	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}



	public int getMouseY() {
		return mouseY;
	}



	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	
}
