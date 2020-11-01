package starter;

import java.util.ArrayList;
import acm.graphics.*;

public class Level {
	private ArrayList<Enemy> enemies;
	private ArrayList<Shield> shields;
	
	Projectile userProjectile = new Projectile(5);
	Hitbox userHitbox = new Hitbox(50, 40);
	private CharacterEntity user = new CharacterEntity(100, 50, false, 800, 800, userProjectile, userHitbox);
	
	Hitbox enemyLightHitbox = new Hitbox(50, 40);
	EnemyType typeLight = new EnemyType(50, 10, enemyLightHitbox, EnemyTypeCode.LIGHT);
	
	 
	Hitbox enemyMediumHitbox = new Hitbox(70, 60);
	EnemyType typeMedium = new EnemyType(100, 20, enemyMediumHitbox, EnemyTypeCode.MEDIUM);
	 
	Hitbox enemyHeavyHitbox = new Hitbox(100, 80);
	EnemyType typeHeavy = new EnemyType(200, 50, enemyHeavyHitbox, EnemyTypeCode.HEAVY);
	 
	Projectile enemyProjectile = new Projectile(5);
	
	
	
	public void drawLevel() {
		
	}
	public void createEnemy() {
		
	}
	public GRect createUser() {
		GRect userRect = new GRect(user.getCoordX(), user.getCoordY(), user.getUserHitbox().getHeight(), user.getUserHitbox().getWidth());
		return userRect;
	}
	public void placeShield() {
		
	}
	public void placeBackground() {
		
	}
	public void placeScoreSystem() {
		
	}
}