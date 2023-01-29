package My_Learning.LeetCodeQuestions;

public class RobotReturnToOriginLeetCode657 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Initially you are at (0,0)
	 * You are given a string moves that represents the move sequence of the robot
	 * where moves[i] represents its ith move. Valid moves are 'R' (right), 'L'
	 * (left), 'U' (up), and 'D' (down).
	 * 
	 * Return true if the robot returns to the origin after it finishes all of its
	 * moves, or false otherwise.
	 */

	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;

		for (char c : moves.toCharArray()) {
			if (c == 'U') {
				y += 1;
			}

			else if (c == 'D') {
				y -= 1;
			} else if (c == 'L') {
				x -= 1;
			} else if (c == 'R') {
				x += 1;
			}
		}

		return (x == 0 && y == 0);
	}

	
	public boolean judgeCircle2(String moves) {
        int l = 0, r = 0, u = 0, d = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    l++;
                    break;
                case 'R':
                    r++;
                    break;
                case 'U':
                    u++;
                    break;
                case 'D':
                    d++;
                    break;
            }
        }
        return (l == r && u == d);

    }
}
