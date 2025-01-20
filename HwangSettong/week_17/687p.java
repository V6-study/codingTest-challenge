// https://school.programmers.co.kr/learn/courses/30/lessons/42885
import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
		Arrays.sort(people);
		int p1 = 0, p2 = people.length-1;
        while(p1 <= p2){
            if(people[p1]+people[p2] <= limit){
                p1++;
            }
            p2--;
            answer++;
        }
		return answer;
    }
}
