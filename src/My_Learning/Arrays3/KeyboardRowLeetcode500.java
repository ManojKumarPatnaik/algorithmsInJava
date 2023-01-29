package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KeyboardRowLeetcode500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findWords(String[] words) {
		Set<Character> row1 = "qwertyuiop".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
		Set<Character> row2 = "asdfghjkl".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
		Set<Character> row3 = "zxcvbnm".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
		List<String> result = new ArrayList<>();
		for (String word : words) {
			Set<Character> wordSet = word.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
			if (row1.containsAll(wordSet) || row2.containsAll(wordSet) || row3.containsAll(wordSet))
				result.add(word);
		}
		return result.toArray(new String[0]);
	}
}
