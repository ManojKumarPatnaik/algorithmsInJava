package My_Learning.Arrays3;

public class RectangleOverlapLeetcode836 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return (!(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1]));
	}

}
