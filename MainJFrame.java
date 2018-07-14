import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainJFrame extends JFrame{
	private displaypanel dp;

	public MainJFrame(String s){
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		dp = new displaypanel(s);
		dp.setPreferredSize(new Dimension(800,800));
		getContentPane().add(dp);
		pack();
	}

	public static void main(String[] args){
		//String s = args[0];
		String s = "graph.txt";
		MainJFrame f = new MainJFrame(s);
		f.display();
	}

	public void display(){
	EventQueue.invokeLater(new Runnable(){
		public void run(){
			setVisible(true);
		}
	});
	}
}