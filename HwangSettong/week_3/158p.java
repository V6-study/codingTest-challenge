import java.util.Stack;
class Solution {
	public int solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.empty() && s.charAt(i) == stack.lastElement()) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		if (stack.empty()) {
			return 1;
		}
		return 0;
	}
}
