//https://school.programmers.co.kr/learn/courses/30/lessons/12951
class Solution {
    public String solution(String s) {
		StringBuilder sb = new StringBuilder(s.toLowerCase());
		String[] arr = s.split("");
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (arr[i].equals(" ")) {
				flag = true;
				continue;
			}
			if (flag) {
				sb.replace(i, i + 1, arr[i].toUpperCase());
				flag = false;
			}
		}

		return sb.toString();
	}
}
