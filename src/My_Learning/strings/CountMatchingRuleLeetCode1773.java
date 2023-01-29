package My_Learning.strings;

import java.util.List;

public class CountMatchingRuleLeetCode1773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int i = 0;
		int count = 0;

		if (ruleKey.equals("type"))
			i = 0;
		else if (ruleKey.equals("color"))
			i = 1;
		else if (ruleKey.equals("name"))
			i = 2;

		for (List<String> subItem : items) {
			if (subItem.get(i).equals(ruleValue))
				count++;
		}

		return count;
	}

}
