package My_Learning.Arrays;

public class FinalValueAfterOperationLeetCode2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int finalValueAfterOperations1(String[] operations) {
		int x = 0;
		for (String operation : operations) {
			if (operation.equals("X++"))
				x++;
			else if (operation.equals("++X"))
				++x;
			else if (operation.equals("X--"))
				x--;
			else if (operation.equals("--X"))
				--x;
			else
				continue;
		}

		return x;
	}

	public int finalValueAfterOperations(String[] operations) {
		int res = 0;

		for (int i = 0; i < operations.length; i++)
			if (operations[i].charAt(1) == '+')
				res++;
			else
				res--;

		return res;
	}

}
