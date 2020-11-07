package starter;

public class Shield {
	private int height;
	private int width;
	private int health;
	private int coordX;
	private int coordY;
	
	public Shield(int height, int width, int health, int coordX, int coordY) {
		this.height = height;
		this.health = health;
		this.width = width;
		this.coordX = coordX;
		this.coordY = coordY;
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

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}


}
