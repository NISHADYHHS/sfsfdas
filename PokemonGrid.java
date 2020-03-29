import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;




public class PokemonGrid {
	private String filename;
	private boolean[][] grid;
	private int y;
	private int x;
	private boolean moved = false;
	private boolean encounter = false;
	private boolean encountered = false;
	private String pokemonName;
	
	
	
	public PokemonGrid() {
		grid = new boolean[100][100];
	
	}


	public PokemonGrid(String filename) {
		this.filename = filename;
		grid = new boolean[100][100];
	
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public boolean getStatus() {
		
		return encountered;
	}
	
	public String getPokemonName() {
		
		return pokemonName;
	}


	
	public void drawthing(int x, int y) {
		if(moved == false) {
		grid[x][y] = true;
		this.x = x;
		this.y = y;
		}
		
	}
	
	public void movething(int dirx, int diry) {
		
		moved = false;
		grid[x][y] = false;
		grid[x + dirx][y + diry] = true;
		this.x = x + dirx;
		this.y = y + diry;
		
		if(x > 10 && x < 15 && y > 10 && y < 15) {
			
			
			encounter = true;
			
		}
		else {
			
			encounter = false;
		}
	}
	
	public boolean encounter() {
		
		
		if(encounter == true) {
			int r = (int)(Math.random() * 15);
			if(r == 1) {
			
				System.out.println("u found a charizard");
				encountered = true;
				pokemonName = "charizard";
				return true;
			
			}
			else if(r == 2) {
			
			
				System.out.println("u found a blastoise");
				encountered = true;
				pokemonName = "blastoise";
				return true;
			}
			else if(r == 0) {
				
				
				System.out.println("u found a serperior");
				encountered = true;
				pokemonName = "serperior";
				return true;
			}
			else if(r == 3) {
				
				
				System.out.println("u found a venosaur");
				encountered = true;
				pokemonName = "venosaur";
				return true;
			}
			else {
				System.out.println("u found nothing");
				encountered = false;
				return true;
			}
			
		}
		else {
			
			System.out.println("not on grass");
			return false;
		}
	}

	
	public void drawBattleScreen(PApplet marker,String pokemon) {
		
		marker.textSize(40);
		marker.text("YOU", 200, 500);
		marker.text(pokemon, 500, 100);
		marker.stroke(0);
		marker.fill(0,255,30);
		marker.rect(500,700, 100, 50);
	}
	
	
	public void draw(PApplet marker, float x, float y, float width, float height) {
		
		float placeholdery = y;
		int count = 0;
		
		for(int i = 0; i < grid.length; i++) {
			count = 0;
			
			marker.fill(255,255,255);
			for(int j = 0; j < grid[0].length; j++) {
				
				marker.rect(x, y, 40, 40);
				count = 1;
				y += 40 + count;
				
				
				if(grid[i][j] == true) {
					marker.fill(0,0,255);
					
				}
				else {
					
					marker.fill(255,255,255);
					
					if(i > 10 && i < 15 && j > 10 && j < 15) {
						
						marker.fill(255,0,0);
						encounter = true;
						//System.out.println(encounter);
					}
					else {
						
						encounter = false;
					}
				}
				
				
						

			//	marker.fill(255);
				if(j == grid.length - 1) {
					x += 40 +  count;
					y = placeholdery ;
					
				}
			}
		}
	}
	
	
	
	
}