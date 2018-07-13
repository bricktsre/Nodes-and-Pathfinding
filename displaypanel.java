import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class displaypanel extends JPanel{
	private Node[] nodes = new Node[5];
	private Character c;
	private javax.swing.Timer timer;
	
	public displaypanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		initializeNodes();
		c = new Character(5,5);
		
		addKeyListener(new keylistener());
		setFocusable(true);
		
		timer = new javax.swing.Timer(40, new TimerListener());
		timer.start();
	}
	
	private void initializeNodes() {
		Node node1 = new Node(1,1);
		Node node2 = new Node(5,5);
		Node node3 = new Node(1,5);
		Node node4 = new Node(5,1);
		Node node5 = new Node(8,5);
		
		node1.addNeighbors(Direction.RIGHT,node4);
		node1.addNeighbors(Direction.DOWN, node3);
		node2.addNeighbors(Direction.UP, node4);
		node2.addNeighbors(Direction.RIGHT, node5);
		node2.addNeighbors(Direction.LEFT, node3);
		node3.addNeighbors(Direction.UP, node1);
		node3.addNeighbors(Direction.RIGHT, node2);
		node4.addNeighbors(Direction.DOWN, node2);
		node4.addNeighbors(Direction.LEFT, node1);
		node5.addNeighbors(Direction.LEFT, node2);
		
		nodes[0]= node1;
		nodes[1]=node2;
		nodes[2]=node3;
		nodes[3]=node4;
		nodes[4]=node5;
	}
	
	private class TimerListener implements ActionListener{				//reference to gamePanel
		
		public TimerListener() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {		//Main method running the whole game
			repaint();
		}
	}
	
	private class keylistener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){  
        	if(e.getKeyCode() == KeyEvent.VK_LEFT)
        	    c.move(Direction.LEFT);                
        	else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        	    c.move(Direction.RIGHT);                
        	else if(e.getKeyCode() == KeyEvent.VK_UP)
        	    c.move(Direction.UP);                
        	else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        	    c.move(Direction.DOWN);
        }
    }
	
	@Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        for(Node a: nodes)
        	a.draw(g);
        c.draw(g);
    }
}
