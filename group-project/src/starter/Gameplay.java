package starter;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends GraphicsProgram {
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 900;
	private int userMovementSpeed = 0;
	private int enemyMovementSpeed = 0;
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	public void run() { // Main Function
		GRect rect = new GRect(20, 20, 50, 40);
		add(rect);
	}

	public void displayMenu() { //displays menu screen here
		
	}
	
	public void userWin() { //displays the screen when the user wins
		
	}
	
	public void userLose() { //displays the screen when the user loses
		
	}
	
	public void userMovement() { //controls the user movement mechanics
		
	}
	
	public void enemyMovement() { //controls the enemy movement mechanics
		
	}
	
	public void userFire() { //controls the user fire mechanics
		
	}
	
	public void enemyFire() { //controls the enemy fire mechanics
		
	}
	
	public int calculateScore() { //calculates the score of the user
		int score = 0;
		return score;
	}
	
	public void displayScoreboard() { //displays the score board screen
		
	}
	
}