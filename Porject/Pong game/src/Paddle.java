import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paddle {

	private int x;
	private int paddle=5;
	private int y;
	private final int height = 95, width = 15;
	boolean w,s,up,down;
	
	public Paddle(int x, int y){
	this.x = x;
	this.y = y;
	}
	public Rectangle2D getPaddle(){
		return new Rectangle2D.Double(x, y, width, height);
		
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	public void setW(){
		w = true;
	}
	public void setWf(){
		w = false;
	}
	public void setS(){
		s = true;
	}
	public void setSf(){
		s = false;
	}
	public void setUp(){
		up = true;
	}
	public void setUpf(){
		up = false;
	}
	public void setDown(){
		down = true;
	}
	public void setDownf(){
		down = false;
	}
	public void move(){
		 if(y < 391){
			 y+=5;
		 }
		 if(y>4){
			y-=5;
		 }
		  if (w){
			  y-= paddle;
		  }
		  if (s){
			  y+=paddle;
		  }
		  if (up){
			 
			  y-=paddle;
		  }
		  if (down){
			  
			  y+=paddle;
		  }
	}
	    public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }
		public int getY() {
			// TODO Auto-generated method stub
			return y;
		}
		public void setX(int xPos){
			x = xPos;
		}
		public void setY(int yPos){
			y = yPos;
		}
}
