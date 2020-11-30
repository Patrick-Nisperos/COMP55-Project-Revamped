package starter;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.util.ArrayList;

public class Gameplay extends GraphicsProgram implements ActionListener,KeyListener{
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 900;
	
	//Setting levels
	private Level levelOne = new Level(1);
	private Level levelTwo = new Level(2);
	private Level levelThree = new Level(3);
	
	//List of Images of different screens
	private GImage mainMenuScreen = new GImage("officialMainMenu.png");
	private GImage pauseScreen = new GImage("pauseScreen.png");
	private GImage controlScreen = new GImage("controlScreen.png");
	private GImage winScreen = new GImage("singlePlayerWinScreen.png");
	private GImage loseScreen = new GImage("singlePlayerLoseScreen.png");
	private GImage scoreboardScreen = new GImage("scoreBoardScreen.png");
	
	//List of Different buttons for different screens
	private GRect singlePlayerButton = new GRect(500, 160, 270, 50);
	private GRect coopButton = new GRect(880, 160, 180, 50);
	private GRect scoreBoardButton = new GRect(500, 235, 270, 50);
	private GRect controlButton = new GRect(880, 235, 200, 50);
	private GRect exitButton = new GRect(500, 310, 120, 50);
	private GRect pauseReturnMainMenuButton = new GRect(480,215,280,50); //pause screen return main menu button
	private GRect resumeButton = new GRect(860, 215, 220, 50);
	private GRect controlReturnMainMenuButton = new GRect(1240,780,280,50); //control screen return main menu button
	private GRect scoreReturnMainMenuButton = new GRect(1240,780,280,50); //scoreboard screen return main menu button
	
	//List of booleans for buttons
	private boolean singlePlayerButtonPressed = false;
	private boolean coopButtonPressed = false;
	private boolean scoreBoardButtonPressed = false;
	private boolean controlButtonPressed = false;
	private boolean pauseButtonPressed = false;
	private boolean pauseReturnMainMenuPressed = false;
	private boolean resumeButtonPressed = false;
	private boolean exitButtonPressed = false;
	private boolean controlReturnMainMenuPressed = false;
	private boolean scoreReturnMainMenuPressed = false;
	
	//List of different timers
	private Timer mainMenuTimer = new Timer(1000, this);
	private Timer pauseTimer = new Timer(1000, this);
	private Timer singlePlayerTimer = new Timer(50, this);
	private Timer controlScreenTimer = new Timer(1000, this);
	private Timer scoreboardScreenTimer = new Timer(1000,this);
	private Timer gameTimer = new Timer(1000, this); //used to track if user is in game
	private Timer animationTimer = new Timer(1000, this);

	
	//List of lists of shields and enemies and enemy movement
	private ArrayList<GRect> enemyRectangles = new ArrayList<GRect>();
	private ArrayList<GRect> playerShields = new ArrayList<GRect>();
	private int enemyMovementSpeed = -4;
	
	//List of Single player tank movement variables, score, and image
	private GImage singlePlayerTank = new GImage("blue tank.png");
	private int singlePlayerTankStartingXCoord = 800;
	private int singlePlayerTankStartingYCoord = 800 ;
	private int singlePlayerArrIndex = 0;
	private int singlePlayerSpeedX = 6; 
	private ArrayList<Integer> singlePlayerScores = new ArrayList<Integer>();
	private int gameNumber = -1;
	private GLabel singlePlayerScoreLabel = new GLabel("Score: ", 30, 600);
	
	private ArrayList<Projectile> singlePlayerProjectiles = new ArrayList<Projectile>();

	
	//picture for the shield and enemyTanks
	private GImage Shield1 = new GImage("Rock px.png", 250, 650);
	private GImage Shield2 = new GImage("Rock px.png", 1150, 650);
	private ArrayList<GImage> enemyImages = new ArrayList<GImage>();
	    
