package My_Learning.strings;

public final class CheckDistanceBetweenSameLetterLeetcode2399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaccb";
		int[] distance = { 1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(checkDistances(s, distance));

	}

	public static boolean checkDistances(String s, int[] distance) {
//		Map<Character, List<Integer>> map = new HashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			Character ch = s.charAt(i);
//			if (map.containsKey(ch)) {
//				List<Integer> indexList = map.get(ch);
//				indexList.add(i);
//				map.put(ch, indexList);
//			} else {
//				map.put(ch, new ArrayList<Integer>(Arrays.asList(i)));
//			}
//		}

		for (char ch : s.toCharArray()) {
			System.out.println("ch : " + ch + ", distance at : " + (ch - 'a') + ", " + (distance[ch - 'a'])
					+ ", first index : " + s.indexOf(ch) + ", last index : " + s.lastIndexOf(ch));
			if (distance[(ch - 'a')] != (s.lastIndexOf(ch) - (s.indexOf(ch) + 1)))
				return false;

		}

		return true;
	}
}
