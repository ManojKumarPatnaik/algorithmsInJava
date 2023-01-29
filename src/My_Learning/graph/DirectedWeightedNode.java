package My_Learning.graph;

import java.util.Comparator;

public class DirectedWeightedNode implements Comparator<DirectedWeightedNode> {

	private int v;
	private int weight;

	public DirectedWeightedNode(int v, int weight) {
		super();
		this.v = v;
		this.weight = weight;
	}

	public DirectedWeightedNode() {
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	// this is used in order to have a minimum priority queue in Dijsktra algo
	@Override
	public int compare(DirectedWeightedNode node1, DirectedWeightedNode node2) {
		// TODO Auto-generated method stub

		if (node1.getWeight() > node2.getWeight())
			return 1;
		else if (node1.getWeight() < node2.getWeight())
			return -1;
		else
			return 0;
	}

}
