//https://school.programmers.co.kr/learn/courses/30/lessons/42584
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length-1; i++){
            for(int j = i+1; j< prices.length; j++){
                answer[i] = j-i;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        return answer;
    }
}
