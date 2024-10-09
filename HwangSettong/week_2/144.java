import java.util.Stack;
class Solution {
	static boolean solution(String s) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push("(");
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
