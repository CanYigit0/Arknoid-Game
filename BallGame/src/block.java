import java.awt.Rectangle;
import java.awt.Image;

public class block {
	
	int x;
	int y;
	int width;
	int height;
	Image actor;
	
	public void setx(int x) {
		this.x =x;
	}
	int getx() {
		return x;
	}
	public void sety(int y) {
		this.y =y;
	}
	int gety() {
		return y;
	}
	int getw() {
		return width;
	}
	int geth() {
		return height;
	}
	Image getactor() {
		return actor;
	}
	Rectangle getRect() {
		return new Rectangle(x,y,actor.getWidth(null), actor.getHeight(null));
	}
	void getActorDim() {
		width = actor.getWidth(null);
		height = actor.getHeight(null);
	}

}
