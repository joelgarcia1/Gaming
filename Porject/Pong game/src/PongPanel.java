import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PongPanel extends JPanel implements KeyListener {
	static int p1score, p2score;
	public static int newGame; 
	Pong pong ;
	Ball ball;
	Paddle p1; 
	Paddle p2;
	boolean w,s,up,down;
	private int Status = 0, scoreLimit = 5; // 0= stopped, 1 = playing,2 = game over
	
	public PongPanel(Pong p)
	{
	   setBackground(Color.BLACK);
	   pong = p;	
	   ball = new Ball(350, 350, pong);
	   p1 = new Paddle(0, 200);
	   p2 = new Paddle(685,200);
	   addKeyListener(this);
	  }
   
	public int getNGChoice()
	{
	   return newGame;
   }
  
	public void winner()
{
	   
	   if(p1score >= scoreLimit)
	   {
		  Status = 2;
	   }
	   if(p2score >= scoreLimit)
	   {
		   Status = 2;
	   }
}
   public void reset()
   {
	   ball.setX(350);
	   ball.setY(350);
	   p1.setX(0);
	   p1.setY(200);
	   p2.setX(685);
	   p2.setY(200);
	   p1score = 0;
	   p2score = 0;
   }
  @Override
public void paintComponent(Graphics g)
  {
	   super.paintComponent(g);
	   Graphics2D g1 = (Graphics2D)g;
	   g1.setColor(Color.WHITE);
	   paint(g1);
	   move(); 
	   winner();
  }
  
   public void paint(Graphics2D g)
   {
	   
	   if(Status == 0){
		   g.setColor(Color.WHITE);
		   g.setFont(new Font("Ariel", 1, 30));
		   g.drawString("Pong", 320, 50);
		   
		   g.setColor(Color.WHITE);
		   g.setFont(new Font("Ariel", 1, 30));
		   g.drawString("by Joel Garcia", 290, 100);
		   
		   g.setColor(Color.WHITE);
		   g.setFont(new Font("Ariel", 1, 40));
		   g.drawString("Press Space to Play", 190, 300);
	   }
	   if(Status == 1 )
	   {
		   
		  g.setColor(Color.WHITE);
	   g.setStroke(new BasicStroke(10));
	   g.drawLine(350, 0, 350, 700);
	   g.drawString("Player 1: " + p1score , 50, 40);
	   g.drawString("Player 2: " + p2score , 600, 40);
	   
	   g.fill(ball.getBall());
	   g.fill(p1.getPaddle());
	   g.fill(p2.getPaddle());
	  
	   }
	   if(Status == 2)
	   {
		   
		   g.setColor(Color.WHITE);
		   g.setFont(new Font("Ariel", 1, 40));
		   g.drawString("Pong", 320, 50);
		   g.setFont(new Font("Ariel", 1, 30));
		   g.drawString("Press Space to Play Again", 190, 200);
		   if(p1score == scoreLimit)
		   {
			   g.drawString(" Player 1 Wins!!", 200, 300);
		   }
		   if(p2score == scoreLimit)
		   {
			   g.drawString("Player 2 Wins!!", 200, 300);
		   }
	   }
   }

public void move()
	{
	ball.move(getBounds());
	p1.move();
	p2.move();
	ball.collision(p1, p2);
	}
@Override
public void keyPressed(KeyEvent e) 
{
	int j = e.getKeyCode();
	if ( j == KeyEvent.VK_W)
	{
	
		p1.setW();
		p1.move();
	}
	if (j == KeyEvent.VK_S)
	{
		
		p1.setS();
		p1.move();
	}
	if(j == KeyEvent.VK_UP)
	{
		
		p2.setUp();
		p2.move();
	}
	if(j == KeyEvent.VK_DOWN)
	{
		
		p2.setDown();
		p2.move();
	}
	if ( j == KeyEvent.VK_SPACE)
	{
		
		p1.move();
	}
}

@Override
public void keyReleased(KeyEvent e)
{
	int j = e.getKeyCode();
	
	if ( j == KeyEvent.VK_W){
		p1.setWf();
		p1.move();
	}
	if (j == KeyEvent.VK_S){
		p1.setSf();
		p1.move();
	}
	if(j == KeyEvent.VK_UP){
		p2.setUpf();
		p2.move();
	}
	if(j == KeyEvent.VK_DOWN){
		p2.setDownf();
		p2.move();
	}
	if ( j == KeyEvent.VK_SPACE){
		if(Status == 0 || Status == 2){
			reset();
			Status = 1;
		}
		
	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}



}