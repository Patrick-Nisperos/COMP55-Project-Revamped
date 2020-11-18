package starter;

import acm.graphics.*;

public class Projectile {
	private int speed;
	private int height;
	private int width;
	private GImage projectilePic=new GImage("projectile px.png");
	
	public Projectile(int speed,int height,int width) {
		this.speed=speed;
		this.height=height;
		this.width=width;
	}

	
	public static Boolean isProjectileDestroyed(Boolean x) {
		return x;
	}
	
	public GImage getProjectilePic() {
		return projectilePic;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setSize(int height,int width) {
		projectilePic.setSize(height,width);
	}

	
}