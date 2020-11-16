package starter;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.ArrayList;

public class Gameplay extends GraphicsProgram implements ActionListener,KeyListener{
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 900;
	private int userMovementSpeed = 0;
	private int enemyMovementSpeed = 4;
	private GImage mainMenuScreen = new GImage("officialMainMenu.png");
	private GImage pauseScreen = new GImage("pauseScreen.png");
	private GImage controlScreen = new GImage("controlScreen.png");
	
	private GRect singlePlayerButton = new GRect(500, 160, 270, 50);
	private GRect coopButton = new GRect(880, 160, 180, 50);
	private GRect scoreBoardButton = new GRect(500, 235, 270, 50);
	private GRect controlButton = new GRect(880, 235, 200, 50);
	private GRect exitButton = new GRect(500, 310, 120, 50);
	private GRect pauseReturnMainMenuButton = new GRect(480,215,280,50); //pause screen return main menu button
	private GRect resumeButton = new GRect(860, 215, 220, 50);
	private GRect controlReturnMainMenuButton = new GRect(1240,780,280,50); //control screen return main menu button
	
	
	private boolean singlePlayerButtonPressed = false;
	private boolean coopButtonPressed = false;
	private boolean scoreBoardButtonPressed = false;
	private boolean controlButtonPressed = false;
	private boolean pauseButtonPressed = false;
	private boolean pauseReturnMainMenuPressed = false;
	private boolean resumeButtonPressed = false;
	private boolean exitButtonPressed = false;
	private boolean controlReturnMainMenuPressed = false;
	
	private Timer mainMenuTimer = new Timer(1000, this);
	private Timer pauseTimer = new Timer(1000, this);
	private Timer singlePlayerTimer = new Timer(50, this);
	
