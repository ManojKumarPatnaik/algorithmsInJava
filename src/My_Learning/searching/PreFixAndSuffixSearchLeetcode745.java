package My_Learning.searching;

import java.util.HashMap;

public class PreFixAndSuffixSearchLeetcode745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<String, Integer> map = new HashMap<>();

	public PreFixAndSuffixSearchLeetcode745(String[] words) {
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }

	public int f(String prefix, String suffix) {
		return (map.containsKey(prefix + "#" + suffix)) ? map.get(prefix + "#" + suffix) : -1;
	}

}
