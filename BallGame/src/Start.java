
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
public class Start extends JFrame {	

	public static void main(String[] args) {
		JFrame frame1 = new JFrame("Menu");
		JFrame frame2 = new JFrame("Ball Game");
		JFrame frame3 = new JFrame("Help");
		JFrame frame4 = new JFrame("About");
		JTextArea jt= new JTextArea("CONTROLS:Use LEFT and RIGHT arrows to move the paddle",5,20);
		JTextArea jt1= new JTextArea("Name: Can Yigit\n NO: 20170702048\n Email: can.yigit@std.yeditepe.edu.tr",5,20);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener start = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				frame2.add(new Board());
				frame2.setLocationRelativeTo(null);
				frame2.setResizable(false);
				frame2.pack();
				frame1.setVisible(false);
				frame2.setVisible(true);
		      }
		    };
	    ActionListener exit = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				System.exit(0);
		      }
		    };
		 ActionListener help = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt.setEditable(false);
				 frame3.add(jt);
				 frame3.setLocationRelativeTo(null);
				 frame3.setResizable(false);
				 frame3.pack();
				 frame3.setVisible(true);
			 }
		 };
		 ActionListener about = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt1.setEditable(false);
				 frame4.add(jt1);
				 frame4.setLocationRelativeTo(null);
				 frame4.setResizable(false);
				 frame4.pack();
				 frame4.setVisible(true);
			 }
		 };
		frame1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JButton b1 = new JButton("New Game");
		JButton b2 = new JButton("  Options    ");
		JButton b3 = new JButton("    Scores   ");
		JButton b4 = new JButton("     Help       ");
		JButton b5 = new JButton("     About     ");
		JButton b6 = new JButton("      Exit        ");
		b1.addActionListener(start);
		b4.addActionListener(help);
		b5.addActionListener(about);
		b6.addActionListener(exit);
		frame1.add(b1);
		frame1.add(b2);
		frame1.add(b3);
		frame1.add(b4);
		frame1.add(b5);
		frame1.add(b6);
		frame1.setLocationRelativeTo(null);
		frame1.setSize(200, 400);
		frame1.setVisible(true);

	}

}
