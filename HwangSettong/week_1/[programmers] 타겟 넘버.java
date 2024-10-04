//https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
import java.util.*;
class Solution {
    int answer = 0;
    int target;
    void dfs(int[] numbers, int idx, int cal){
        if(idx == numbers.length){
            answer += target == cal ? 1 : 0;
            return;
        }
        dfs(numbers, idx+1, cal+numbers[idx]);
        dfs(numbers, idx+1, cal-numbers[idx]);
    }
    
     public int solution(int[] numbers, int target) {
        this.target = target;
        dfs(numbers, 0, 0);
        return this.answer;
    }
}
