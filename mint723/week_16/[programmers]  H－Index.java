// https://school.programmers.co.kr/learn/courses/30/lessons/42747

class Solution {
    public int solution(int[] citations) {
        int answer = 1;
        int h=0;
        for (int i = 0; i < citations.length; i++) {
			answer=0;
			for (int j = 0; j < citations.length; j++) {
				if (citations[j]>=h) {
					answer++;
				}
			}
			if(h<answer) {
				h++;
			}
		}
        return answer;
    }
}
