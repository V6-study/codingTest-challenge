// https://school.programmers.co.kr/learn/courses/30/lessons/12983
import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        // 단어조각 사이즈 해 저장
        HashSet<Integer> sizes = new HashSet<>();
        for(String str : strs){
            sizes.add(str.length());
        }
        // 다이나믹프로그래밍 이용하여 단어조각 조합 수 찾기
        Integer[] dp = new Integer[t.length()+1];
        dp[0] = 0;
        for(int i = 1; i <= t.length(); i++){
            for(int size: sizes){
                if(size > i) continue;
                // t[0:size]와 t[size:i]를 사용해서 조합할 수 없으면 continue
                if(dp[i-size] == null) continue; 
                // 탐색하려는 단어조각 조합이 최소개수가 아니면 continue
                if(dp[i] != null && dp[i] <= dp[i-size]+1) continue; 
                // t[size:i] 단어조각이 있으면 조합 개수 저장
                if(Arrays.asList(strs).contains(t.substring(i-size,i))){ 
                    dp[i] = dp[i-size]+1;
                }
            }
        }
        return dp[dp.length-1] == null? -1 : dp[dp.length-1];
    }
}
