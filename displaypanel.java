import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class displaypanel extends JPanel{
	private Node[] nodes;
	private Character c;
	private javax.swing.Timer timer;
	
	public displaypanel(String s) {
		setBackground(Color.BLACK);
		setLayout(null);
		initializeNodes(s);
		PathfindingAlgos p = new PathfindingAlgos();
		c = new Character(25,25, nodes[0]);
		//c.setPath(p.breadthFirstSearch(nodes, c.getNodeAt(), nodes[38]));
		//c.setPath(p.Dijkstra(nodes, c.getNodeAt(), nodes[38]));
		//c.setPath(p.greedyBestFirstSearch(nodes, c.getNodeAt(), nodes[38]));
		c.setPath(p.astar(nodes, c.getNodeAt(), nodes[38]));
		timer = new javax.swing.Timer(60, new TimerListener());
		timer.start();
	}
	
	private void initializeNodes(String s) {
		try {
			Scanner a = new Scanner(new File(s));
			nodes = new Node[a.nextInt()];
			for(int i =0;i<nodes.length;i++)
				nodes[i]= new Node(a.nextInt(),a.nextInt());
			for(int i =0;i<nodes.length;i++) {
				while(!a.hasNext("-1")) {
					int node = a.nextInt()-1;
					int cost = a.nextInt();
					nodes[i].addNeighbors(nodes[node], cost);
					nodes[node].addNeighbors(nodes[i], cost); 
				}a.nextInt();
			}
			a.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private class TimerListener implements ActionListener{				//reference to gamePanel
		
		public TimerListener() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {		//Main method running the whole game
			c.move();
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
