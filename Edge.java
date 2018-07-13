
public class Edge {
	private Node n;
	private int cost;
	
	public Edge(Node node, int cost) {
		n = node;
		this.cost=cost;
	}
	
	public Node getNode() {
		return n;
	}
	
	public int getCost() {
		return cost;
	}
}
