import java.awt.Color;
import java.awt.Graphics;

public class Pacman {
	final int speed = 1;
	private int x,y;
	private Node nodeAt;
	private Node targetNode;
	private Node nextTargetNode;
	private Direction d;
	
	public Pacman(int x, int y, Node n) {
		this.x = x;
		this.y = y;
		nodeAt = n;
	}
	
	public void move() {
		if(targetNode==null)
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
		if((x/25==targetNode.getCol()) && (y/25==targetNode.getRow()) &&(x%25==0) && (y%25==0)) { 
			nodeAt = targetNode;
			if(nextTargetNode==null)
				targetNode=null;
			else {
				targetNode=nextTargetNode;
				nextTargetNode=null;
			}
		}
	}
	
	public void changeTarget(Node n, Direction d) {
		if(targetNode==null)
			targetNode = n;
		else
			nextTargetNode=n;
		this.d=d;
	}
	
	public Node getNodeAt() {
		return nodeAt;
	}
	
	public Node getTargetNode() {
		return targetNode;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x-11, y-11, 22, 22);
	}
}
