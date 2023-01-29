package My_Learning.strings;

public class GoalParseLeetcode1678 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String interpret(String command) {
		String res = command.replace("()", "o");
		String res2 = res.replace("(al)", "al");
		return res2;
	}

}
