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
		checkTargetNode();
		
	}
	
	private void checkTargetNode() {
		if((x/25==targetNode.getCol()) && (y/25==targetNode.getRow()) &&(x%25==0) && (y%25==0)) { 
			nodeAt = targetNode;
			if(nextTargetNode!=null) {
				targetNode=nextTargetNode;
				nextTargetNode=null;
				d = nodeAt.directionOfNode(targetNode);
			}else if(nodeAt.neighborInDirection(d)!=null)
				targetNode=nodeAt.neighborInDirection(d);
			else {
				targetNode=null;
			}
		}
	}
	
	public void changeTarget(Node n, Direction d) {
		if(targetNode==null) {
			targetNode = n;
			this.d=d;
		}else
			nextTargetNode=n;
	}
	
	public Node getNodeAt() {
		return nodeAt;
	}
	
	public void setNodeAt(Node n) {
		nodeAt=n;
	}
	
	public Node getTargetNode() {
		return targetNode;
	}
	
	public void changeNextTargetNode(Node n) {
		nextTargetNode = n;
	}
	
	public void targetNodeNull() {
		targetNode=null;
	}
	
	public Direction getDirection() {
		return d;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x-11, y-11, 22, 22);
	}
}
