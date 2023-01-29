package My_Learning.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LexographicallySmallestEquivalentStringLeetcode1061 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "parker", s2 = "morris", baseStr = "parser";
		System.out.println(smallestEquivalentString(s1, s2, baseStr));
	}

	public static String smallestEquivalentString(String A, String B, String S) {
        Map<Character, Character> letterGroupMap = new HashMap<Character, Character>();
        Map<Character, Set<Character>> groupLettersMap = new HashMap<Character, Set<Character>>();
        for (char c = 'a'; c <= 'z'; c++) {
            letterGroupMap.put(c, c);
            Set<Character> set = new HashSet<Character>();
            set.add(c);
            groupLettersMap.put(c, set);
        }
        int length = A.length();
        for (int i = 0; i < length; i++) {
            char c1 = A.charAt(i), c2 = B.charAt(i);
            char group1 = letterGroupMap.get(c1), group2 = letterGroupMap.get(c2);
            if (group1 != group2) {
                Set<Character> set1 = groupLettersMap.get(group1);
                Set<Character> set2 = groupLettersMap.get(group2);
                if (group1 < group2) {
                    for (char c : set2)
                        letterGroupMap.put(c, group1);
                    set1.addAll(set2);
                    groupLettersMap.put(group1, set1);
                    groupLettersMap.remove(group2);
                } else {
                    for (char c : set1)
                        letterGroupMap.put(c, group2);
                    set2.addAll(set1);
                    groupLettersMap.put(group2, set2);
                    groupLettersMap.remove(group1);
                }
            }
        }
        char[] array = S.toCharArray();
        int strLength = array.length;
        for (int i = 0; i < strLength; i++) {
            char c = array[i];
            char group = letterGroupMap.get(c);
            array[i] = group;
        }
        return new String(array);
    }	
	
	 private int[] p;

	 public String smallestEquivalentString1(String s1, String s2, String baseStr) {
	        p = new int[26];
	        for (int i = 0; i < 26; ++i) {
	            p[i] = i;
	        }
	        for (int i = 0; i < s1.length(); ++i) {
	            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
	            int pa = find(a), pb = find(b);
	            if (pa < pb) {
	                p[pb] = pa;
	            } else {
	                p[pa] = pb;
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        for (char a : baseStr.toCharArray()) {
	            char b = (char) (find(a - 'a') + 'a');
	            sb.append(b);
	        }
	        return sb.toString();
	    }

	    private int find(int x) {
	        if (p[x] != x) {
	            p[x] = find(p[x]);
	        }
	        return p[x];
	    }
}
