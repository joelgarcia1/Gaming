import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong extends JFrame {
	private final static int w = 400;
	private final static int h = 350;
	private final Timer loop;
	private PongPanel p;
	public int p2score;
	public int p1score;


	public Pong() {
		
		setSize(w, h);
		setTitle("Pong");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new PongPanel(this);
		add(p);
		if(PongPanel.newGame == 0)
		
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				p.requestFocusInWindow();
			}
		});
		loop = new Timer(13, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p.repaint();
			}
		});
		loop.start();
	}

	public PongPanel getPanel() {
		return p;
	}
	

	public static void main(String[] args) {
		Pong window = new Pong();
		
		window.setBounds(50, 50, 700, 500);// This is for all the size//
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);// use a layout to put the label//
	}

}
