package My_Learning.Arrays2;

public class DecodedXORArrayLeetcode1720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] decode(int[] encoded, int first) {
		int arr[] = new int[encoded.length + 1];
		arr[0] = first;
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i + 1] = arr[i] ^ encoded[i];
		}
		return arr;
	}

}
