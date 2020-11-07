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
	private GRect coopButton;
	private GRect scoreBoardButton;
	private GRect controlButton;
	private GRect exitButton;
	private boolean singlePlayerButtonPressed = false;
	private boolean coopButtonPressed = false;
	private boolean scoreBoardButtonPressed = false;
	private boolean controlButtonPressed = false;
	
	private Timer mainMenuTimer = new Timer(1000, this);
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	//**** Input Listeners ****
	public void mousePressed(MouseEvent e) {
		System.out.println("X Click: " + e.getX() + " Y Click: " + e.getY());
		//Single Player Button
		if(e.getX() < singlePlayerButton.getX() + singlePlayerButton.getWidth() && e.getX() >= singlePlayerButton.getX() 
				&& e.getY() < singlePlayerButton.getY() + singlePlayerButton.getHeight() &&
				e.getY() >= singlePlayerButton.getY()) {
			singlePlayerButtonPressed = true;
		}
		//Coop Player Button
		if(e.getX() < coopButton.getX() + coopButton.getWidth() && e.getX() >=coopButton.getX() 
				&& e.getY() < coopButton.getY() + coopButton.getHeight() &&
				e.getY() >= coopButton.getY()) {
			coopButtonPressed = true;
		}
		//score board button
		if(e.getX() < scoreBoardButton.getX() + scoreBoardButton.getWidth() && e.getX() >= scoreBoardButton.getX() 
				&& e.getY() < scoreBoardButton.getY() + scoreBoardButton.getHeight() &&
				e.getY() >= scoreBoardButton.getY()) {
			scoreBoardButtonPressed = true;
		}
		//Control button
		if(e.getX() < controlButton.getX() + controlButton.getWidth() && e.getX() >= controlButton.getX() 
				&& e.getY() < controlButton.getY() + controlButton.getHeight() &&
				e.getY() >= controlButton.getY()) {
			controlButtonPressed = true;
		}
		//Exit button
		if(e.getX() < exitButton.getX() + exitButton.getWidth() && e.getX() >= exitButton.getX() 
				&& e.getY() < exitButton.getY() + exitButton.getHeight() &&
				e.getY() >= exitButton.getY()) {
			System.out.println("Exiting game...");
			System.exit(0);
		}
		
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
		//Main menu button click recognition
		if (mainMenuTimer.isRunning()) {
			if(singlePlayerButtonPressed) {
				singlePlayerMode();
				mainMenuTimer.stop();
			}
			if(coopButtonPressed) {
				coopMode();
				mainMenuTimer.stop();
			}
			if(scoreBoardButtonPressed) {
				displayScoreBoard();
				mainMenuTimer.stop();
			}
			if(controlButtonPressed) {
				displayControlScreen();
				mainMenuTimer.stop();
			}
			
		}		
		
	}
	
	
	public void run() { // Main Function
		addMouseListeners();
		mainMenuScreen = new GImage("officialMainMenu.png");
		singlePlayerButton = new GRect(500, 160, 270, 50);
		coopButton = new GRect(880, 160, 180, 50);
		scoreBoardButton = new GRect(500, 235, 270, 50);
		controlButton = new GRect(880, 235, 200, 50);
		exitButton = new GRect(500, 310, 120, 50);
		displayMenu();

	}
	
	public void displayMenu() { //displays menu screen here
		add(mainMenuScreen);
		add(singlePlayerButton);
		add(coopButton);
		add(scoreBoardButton);
		add(controlButton);
		add(exitButton);
		
		mainMenuTimer.start();
		
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
	
	public void pauseGame() { //Displays a screen when game is paused
		
	}
	
	public void displayScoreBoard( ) { //Displays the scoreboard
		System.out.println("Scoreboard entered.");
		removeAll(); //Removes everything from screen.
	}
	
	public void coopMode() {
		System.out.println("Coop player mode entered.");
		removeAll(); //Removes everything from screen.
	}
	
	public void displayControlScreen() {
		System.out.println("controlScreen.");
		removeAll(); //Removes everything from screen.
		
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