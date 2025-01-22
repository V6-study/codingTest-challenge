// https://school.programmers.co.kr/learn/courses/30/lessons/12979
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1, end;
        for(int i=0; i<stations.length; i++){
            end = stations[i]-w-1;
            if(end>=start){
                answer += Math.ceil((double)(end-start+1)/(w*2+1));
            }
            start = stations[i]+w+1;
        }            
        answer += Math.ceil((double) Math.max(n-start+1,0)/(w*2+1));
        return answer;
    }
}
