//https://school.programmers.co.kr/learn/courses/30/lessons/92335
class Solution {
	boolean checkPrime(double p) {
		if (p == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(p) ; i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		while (n > 0) {
			if (n % k == 0) {
				if (sb.length() > 0 && checkPrime(Long.parseLong(sb.toString()))) {
					answer += 1;
				}
				sb.setLength(0);
			} else {
				sb.insert(0, Integer.valueOf(n % k));

			}
			n /= k;
		}
		if (sb.length() > 0 && checkPrime(Long.parseLong(sb.toString()))) {
			answer += 1;
		}
		return answer;
	}
}
