package My_Learning.graph;

public class PairDirectedWeightedNode {
	private int u;
	private int v;
	private int w;

	public PairDirectedWeightedNode(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public PairDirectedWeightedNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	@Override
	public String toString() {
		return "PairDirectedWeightedNode [u=" + u + ", v=" + v + ", w=" + w + "]";
	}
	
	

}
