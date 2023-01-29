package My_Learning.strings;

public class NumberOfSegmentInStringLeetcode434 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSegments(String s) {
		// return ("x " + s).split(" +").length - 1;

		int segs = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ')
				segs++;
			while (i < chars.length && chars[i] != ' ')
				i++;
		}
		return segs;
	}

}
