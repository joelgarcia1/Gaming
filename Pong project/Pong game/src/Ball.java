import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Ball {
	private final int height = 15;
	private final int width = 15;
	private int x;
	private int y;
	private int jx = 6;
	private int jy = 6;
	private Pong game;
	private RectangularShape limits;
	static Paddle p1; 
	static Paddle p2; 
public Ball(int x, int y, Pong gam){
	this.x = x;
	this.y = y;
	game = gam;
}
public Rectangle2D getBall(){
	return new Rectangle2D.Double(x, y, height, width);
}

public void move(Rectangle limits){
	x += jx;
	y += jy;
	if(x > limits.getMaxX() - 21){
		
		PongPanel.p1score++;
		x = 350;
		y = 350;
		jy = -jy;
	}
	if(y > limits.getMaxY() - 20){
		jy = -jy;
	}
	if(x<0){
		PongPanel.p2score++;
		x = 350;
		y = 350;
		jy = -jy;
	}
	
	if(y<0){
		jy = -jy;
	}
	
 }
public void collision(Paddle p1, Paddle p2){
	
	if (p1.getBounds().intersects(getBounds())) {
		jx = -jx;
	}
	if (p2.getBounds().intersects(getBounds())) {
		jx = -jx;
	}
}
public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
}

public void paintComponent(Graphics g) {
	g.fillRect(x, y, 15, 15);
 }
public int getY(){
	return (int) y;
}
public int getX(){
	return (int) x;
}
public void setX(int xPos){
	x = xPos;
}
public void setY(int yPos){
	y = yPos;
}
}
