package starter;

import java.util.ArrayList;
import acm.graphics.*;

public class Level {
	private int numberOfEnemiesLight;
	private int numberOfEnemiesMedium;
	private int numberOfEnemiesHeavy;
	private int numberOfPlayers;
	
	private ArrayList<EnemyType> enemies;
	private ArrayList<Shield> shields;
	private ArrayList<CharacterEntity> users;
	
	Projectile userProjectile = new Projectile(5);
	Hitbox userHitbox = new Hitbox(50, 70);
	CharacterEntity user = new CharacterEntity(100, 50, false, 800, 800, userProjectile, userHitbox);
	
	Hitbox enemyLightHitbox = new Hitbox(50, 70);
	EnemyType typeLight = new EnemyType(50, 10, enemyLightHitbox, EnemyTypeCode.LIGHT);
	 
	Hitbox enemyMediumHitbox = new Hitbox(60, 80);
	EnemyType typeMedium = new EnemyType(100, 20, enemyMediumHitbox, EnemyTypeCode.MEDIUM);
	 
	Hitbox enemyHeavyHitbox = new Hitbox(80, 100);
	EnemyType typeHeavy = new EnemyType(200, 50, enemyHeavyHitbox, EnemyTypeCode.HEAVY);
	 
	Projectile enemyProjectile = new Projectile(5);
	
	Shield gameShield = new Shield(100, 200, 500);
	
	public Level(int numberOfEnemiesLight, int numberOfEnemiesMedium, int numberOfEnemiesHeavy, int numberOfPlayers, int numberOfShields) {
		this.numberOfEnemiesLight = numberOfEnemiesLight;
		this.numberOfEnemiesMedium = numberOfEnemiesMedium;
		this.numberOfEnemiesHeavy = numberOfEnemiesHeavy;
		this.numberOfPlayers = numberOfPlayers;
		
		for(int i = 0; i <= numberOfEnemiesLight; i++) {
			enemies.add(typeLight);
		}
		for(int i = 0; i <= numberOfEnemiesMedium; i++) {
			enemies.add(typeMedium);
		}
		for(int i = 0; i <= numberOfEnemiesHeavy; i++) {
			enemies.add(typeHeavy);
		}
		
		for(int i = 0; i <= numberOfPlayers; i++) {
			users.add(user);
		}
		
		for(int i = 0; i <= numberOfShields; i++) {
			
		}
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
}