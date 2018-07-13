import java.awt.Color;
import java.awt.Graphics;

public class Character {
	private int row,col;
	
	public Character(int x, int y) {
		row = y;
		col = x;
	}
	
	public void move(Direction d) {
		row+= d.dx;
		col+= d.dy;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(row*50-13, col*50-13, 26, 26);
	};
}
