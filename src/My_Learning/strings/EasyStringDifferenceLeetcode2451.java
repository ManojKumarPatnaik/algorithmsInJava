package My_Learning.strings;

import java.util.*;

public class EasyStringDifferenceLeetcode2451 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "adc", "wzy", "abc" };
		String[] words1 = {"aaa","bob","ccc","ddd"};
		String[] words2 = {"ddd","poo","baa","onn"};
		String[] words3 = {"abm","bcn","alm"};
		
		System.out.println(oddString(words3));
	}
	
    public static String oddString(String[] words) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < ch.length - 1; j++) {
                list.add(ch[j + 1] - ch[j]);
            }

            if (map.containsKey(list)) {
                map.get(list).add(words[i]);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(words[i]);
                map.put(list, l);
            }
        }

        for (List<Integer> key : map.keySet()) {
            if (map.get(key).size() == 1) {
                return map.get(key).get(0);
            }
        }

        return "";
    }


	public static String oddString1(String[] words) {
		String ans = "";

		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			
			String diffArrKey = getDiffArray(word);
			
			if (map.containsKey(diffArrKey)) {
				List<String> sameWords = map.get(diffArrKey);
				sameWords.add(word);
				map.put(diffArrKey, sameWords);
			} else {
				map.put(diffArrKey, new ArrayList<>(Arrays.asList(word)));
			}
		}
		
		for(String key : map.keySet()) {
			if(map.get(key).size() == 1) {
				ans = map.get(key).get(0);
			}
		}
		
		return ans;
	}

	private static String getDiffArray(String word) {
		String key = "";
		for (int j = 0; j <= word.length() - 2; j++) {
			key += String.valueOf((word.charAt(j + 1) - 'a') - (word.charAt(j) - 'a'));
		}	
		System.out.println(word+" : "+key);
		return key;
	}

}
