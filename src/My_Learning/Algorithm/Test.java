package My_Learning.Algorithm;

public class Test {

//	1. You have a table with a lot of columns. Find column name of the table from a given column number.
//	Columns are named using alphabets using below convention
//	1 -> A
//	2 -> B
//	...
//	26 -> Z
//	27 -> AA
//	28 -> AB
//	...
//	52 -> AZ
//	53 -> BA
//	54 -> BB
//	...
//	10,000 -> PTN

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inputNum = 214;
		String output = "";

		output = getExcelColumn(inputNum);
		System.out.println("Input = " + inputNum + " out = " + output);
	}

	public static String getExcelColumn(int inputNum) {
		StringBuilder output = new StringBuilder("");

		// Main logic
		int temp = inputNum;

		while (temp > 0) {
			int rem = temp % 26;

			if (rem != 0) {
				char ch = (char) ((rem - 1) + 'A');
				output.append(ch);
				temp = temp / 26;
			} else {
				char ch = 'Z';
				output.append(ch);
				temp = temp / 26 - 1;
			}

		}

		return output.reverse().toString();
	}

//	----------------------------
//	2. Apartments to be painted blue and yellow for each floor
//	    - yellow can be used for 2 neighbouring floors - 1
//	    - blue can not be used for consecutive floors - 2
//	    - given n as number of floors in appartment, how many ways appartment can be painted

//	 	1 -> 2
//	    2 -> 3
//	    3 -> 5
//	    4 -> 8
//	    5 -> 13
//	    6 -> 21

	public int getTotalWaysToPaint(int floors) {
		int ans = 0;
		// 1 - yellow
		// 2 - blue

		if (floors == 0)
			return ans;

		return getCountHelper(floors, 1);
	}

	private int getCountHelper(int floors, int i) {

		if (floors == 0) {
			if (i == 1) {
				return 2;
			}

			if (i == 2) {
				return 1;
			}
		}

		// pick yellow at current floor
		int ans1 = 0, ans2 = 0, ans3 = 0;
		if (i == 1) {
			ans1 = getCountHelper(floors - 1, 1);
			ans2 = getCountHelper(floors - 1, 2);

		}
		// pick blue at current floor
		if (i == 2) {
			ans3 = getCountHelper(floors - 1, 1);
		}

		return ans1 + ans2 + ans3;
	}

}
