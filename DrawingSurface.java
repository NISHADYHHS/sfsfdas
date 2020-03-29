


import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private PokemonGrid board;
	private int spawnpointx;
	private int spawnpointy;

	private boolean moved = false;
	private String pokemonName;
	private boolean battlescene = false;
	
	private NButton run = new NButton(500, 700);
	public DrawingSurface() {
		board = new PokemonGrid();
		
	}
	
	
	public void setup() {
	}
	

	public void draw() { 
		background(255);   
		fill(0);
		textAlign(LEFT);
		textSize(12);
		
	
		
		
		if(battlescene == false) {
		
		
		if (board != null) {
			board.draw(this, 0, 0, 20, 20);
			
			if(moved == false) {
				
				board.drawthing(0, 0);
				
				}
		}
		
		
		
		}
		else {
			
			
			board.drawBattleScreen(this, pokemonName);
			run.drawButton(this, 100, 50, "run");
		}
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			
			if(battlescene == true) {
				
				if(mouseX > run.getX() && mouseX < run.getX() + run.getL() && mouseY > run.getY() && mouseY < run.getY() + run.getW()) {
					run.mouseAnimation(this, 100, 50);
					battlescene = false;
				}
			}
			
		} 
	}
	
	
	
	
	
	public void keyPressed() {
		if(battlescene == false) {
		if (keyCode == KeyEvent.VK_DOWN) {
			
			if(board.getY() < 21) {
			board.movething(0, 1);
			moved = true;
				if(board.encounter()) {
				
					battlescene = board.getStatus();
					pokemonName = board.getPokemonName();
				}
			}
		} else if (keyCode == KeyEvent.VK_UP) {
			
			if(board.getY() > -1) {
			board.movething(0, -1);
			moved = true;
			if(board.encounter()) {
				
				battlescene = board.getStatus();
				pokemonName = board.getPokemonName();
			}//
			}
		}else if (keyCode == KeyEvent.VK_LEFT) {
			if(board.getX() > 0) {
			board.movething(-1, 0);
			moved = true;
			if(board.encounter()) {
				
				battlescene = board.getStatus();
				pokemonName = board.getPokemonName();
			}
			}
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			if(board.getX() < 21) {
			board.movething(1, 0);
			moved = true;
			if(board.encounter()) {
				
				battlescene = board.getStatus();
				pokemonName = board.getPokemonName();
			}
			}
		}
	}

	
}
}










