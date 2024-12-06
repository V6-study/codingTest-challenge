// https://school.programmers.co.kr/learn/courses/30/lessons/42839
import java.util.*;

class Solution {
    Set<Integer> set;
    int N;
    boolean[] visited;
    int[] arr;
    public int solution(String numbers) {
        N = numbers.length();
        set = new HashSet<>();
        visited = new boolean[N];
        arr = new int[N];
        for(int i = 0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        
        dfs(-1,0);
        System.out.println(set);
        return set.size();
    }

    void dfs(int n, int depth){
        
        if (n != -1 && isPrime(n)) {
            set.add(n);
        }
        
        if (depth == N) {
            return;
        }
        
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                int next = (n == -1) ? arr[i] : Integer.parseInt(n + "" + arr[i]);
                dfs(next, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
