import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int count = 0;
        int light = 0;
        int heavy = people.length-1;
        // 50 50 70 80
        while(light<= heavy){
            if(people[light]+people[heavy]<=limit){
                light++;
            }
            heavy--;
            answer++;
        }
        return answer;
    }
}