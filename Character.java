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
		g.setColor(Color.GREEN);
		g.fillOval(row*25-6, col*25-6, 13, 13);
	};
}
