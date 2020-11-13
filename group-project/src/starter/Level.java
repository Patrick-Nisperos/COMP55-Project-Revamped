package starter;

import java.util.ArrayList;
import acm.graphics.*;

public class Level {
	private int levelNumber;
	
	private int numberOfEnemiesLight;
	private int numberOfEnemiesMedium;
	private int numberOfEnemiesHeavy;
	private int numberOfPlayers;
	
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Shield> shields = new ArrayList<Shield>();
	ArrayList<CharacterEntity> users = new ArrayList<CharacterEntity>();
	
	Projectile enemyProjectile = new Projectile(5);
	Projectile userProjectile = new Projectile(5);
	Hitbox userHitbox = new Hitbox(50, 70);
	CharacterEntity user = new CharacterEntity(100, 50, false, 800, 800, userProjectile, userHitbox);
	
	Hitbox enemyLightHitbox = new Hitbox(50, 70);
	EnemyType typeLight = new EnemyType(50, 10, enemyLightHitbox, EnemyTypeCode.LIGHT);
	 
	Hitbox enemyMediumHitbox = new Hitbox(60, 80);
	EnemyType typeMedium = new EnemyType(100, 20, enemyMediumHitbox, EnemyTypeCode.MEDIUM);
	 
	Hitbox enemyHeavyHitbox = new Hitbox(80, 100);
	EnemyType typeHeavy = new EnemyType(200, 50, enemyHeavyHitbox, EnemyTypeCode.HEAVY);
	
	Shield tempGameShield1 = new Shield(100, 200, 500, 200, 700);
	Shield tempGameShield2 = new Shield(100, 200, 500, 200, 700);
	
	public Level(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public void createEnemy() {
		
	}
	public GRect createUser() {
		GRect userRect = new GRect(user.getCoordX(), user.getCoordY(), user.getUserHitbox().getHeight(), user.getUserHitbox().getWidth());
		return userRect;
	}
	public void placeShield() {
		
	}
	public void placeScoreSystem() {
		
	}

	
	public int getNumberOfEnemiesLight() {
		return numberOfEnemiesLight;
	}
	public void setNumberOfEnemiesLight(int numberOfEnemiesLight) {
		this.numberOfEnemiesLight = numberOfEnemiesLight;
	}
	public int getNumberOfEnemiesMedium() {
		return numberOfEnemiesMedium;
	}
	public void setNumberOfEnemiesMedium(int numberOfEnemiesMedium) {
		this.numberOfEnemiesMedium = numberOfEnemiesMedium;
	}
	public int getNumberOfEnemiesHeavy() {
		return numberOfEnemiesHeavy;
	}
	public void setNumberOfEnemiesHeavy(int numberOfEnemiesHeavy) {
		this.numberOfEnemiesHeavy = numberOfEnemiesHeavy;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	
	public Enemy makeEnemy(EnemyType type, boolean isDestroyed, int coordX, int coordY, Projectile enemyProjectile) {
		Enemy temp = new Enemy(type, isDestroyed, coordX, coordY, enemyProjectile);
		return temp;
	}
	public void initLevel() {
		if(levelNumber == 1) {
			numberOfEnemiesLight = 21;
			for(int i = 0; i < 22; i++) {
				if(i < 7) { //layer one
					Enemy enemyLight = makeEnemy(typeLight, false, 100 + (20 * i), 100, enemyProjectile);
					enemies.add(enemyLight);
				} if(i > 6 && i < 14) {
					Enemy light2 = makeEnemy(typeLight, false, 100 + (20 * i), 150 , enemyProjectile);
					enemies.add(light2);
				} if(i > 14 && i < 22) {
					Enemy light3 = makeEnemy(typeLight, false, 100 + (20 * i), 200 , enemyProjectile);
					enemies.add(light3);
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
		if(levelNumber == 2) {
			numberOfEnemiesLight = 14;
			numberOfEnemiesMedium = 7;
			for(int i = 0; i < 22; i++) {
				if(i < 7) { //layer one
					Enemy medium = new Enemy(typeMedium, false, 100 + (20 * i), 100 , enemyProjectile);
					enemies.add(medium);
				} if(i > 6 && i < 14) {
					Enemy light1 = new Enemy(typeLight, false, 100 + (20 * i), 150 , enemyProjectile);
					enemies.add(light1);
				} if(i > 14 && i < 22) {
					Enemy light2 = new Enemy(typeLight, false, 100 + (20 * i), 200 , enemyProjectile);
					enemies.add(light2);
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
		
		if(levelNumber == 3) {
			numberOfEnemiesLight = 7;
			numberOfEnemiesMedium = 7;
			numberOfEnemiesHeavy = 7;
			for(int i = 0; i < 22; i++) {
				if(i < 7) { //layer one
					Enemy heavy = new Enemy(typeHeavy, false, 100 + (20 * i), 100 , enemyProjectile);
					enemies.add(heavy);
				} if(i > 6 && i < 14) {
					Enemy medium = new Enemy(typeMedium, false, 100 + (20 * i), 150 , enemyProjectile);
					enemies.add(medium);
				} if(i > 14 && i < 22) {
					Enemy light = new Enemy(typeLight, false, 100 + (20 * i), 200 , enemyProjectile);
					enemies.add(light);
				}
			}
			shields.add(tempGameShield1);
			shields.add(tempGameShield2);
		}
	}
	public void printArrayList() {
		System.out.println("size: " + enemies.size());
		System.out.println("size of Shields: " + shields.size());
		for(Enemy temp : enemies) {
			System.out.println("CoordX: " + temp.getCordinateX() + " CoordY: " + temp.getCordinateY() + " Enemy Type: " + temp.getTypeOfEnemy().geteTypeCode());
		}
	}
}