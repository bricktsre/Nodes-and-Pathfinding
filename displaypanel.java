import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class displaypanel extends JPanel{
	private Node[] nodes;
	private Character c;
	private Pacman	pman;
	private javax.swing.Timer timer;
	
	public displaypanel(String s) {
		setBackground(Color.BLACK);
		setLayout(null);
		initializeNodes(s);
		pman = new Pacman(335,575,nodes[37]);
		pman.changeTarget(nodes[29],Direction.LEFT);

		PathfindingAlgos p = new PathfindingAlgos();
		c = new Character(25,25, nodes[0]);
		//c.setPath(p.breadthFirstSearch(nodes, c.getNodeAt(), nodes[38]));
		//c.setPath(p.Dijkstra(nodes, c.getNodeAt(), nodes[38]));
		//c.setPath(p.greedyBestFirstSearch(nodes, c.getNodeAt(), nodes[38]));
		c.setPath(p.astar(nodes, c.getNodeAt(), nodes[38]));
		
		addKeyListener(new keylistener());					//keylistener for changing direction
		timer = new javax.swing.Timer(15, new TimerListener());
		timer.start();
		setFocusable(true);
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
	
	private void changeD(Direction d) {
		if(d.opposite()==pman.getDirection()) {
			Node n = pman.getTargetNode();
			pman.targetNodeNull();
			pman.changeTarget(pman.getNodeAt(), d);
			pman.setNodeAt(n);	
			pman.changeNextTargetNode(null);
		}else if(pman.getTargetNode()==null) {
			Node n = pman.getNodeAt().neighborInDirection(d);
			if(n!=null)
				pman.changeTarget(n,d);
		}else {
			Node n = pman.getTargetNode().neighborInDirection(d);
			if(n!=null)
				pman.changeTarget(n,d);
		}
	}
	
	private class TimerListener implements ActionListener{				//reference to gamePanel
		
		public TimerListener() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {		//Main method running the whole game
			c.move();
			pman.move();
			repaint();
		}
	}
	
	private class keylistener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){  
        	if(e.getKeyCode() == KeyEvent.VK_LEFT)
        	    changeD(Direction.LEFT);                
        	else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        	    changeD(Direction.RIGHT);                
        	else if(e.getKeyCode() == KeyEvent.VK_UP)
        	    changeD(Direction.UP);                
        	else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        	    changeD(Direction.DOWN);
        }
    }
	
	@Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        for(Node a: nodes)
        	a.draw(g);
        c.draw(g);
        pman.draw(g);
    }
}
