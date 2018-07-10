import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Node {
	int row,col;
	Map<Direction, Node> neighbors = new HashMap<>();
	
	public Node(int x, int y) {
		row = y;
		col = x;
	}
	
	public void addNeighbors(Direction d, Node node) {
		neighbors.put(d, node);
	}
	
	public int returnRow() {
		return row;
	}
	
	public int returnCol() {
		return col;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		Node n;
		if(neighbors.containsKey(Direction.UP)) {
			n = neighbors.get(Direction.UP);
			g.drawLine(col*50, row*50, n.returnCol()*50, n.returnRow()*50);
		}if(neighbors.containsKey(Direction.RIGHT)) {
			n = neighbors.get(Direction.RIGHT);
			g.drawLine(col*50, row*50, n.returnCol()*50, n.returnRow()*50);
		}if(neighbors.containsKey(Direction.DOWN)) {
			n = neighbors.get(Direction.DOWN);
			g.drawLine(col*50, row*50, n.returnCol()*50, n.returnRow()*50);
		}if(neighbors.containsKey(Direction.LEFT)) {
			n = neighbors.get(Direction.LEFT);
			g.drawLine(col*50, row*50, n.returnCol()*50, n.returnRow()*50);
		}
		g.setColor(Color.WHITE);
		g.fillOval(col*50-15,row*50-15,30,30);
	}
}
