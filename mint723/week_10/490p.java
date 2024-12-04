// https://school.programmers.co.kr/learn/courses/30/lessons/60062
import java.util.*;

class Solution {
    int length, answer;
    int[] arr;
    boolean[] visited;
    public int solution(int n, int[] weak, int[] dist) {
        length = weak.length;
        arr = new int[length * 2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                arr[j + (i * length)] = weak[j] + (i * n);
            }
        }
        
        Arrays.sort(dist);
        answer = -1;
        visited = new boolean[dist.length];
        
        for(int i=1; i<= arr.length; i++){
            int[] org = new int[i];
            System.arraycopy(dist, dist.length - i, org, 0, i);
            backtrack(0, new int[i], org);
            if(answer > 0)
                break;
        }        
        
        return answer;
    }
    
    boolean check(int[] dist){
        for(int i=0; i< length; i++){
            int idx = i;
            for(int distance : dist){
                int position = arr[idx++] + distance;;
                while (idx < arr.length && arr[idx] <= position){
                    idx ++;
                }
            }
            
            if(idx - i >= length)
                return true;
        }
        return false;
    }
    
    void backtrack(int n, int[] dist, int[] org){
        if (n == org.length){
            if(check(dist)){
                answer = n;
            }
            return;
        }
        
        for(int i=0; i<org.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dist[n] = org[i];
                backtrack(n + 1, dist, org);
                visited[i] = false;
            }
        }
    }
}
