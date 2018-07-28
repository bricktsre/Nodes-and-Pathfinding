import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Character {
	final int speed = 5;
	private int x,y;
	private Node nodeAt;
	private Node targetNode;
	private LinkedList<Node> path;
	
	public Character(int x, int y, Node n) {
		this.x = x;
		this.y = y;
		nodeAt=n;
	}
	
	public void move() {
		checkTargetNode();
		if(nodeAt.compareTo(targetNode)==0)
			return;
		else {
			if(nodeAt.getRow()<targetNode.getRow())
				y+=speed;
			else if(nodeAt.getRow()>targetNode.getRow())
				y-=speed;
			else if(nodeAt.getCol()<targetNode.getCol())
				x+=speed;
			else if(nodeAt.getCol()>targetNode.getCol())
				x-=speed;
		}
	}
	
	private void checkTargetNode() {
		if((x/25==targetNode.getCol()) && (y/25==targetNode.getRow()) &&(x%25==0) && (y%25==0)) {
			nodeAt = targetNode;
			if(path.isEmpty())
				return;
			targetNode = path.pop();
		}
	}
	
	public void setTarget(Node n) {
		targetNode = n;
	}
	
	public void setPath(LinkedList<Node> p) {
		path =p;
		targetNode = path.pop();
	}
	
	public Node getNodeAt() {
		return nodeAt;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-11, y-11, 22, 22);
	};
}