	ArrayList<GRect> enemyRectangles = new ArrayList<GRect>();
	ArrayList<GRect> playerShields = new ArrayList<GRect>();
	private Timer controlScreenTimer = new Timer(1000, this);
	private Timer gameTimer = new Timer(1000, this); //used to track if user is in game
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		addKeyListeners();
		addMouseListeners();
	}
	
	//**** Input Listeners ****
	public void mousePressed(MouseEvent e) {
		System.out.println("X Click: " + e.getX() + " Y Click: " + e.getY());
		if(mainMenuTimer.isRunning()) {
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
				exitButtonPressed = true;
			}
		}

		if(pauseTimer.isRunning()) {
			//pause screen return to main menu button
			if(e.getX() < pauseReturnMainMenuButton.getX() + pauseReturnMainMenuButton.getWidth() && e.getX() >= pauseReturnMainMenuButton.getX() 
					&& e.getY() < pauseReturnMainMenuButton.getY() + pauseReturnMainMenuButton.getHeight() &&
					e.getY() >= pauseReturnMainMenuButton.getY()) {
				pauseReturnMainMenuPressed = true;
			}
			//pause screen resume game button
			if(e.getX() < resumeButton.getX() + resumeButton.getWidth() && e.getX() >= resumeButton.getX() 
					&& e.getY() < resumeButton.getY() + resumeButton.getHeight() &&
					e.getY() >= resumeButton.getY()) {
				resumeButtonPressed = true;
			}
		}
		
		if(controlScreenTimer.isRunning()) {
			//control screen returns to main menu button
			if(e.getX() < controlReturnMainMenuButton.getX() + controlReturnMainMenuButton.getWidth() && e.getX() >= controlReturnMainMenuButton.getX() 
					&& e.getY() < controlReturnMainMenuButton.getY() + controlReturnMainMenuButton.getHeight() &&
					e.getY() >= controlReturnMainMenuButton.getY()) {
				controlReturnMainMenuPressed = true;
			}
		}
		
		return;
	}
	
	public void mouseReleased(KeyEvent e) {
		
	}
	
	public void keyTypes(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(gameTimer.isRunning()) {
			if (e.getKeyCode() == 27) {
				System.out.println("You pressed *esc* ");
				pauseGame();
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		  System.out.println("You released key code: " + e.getKeyCode());
	}	
	
	public void actionPerformed(ActionEvent e) {
		//Main menu button click recognition
		if(mainMenuTimer.isRunning()) {
			if(singlePlayerButtonPressed) {
				mainMenuTimer.stop();
				singlePlayerButtonPressed = false;
				singlePlayerMode();
			}
			if(coopButtonPressed) {
				mainMenuTimer.stop();
				coopButtonPressed = false;
				coopMode();
			}
			if(scoreBoardButtonPressed) {
				gameTimer.stop();
				mainMenuTimer.stop();
				scoreBoardButtonPressed = false;
				displayScoreBoard();
			}
			if(controlButtonPressed) {
				gameTimer.stop();
				mainMenuTimer.stop();
				controlButtonPressed = false;
				displayControlScreen();
			}
			if(exitButtonPressed) {
				System.out.println("Exiting game...");
				System.exit(0);
			}
	
		}		
		if(pauseTimer.isRunning()) {
			if(pauseReturnMainMenuPressed) {
				gameTimer.stop();
				pauseTimer.stop();
				pauseReturnMainMenuPressed = false;
				displayMenu();
			}
			if(resumeButtonPressed) {
				pauseTimer.stop();
				//Temporary here, later we must figure out how to resume a game properly.
				singlePlayerMode();

			}
			
		}
		if(singlePlayerTimer.isRunning()) {
			enemyMovement();
		}
		if(controlScreenTimer.isRunning()) {
			if(controlReturnMainMenuPressed) {
				gameTimer.stop();
				controlScreenTimer.stop();
				controlReturnMainMenuPressed = false;
				displayMenu();
			}
		}
		
	}
	
	
	public void run() { // Main Function
		displayMenu();
		
		
	}
	
	public void displayMenu() { //displays menu screen here
		gameTimer.start();
		System.out.println("Main menu entered.");
		removeAll();
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
		singlePlayerTimer.start();
		System.out.println("Single player mode entered.");
		
		removeAll(); //Removes everything from screen.
		Level levelOne = new Level(2);
		levelOne.initLevel();
		levelOne.printArrayList();
		enemyRectangles = levelOne.createEnemyRect();
		pasteEnemies();
		System.out.println("Size of GRect Array: " + enemyRectangles.size());
		playerShields = levelOne.placeShield();
		pasteShields();
		
		//If level is done or player decides to leave
//		boolean endLevel = false;
//		if(endLevel) {
//			singlePlayerTimer.stop();
//			displayMenu();
//		}
	}
	
	public void pauseGame() { //Displays a screen when game is paused
		pauseTimer.start();
		System.out.println("Game Paused");
		removeAll();
		pauseScreen.setSize(1600, 900);
		add(pauseScreen);
		add(pauseReturnMainMenuButton);
		add(resumeButton);

	}
	
	public void displayScoreBoard() { //Displays the scoreboard
		System.out.println("Scoreboard entered.");
		removeAll(); //Removes everything from screen.
	}
	
	public void coopMode() {
		System.out.println("Coop player mode entered.");
		removeAll(); //Removes everything from screen.
		return;
	}
	
	public void displayControlScreen() {
		controlScreenTimer.start();
		System.out.println("controlScreen.");
		removeAll(); //Removes everything from screen.
		controlScreen.setSize(1600,900);
		add(controlScreen);
		add(controlReturnMainMenuButton);
		
	}
	
	public void userWin() { //displays the screen when the user wins
		
	}
	
	public void userLose() { //displays the screen when the user loses
		
	}
	
	public void userMovement() { //controls the user movement mechanics
		
	}
	
	public void enemyMovement() { //controls the enemy movement mechanics
		for(GRect temp : enemyRectangles) {
			if(temp.getX() == 0) {
				enemyMovementSpeed = 4;
			}if(temp.getX() > 1540 && temp.getX() < 1550) {
				enemyMovementSpeed = -4;
			}
			temp.move(enemyMovementSpeed, 0);
		}
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
	
	public void pasteEnemies() {
		for(GRect temp : enemyRectangles) {
			add(temp);
		}
	}
	public void pasteShields() {
		for(GRect temp : playerShields) {
			add(temp);
		}
	}
}