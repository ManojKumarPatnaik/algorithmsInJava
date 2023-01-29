package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.List;

public class CellInARangeOnExcelSheetLeetcode2194 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> cellsInRange(String s) {
		char start = s.charAt(0);
		char stop = s.charAt(3);
		ArrayList<String> letters = new ArrayList<>();
		while (true) {
			if (start > stop)
				break;
			for (; start <= stop; start++) {
				for (int a = Integer.parseInt(String.valueOf(s.charAt(1))); a <= Integer
						.parseInt(String.valueOf(s.charAt(4))); a++) {
					letters.add(start + String.valueOf(a));
				}
			}
		}
		return letters;
	}

}