	//Pictures and integers for the animation
	private GImage explode1 = new GImage("Explosion1.png", 100, 200);
	private GImage explode2 = new GImage("Explosion2.png", 100, 200);
	private GImage explode3 = new GImage("Explosion3.png", 100, 200);
	private GImage userFirePic = new GImage("userFirePic.png", 100, 200);
	private GImage levelOneBackground1 = new GImage("snow top view.jpg");
	private GImage levelOneBackground2 = new GImage("snow top view2.jpg");
	private int explodeNumber = 0;
	private int animateNumber = 0;
	private int singlePlayerFireNumber = 0; //used for user fire delay
	
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
		
		if(scoreboardScreenTimer.isRunning()) {
			//scoreboard screen return to main menu button
			if(e.getX() < scoreReturnMainMenuButton.getX() + scoreReturnMainMenuButton.getWidth() && e.getX() >= scoreReturnMainMenuButton.getX() 
					&& e.getY() < scoreReturnMainMenuButton.getY() + scoreReturnMainMenuButton.getHeight() &&
					e.getY() >= scoreReturnMainMenuButton.getY()) {
				scoreReturnMainMenuPressed = true;
			}
		}
		
		return;
	}
	
	//Key Input Listeners
	public void keyPressed(KeyEvent e) {
		if(gameTimer.isRunning()) {
			if (e.getKeyCode() == 27) {
				System.out.println("You pressed *esc* ");
				singlePlayerTimer.start();
				pauseGame();
			}
		}
		//Single Player Tank Movement and Fire
	     if(singlePlayerTimer.isRunning()) {
			int moveKeyCode = e.getKeyCode();
	        if(moveKeyCode == 68){ //"d" right movement
	        	if(singlePlayerTank.getX() < 1520) {// Line to ensure tank doesn't leave boundaries
		        	singlePlayerTank.move(singlePlayerSpeedX,0);
		        	singlePlayerTank.setImage("Blue tank right.png");
	        	}
	        }
	        if(moveKeyCode == 65) { //"a" left movement
	        	if(singlePlayerTank.getX() > -10) { // Line to ensure tank doesn't leave boundaries
		        	singlePlayerTank.move(-1 * singlePlayerSpeedX,0);
		        	singlePlayerTank.setImage("Blue tank left.png");
	        	}
	        }    
	     }
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 87) { 
			System.out.println("You released key code: " + e.getKeyCode()); 
			System.out.println("you pressed *w* fire projectile");
        	singlePlayerTank.setImage("blue tank.png");
			singlePlayerFireNumber++;
			if(singlePlayerFireNumber == 2) { // Delays the user fire
				singlePlayerUserFire();
				singlePlayerFireNumber = 0;
			}


		}
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
		//pause screen button recognition 
		if(pauseTimer.isRunning()) {
			if(pauseReturnMainMenuPressed) {
				singlePlayerTimer.stop();
				gameTimer.stop();
				pauseTimer.stop();
				pauseReturnMainMenuPressed = false;
				displayMenu();
			}
			if(resumeButtonPressed) {
				pauseTimer.stop();
				singlePlayerTimer.stop();
				gameTimer.stop();
				//Temporary here, later we must figure out how to resume a game properly.
				singlePlayerMode();

			}
			
		}
		if(singlePlayerTimer.isRunning()) {
			enemyMovement();
			singlePlayerMoveProjectile();
			singlePlayerObjHit();
			if(enemyImages.isEmpty() && pauseTimer.isRunning() == false) {
				userWin();
			}
		}
		if(animationTimer.isRunning()) {
			animateNumber++;
			if(animateNumber % 7 == 6) {
				deleteUserFirePic();
			}
			if(animateNumber == 20) {
				deleteEnemyExplosion();
				animateNumber = 0;
			}
			//Move the background
			levelOneBackground1.move(-2, 0);
			levelOneBackground2.move(-2, 0);
			if(levelOneBackground1.getX() <= -1600) {
				levelOneBackground1.setLocation(1600,0);
			}
			if(levelOneBackground2.getX() <= -1600) {
				levelOneBackground2.setLocation(1600,0);
			}
		}
		//control screen button recognition
		if(controlScreenTimer.isRunning()) {
			if(controlReturnMainMenuPressed) {
				gameTimer.stop();
				controlScreenTimer.stop();
				controlReturnMainMenuPressed = false;
				displayMenu();
			}
		}
		//scoreboard screen button recognition
		if(scoreboardScreenTimer.isRunning()) {
			if(scoreReturnMainMenuPressed) {
				gameTimer.stop();
				scoreboardScreenTimer.stop();
				scoreReturnMainMenuPressed = false;
				displayMenu();
			}
		}
		
	}
	
	
	public void run() { // Main Function
		displayMenu();
	}
	
	public void displayMenu() { //displays menu screen here
		System.out.println("Main menu entered.");
		removeAll();
		add(mainMenuScreen);
		add(singlePlayerButton);
		add(coopButton);
		add(scoreBoardButton);
		add(controlButton);
		add(exitButton);
		mainMenuTimer.start();
		
	}
	
	public void singlePlayerMode() {
		gameTimer.start();
		singlePlayerTimer.start();
		animationTimer.start();
		System.out.println("Single player mode entered.");
		removeAll(); //Removes everything from screen.
		
		//Level one initialize
		levelOneBackground1.setSize(1600,900);
		levelOneBackground2.setSize(1600,900);
		levelOneBackground1.setLocation(0,0);
		levelOneBackground2.setLocation(1600,0);
		add(levelOneBackground1);
		add(levelOneBackground2);
		levelOne.initLevel();
		levelOne.printArrayList();
		enemyRectangles = levelOne.createEnemyRect();
		enemyImages = levelOne.createEnemyImages();
		pasteEnemyImages();
		pasteEnemies();
		System.out.println("Size of GRect Array: " + enemyRectangles.size());
		playerShields = levelOne.placeShield();
		pasteShields();
	    add(singlePlayerTank,singlePlayerTankStartingXCoord,singlePlayerTankStartingYCoord);
	    singlePlayerScores.add(0);
	    gameNumber++;
		singlePlayerScoreLabel.setFont("AgencyFB-Bold-40");
	    add(singlePlayerScoreLabel);
	   
	}
	
	public void pauseGame() { //Displays a screen when game is paused
		pauseTimer.start();
		System.out.println("Game Paused");
		removeAll();
		enemyRectangles.clear();
		enemyImages.clear();
		singlePlayerProjectiles.clear();
		pauseScreen.setSize(1600, 900);
		add(pauseScreen);
		add(pauseReturnMainMenuButton);
		add(resumeButton);

	}
	
	public void displayScoreBoard() { //Displays the scoreboard
		scoreboardScreenTimer.start();
		System.out.println("Scoreboard entered.");
		removeAll(); //Removes everything from screen.
		scoreboardScreen.setSize(1600,900);
		add(scoreboardScreen);
		add(scoreReturnMainMenuButton);
		for(int i = 0; i < singlePlayerScores.size(); i++) {
			GLabel score = new GLabel("Score: " + singlePlayerScores.get(i), 900, 300 + (i * 100)); 
			score.setFont("AgencyFB-Bold-50");
			add(score);
			GLabel gameNumber = new GLabel("Game # " + (i + 1), 500, 300 + (i * 100));
			gameNumber.setFont("AgencyFB-BOLD-50");
			add(gameNumber);
		}
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
		System.out.println("User Win Entered");
		removeAll(); //Removes everything from screen.
		winScreen.setSize(1600,900);
		add(winScreen);
	}
	
	public void userLose() { //displays the screen when the user loses
		
	}
	
	public void userMovement() { //controls the user movement mechanics
		
	}
	
	public void enemyMovement() { //controls the enemy movement mechanics
		for(GRect temp : enemyRectangles) {
			if(temp.getX() == 0) {
				enemyMovementSpeed = 4;
			}if(temp.getX() == 1548) {
				enemyMovementSpeed = -4;
			}
			temp.move(enemyMovementSpeed, 0);	
		}
		for(GImage temp : enemyImages) {
			if(temp.getX() == 0) {
				enemyMovementSpeed = 4;
			}if(temp.getX() == 1548) {
				enemyMovementSpeed = -4;
			}
			temp.move(enemyMovementSpeed, 0);	
		}
	}
	
	public void singlePlayerUserFire() { //controls the user fire mechanics
		Projectile temp = new Projectile(10,50,40);
		temp.setCoord(singlePlayerTank.getX() + 34, singlePlayerTank.getY());
		add(temp.getProjectilePic());
		singlePlayerProjectiles.add(temp);
		userFirePic.setLocation(singlePlayerTank.getX() + 9, singlePlayerTank.getY() - 45);
		add(userFirePic);
		return;
	}
	
	public void singlePlayerMoveProjectile() {
		for (Projectile temp:singlePlayerProjectiles) {
			temp.getProjectilePic().move(0, -1 * temp.getSpeed());
		}
	}
	public void singlePlayerObjHit() {
		for(int i = 0; i < singlePlayerProjectiles.size(); i++) {
			Projectile temp = singlePlayerProjectiles.get(i);
			double coordX=temp.getProjectilePic().getX()+temp.getProjectilePic().getWidth()+1;
			double coordY=temp.getProjectilePic().getY()+(temp.getProjectilePic().getHeight()/2);
			if(getElementAt(coordX,coordY) instanceof GImage) {
				for(GImage temp2 : enemyImages) {
					if(temp2==getElementAt(coordX,coordY)) {
						remove(temp2);
						remove(temp.getProjectilePic());
						animateHit(coordX, coordY);
						singlePlayerProjectiles.remove(temp);
						calculateScore();
						displayScoreInGame();
					
					}
				}
				if(getElementAt(coordX,coordY)==Shield1) {
					remove(Shield1);
				}
				else if(getElementAt(coordX,coordY)==Shield2) {
					remove(Shield2);
				}
				//remove(getElementAt(coordX, coordY));
				//singlePlayerProjectiles.remove(temp);
			}
		}
	}
	
	public void animateHit(double coordX, double coordY) {
		if(explodeNumber == 0) {
			explode1.setLocation(coordX - 50, coordY - 70);
			add(explode1);
			explodeNumber++;
			System.out.println("explode 1");
			return;
		}
		if(explodeNumber == 1) {
			explode2.setLocation(coordX - 50, coordY - 70);
			add(explode2);
			explodeNumber++;
			System.out.println("explode 2");
			return;
		}
		if(explodeNumber == 2) {
			explode3.setLocation(coordX - 50, coordY - 70);
			add(explode3);
			explodeNumber = 0;
			System.out.println("explode 3");
			return;
		}

	}
	
	public void deleteEnemyExplosion() {
		remove(explode1);
		remove(explode2);
		remove(explode3);
	}
	
	public void deleteUserFirePic() {
		remove(userFirePic);
	}
	
	public void enemyFire() { //controls the enemy fire mechanics
		
	}
	
	public void calculateScore() { //calculates the score of the user
		//we have to put if statemetns showing the increased score if you killed different types of enemies.
		int currentScore = singlePlayerScores.get(gameNumber);
		singlePlayerScores.set(gameNumber, 10 + currentScore);
		System.out.println(singlePlayerScores.get(gameNumber));
	}
	
	public void displayScoreInGame() { //displays the score board in game
		singlePlayerScoreLabel.setLabel("Score: " + singlePlayerScores.get(gameNumber));
		add(singlePlayerScoreLabel);

	}
	
	public void pasteEnemies() {
		for(GRect temp : enemyRectangles) {
			//add(temp);
		}
	}
	public void pasteShields() {
		for(GRect temp : playerShields) {
			//add(temp);
			
		}
		add(Shield1);
		add(Shield2);
	}
	public void pasteEnemyImages() {
		for(GImage temp : enemyImages) {
			add(temp);
		}
	}
}