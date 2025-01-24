// https://school.programmers.co.kr/learn/courses/30/lessons/150369#
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for(int i = n-1; i>=0; i--){
            while(deliveries[i] > 0 || pickups[i] > 0){
                deliveries[i] -= cap;
                pickups[i] -= cap;
                answer += 2*(i+1);
            }

            if(i!=0 && deliveries[i]<0){
                deliveries[i-1] += deliveries[i];
            }

            if(i!=0 && pickups[i]<0){
                pickups[i-1] += pickups[i];
            }
              
        }
        return answer;
    }
}
