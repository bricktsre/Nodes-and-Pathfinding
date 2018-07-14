import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

public class Node {
	int row,col;
	ArrayList<Edge> neighbors = new ArrayList<Edge>();
	
	public Node(int x, int y) {
		row = y;
		col = x;
	}
	
	public void addNeighbors(Node node, int cost) {
		neighbors.add(new Edge(node,cost));
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		for(Edge e: neighbors)
			g.drawLine(col*25, row*25, e.getNode().getCol()*25, e.getNode().getRow()*25);
		g.setColor(Color.WHITE);
		g.fillOval(col*25-7,row*25-7,15,15);
	}
}
