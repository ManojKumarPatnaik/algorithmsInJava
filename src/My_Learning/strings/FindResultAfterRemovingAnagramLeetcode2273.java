package My_Learning.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindResultAfterRemovingAnagramLeetcode2273 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> removeAnagrams(String[] words) {
		List<String> result = new LinkedList<>();
		String lastAnagramStr = null;
		for (String s : words) {
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			String curAnagramStr = new String(charArr);

			if (curAnagramStr.equals(lastAnagramStr)) {
				continue;
			} else {
				lastAnagramStr = curAnagramStr;
				result.add(s);
			}
		}
		return result;
	}

}
