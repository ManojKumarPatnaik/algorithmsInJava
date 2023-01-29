package My_Learning.strings;

public class MaximumNumberOfWordsInSentanceLeetcode2114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mostWordsFound(String[] sentences) {
		int max = 0;
		for (int i = 0; i < sentences.length; i++) {
			max = Math.max(max, (sentences[i].split(" ")).length);
		}
		return max;
	}

}
