package My_Learning.strings;

public class CrowlerLogFolderLeetcode1598 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minOperations(String[] logs) {
		int depth = 0;
		for (String log : logs) {
			if (log.equals("../")) {
				depth = Math.max(0, --depth);
			} else if (!log.equals("./")) {
				++depth;
			}
		}
		return depth;
	}

}
