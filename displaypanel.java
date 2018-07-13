import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		c = new Character(5,5, nodes[1]);
		
		timer = new javax.swing.Timer(40, new TimerListener());
		timer.start();
	}
	
	private void initializeNodes() {
		Node node1 = new Node(1,1);
		Node node2 = new Node(5,5);
		Node node3 = new Node(1,5);
		Node node4 = new Node(5,1);
		Node node5 = new Node(8,5);
		
		node1.addNeighbors(node4, 4);
		node1.addNeighbors(node3, 4);
		node2.addNeighbors(node4, 4);
		node2.addNeighbors(node5, 3);
		node2.addNeighbors(node3, 4);
		node3.addNeighbors(node1, 4);
		node3.addNeighbors(node2, 4);
		node4.addNeighbors(node2, 4);
		node4.addNeighbors(node1, 4);
		node5.addNeighbors(node2, 3);
		
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
	
	@Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        for(Node a: nodes)
        	a.draw(g);
        c.draw(g);
    }
}
