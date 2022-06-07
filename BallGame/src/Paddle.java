import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Paddle extends block {

	private int a;
	
	public Paddle() {
		initPaddle();
	}
	
	private void initPaddle() {
		setImage();
		getActorDim();
		
		reset();
		
	}
	private void setImage() {
		var i = new ImageIcon("src/resources/Paddle1.png");
		actor = i.getImage();
	}
	
	public void reset() {
		x = 200;
		y = 360;
	}
	
	void move() {
		x = x+a+a;
		if(x <= 0) {
			x = 0;
		}
		if(x >= 300 - width) {
			x = 300 -width;
		}
	}
	
	public void keyPressed(KeyEvent event) {
		String whichKey=KeyEvent.getKeyText(event.getKeyCode());
		
		if(whichKey.compareTo("Left")==0) {
			a = -1;
		}
		else if(whichKey.compareTo("Right")==0) {
			a = 1;
		}	

		
	}
	public void keyReleased(KeyEvent event) {
		String whichKey=KeyEvent.getKeyText(event.getKeyCode());
		
		if(whichKey.compareTo("Left")==0) {
			a = 0;
		}
		else if(whichKey.compareTo("Right")==0) {
			a = 0;
		}
}
}
