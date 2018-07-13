import java.awt.Color;
import java.awt.Graphics;

public class Character {
	private int row,col;
	private Node nodeAt;
	
	public Character(int x, int y, Node n) {
		row = y;
		col = x;
		n = nodeAt;
	}
	
	public void move(Node n) {
		nodeAt = n;
		row= nodeAt.getRow();
		col= nodeAt.getCol();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(row*50-13, col*50-13, 26, 26);
	};
}
