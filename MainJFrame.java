import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainJFrame extends JFrame{
	private displaypanel dp;

	public MainJFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		dp = new displaypanel();
		dp.setPreferredSize(new Dimension(500,500));
		getContentPane().add(dp);
		pack();
	}

	public static void main(String[] args){
		MainJFrame f = new MainJFrame();
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