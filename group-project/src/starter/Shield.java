package starter;

public class Shield {
	private int height;
	private int width;
	private int health;
	
	public Shield(int height, int width, int health) {
		this.height = height;
		this.health = health;
		this.width = width;
	}
	
	public boolean isDestroyed() {
		if(health == 0) {
			return true;
		}
		return false;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}


}
