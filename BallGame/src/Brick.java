import javax.swing.ImageIcon;

public class Brick extends block {

	private boolean destroyed;
	
	public static int level=1;
	
	public Brick(int x,int y) {
		initBrick(x,y);
	}
	public void initBrick(int x,int y) {
		this.x = x;
		this.y = y;
		
		destroyed = false;
		setImage1();
        getActorDim();
	}
	public void setImage1() {
		var i = new ImageIcon("src/resources/Brick1.png");
		actor = i.getImage();
	}
	public void setImage2() {
		var i = new ImageIcon("src/resources/Brick2.png");
		actor = i.getImage();
	}
	public void setImage3() {
		var i = new ImageIcon("src/resources/Brick3.png");
		actor = i.getImage();
	}
	int getX() {
		return this.x;
	}
	int getY() {
		return this.y;
	}
	
	boolean isDestroyed() {
		return destroyed;
	}
	void setDestroyed(boolean a) {
        
        destroyed = a;
    }
}
