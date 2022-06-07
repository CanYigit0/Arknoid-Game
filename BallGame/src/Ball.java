import javax.swing.ImageIcon;

public class Ball extends block {
	private int a;
	private int b;
	
	public Ball() {
		initBall();
	}
	private void initBall() {
		
		a =1;
		b=-1;
		
		loadImage();
		getActorDim();
		reset();
	}
	private void loadImage() {
		var i = new ImageIcon("src/resources/Ball.png");
		actor = i.getImage();
	}
	public void reset() {
		x = 230;
		y = 330;
	}
	
	void move() {
		x = x+a;
		y = y+b;
		if (x == 0) {

            setX(1);
        }
		if (x == 300 - width) {

            setX(-1);
        }
		if (y == 0) {

            setY(1);
        }
	}
	void setX(int x) {
		a = x;
	}
	void setY(int y) {
		b = y;
	}
	int getY() {
		return b;
	}
}
