import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while(right>=left){
            if(people[left] + people[right] <= limit){
                // 제일 몸무게 적은 사람, 제일 몸무게 많은 사람 합이 limit 이하이면
                left++;
                right--;
            }else{
                right--;
            }
            answer++;
        }
        return answer;
    }
}
