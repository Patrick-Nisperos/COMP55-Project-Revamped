package starter;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Gameplay extends GraphicsProgram {
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 900;
	private int userMovementSpeed = 0;
	private int enemyMovementSpeed = 0;
	private GImage mainMenuScreen;
	private GRect singlePlayerButton;
	private boolean singlePlayerButtonPressed = false;
	private Timer mainTimer = new Timer(1000, this);
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	//**** Input Listeners ****
	public void mousePressed(MouseEvent e) {
		System.out.println("X Click: " + e.getX() + " Y Click: " + e.getY());
		if(e.getX() < singlePlayerButton.getX() + singlePlayerButton.getWidth() && e.getX() >= singlePlayerButton.getX() 
				&& e.getY() < singlePlayerButton.getY() + singlePlayerButton.getHeight() &&
				e.getY() >= singlePlayerButton.getY()) {
			System.out.println("Works!");
			singlePlayerButtonPressed = true;
		}
		System.out.println(singlePlayerButton.getX() + singlePlayerButton.getWidth());
		System.out.println(singlePlayerButton.getY() + singlePlayerButton.getHeight());
		
		
		return;
	}
	public void keyTypes(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
//		char i = e.getKeyChar();
//		System.out.println(i);
	}
	
	public void keyReleased(KeyEvent e) {
		
	}	
	
	public void actionPerformed(ActionEvent e) {
		if(singlePlayerButtonPressed) {
			singlePlayerMode();
			mainTimer.stop();
		}
		
	}
	
	
	public void run() { // Main Function
		addMouseListeners();
		mainTimer.start();
		displayMenu();

	}
	public void displayMenu() { //displays menu screen here
		mainMenuScreen = new GImage("officialMainMenu.png");
		add(mainMenuScreen);
		singlePlayerButton = new GRect(530, 160, 230, 50);
		add(singlePlayerButton);
		
		//Tank Size Reference
//		GRect rectangle = new GRect(200, 200, 75, 75);
//		add(rectangle);
//		GImage Tank = new GImage ("blue tank.png", 200, 200);
//		add(Tank);
	}
	
	public void singlePlayerMode() {
		System.out.println("Single player mode entered.");
		removeAll(); //Removes everything from screen.
		
		
		//If level is done or player decides to leave
		boolean endLevel = false;
		if(endLevel) {
			displayMenu();
		}
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