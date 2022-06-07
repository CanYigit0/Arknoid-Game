import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel{
	private Paddle paddle;
	private Ball ball;
	public static int lives = 3;
	public static int score = 0;
	public static int lvl = 1;
	private Timer timer;
	private String message = "Game Over";
	private Brick[] bricks;
	JLabel live = new JLabel("Lives:"+lives,JLabel.RIGHT);
	JLabel scores = new JLabel("Score:"+score,JLabel.RIGHT);
	JLabel level = new JLabel("Level:"+lvl,JLabel.RIGHT);
	private boolean inGame = true;
	public Board() {

        initBoard();
    }
	private void initBoard() {
		add(scores);
		add(level);
		add(live);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(300, 400));
        
        gameInit();
	}
	private void stopGame() {
        inGame = false;
        timer.stop();
    }
	private void doGameCycle() {
		if(lvl==1) {
	        ball.move();
	        paddle.move();
	        checkCollision();
	        repaint();
		}
		if(lvl==2) {
			ball.move();
	        paddle.move();
	        checkCollision();
	        repaint();
		}
    }
	private void gameInit() {

        bricks = new Brick[30];

        ball = new Ball();
        paddle = new Paddle();

        int k = 0;

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 6; j++) {

                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }
        timer = new Timer(10, new Game());
        timer.start();
    }
	private void checkCollision() {

        if (ball.getRect().getMaxY() > 390) {
        	if(lives>1) {
        		paddle.reset();
        		ball.reset();
        		lives--;
        		live.setText("Lives:"+lives);
        	}
        	else {
        		stopGame();
        	}
        }

        for (int i = 0, j = 0; i < 30; i++) {

            if (bricks[i].isDestroyed()) {

                j++;
            }

            if (j == 30) {

                stopGame();

            }
        }

        if ((ball.getRect()).intersects(paddle.getRect())) {

            int paddleLPos = (int) paddle.getRect().getMinX();
            int ballLPos = (int) ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {

                ball.setX(-1);
                ball.setY(-1);
            }

            if (ballLPos >= first && ballLPos < second) {

                ball.setX(-1);
                ball.setY(-1 * ball.getY());
            }

            if (ballLPos >= second && ballLPos < third) {

                ball.setX(0);
                ball.setY(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {

                ball.setX(1);
                ball.setY(-1 * ball.getY());
            }

            if (ballLPos > fourth) {

                ball.setX(1);
                ball.setY(-1);
            }
        }

        for (int i = 0; i < 30; i++) {
        if(lvl==1) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight)) {

                        ball.setX(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {

                        ball.setX(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {

                        ball.setY(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {

                        ball.setY(-1);
                    }
                    score=score+10;
                    bricks[i].setDestroyed(true);
                    scores.setText("Score:"+score);
                }
            }
        }
        if(lvl==2) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight)) {

                        ball.setX(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {

                        ball.setX(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {

                        ball.setY(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {

                        ball.setY(-1);
                    }
                    score=score+10;
                    bricks[i].setImage2();
                    scores.setText("Score:"+score);
                }
            }
        }
        }
    }
	private class Game implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			doGameCycle();
		}
		
		
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {

            drawObjects(g2d);
        } else {
        	gameFinished(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }
	private void drawObjects(Graphics2D g2d) {

        g2d.drawImage(ball.getactor(), ball.getx(), ball.gety(),
                ball.getw(), ball.geth(), this);
        g2d.drawImage(paddle.getactor(), paddle.getx(), paddle.gety(),
                paddle.getw(), paddle.geth(), this);

        for (int i = 0; i < 30; i++) {

            if (!bricks[i].isDestroyed()) {
            	if(lvl==1) {
            		bricks[i].setImage1();
                g2d.drawImage(bricks[i].getactor(), bricks[i].getx(),
                        bricks[i].gety(), bricks[i].getw(),
                        bricks[i].geth(), this);
            	}
            	else if(lvl==2) {
            		bricks[i].setImage2();
            		g2d.drawImage(bricks[i].getactor(), bricks[i].getx(),
                            bricks[i].gety(), bricks[i].getw(),
                            bricks[i].geth(), this);
            	}
            }
        }
    }
	private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (300 - fontMetrics.stringWidth(message)) / 2,
                300 / 2);
    }
	 private class TAdapter extends KeyAdapter {

	        public void keyReleased(KeyEvent e) {

	            paddle.keyReleased(e);
	        }

	        public void keyPressed(KeyEvent e) {

	            paddle.keyPressed(e);
	        }
	    }
}

