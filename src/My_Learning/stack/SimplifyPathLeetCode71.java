package My_Learning.stack;

import java.util.*;

public class SimplifyPathLeetCode71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to get simplified path
	public String simplifyPath1(String path) {
		Deque<String> stack = new LinkedList<>();
		// Don't push the .. , . , ""
		// Only push the valid names
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}

	public String simplifyPath2(String path) {
		Stack<String> stack = new Stack<>();
		String[] p = path.split("/");
		for (int i = 0; i < p.length; i++) {
			if (!stack.empty() && p[i].equals(".."))
				stack.pop();
			else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
				stack.push(p[i]);
		}
		List<String> list = new ArrayList<>(stack);
		return "/" + String.join("/", list);
	}
}
