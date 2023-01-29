package My_Learning.strings;

public class ShuffleStringLeetcode1528 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String restoreString(String s, int[] indices) {
		char[] arr = new char[s.length()];
		for (int i = 0; i < indices.length; i++)
			arr[indices[i]] = s.charAt(i);
		return String.valueOf(arr);
	}

}
