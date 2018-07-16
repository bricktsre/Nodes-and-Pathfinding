import java.awt.Color;
import java.awt.Graphics;

public class Character {
	final int speed = 1;
	private int x,y;
	private Node nodeAt;
	private Node targetNode;
	
	public Character(int x, int y, Node n) {
		this.x = x;
		this.y = y;
		nodeAt=n;
	}
	
	public void move() {
		if(nodeAt.compareTo(targetNode)==0)
			return;
		else if((x/25==targetNode.getCol()) && (y/25==targetNode.getRow()) &&(x%25==0) && (y%25==0))
			nodeAt= targetNode;
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
	
	public void setTarget(Node n) {
		targetNode = n;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-6, y-6, 13, 13);
	};
}
