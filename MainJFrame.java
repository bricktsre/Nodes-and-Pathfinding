public MainJFrame extends JFrame{
	private displaypanel dp;

	public MainJFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		dp = new displaypanel();
		dp.setPreferredSize(new Dimension(100,100));
		getContentPane().add(gp);
		pack():
	}

	public static void(String[] args){
		MainJFrame f = new MainJFrame();
		f.display();
	}

	public void display(){
	EventQueue.invokeLater(new Runnable(){
		public void run(){
			setVisible(true);
		}
	}
	}
}