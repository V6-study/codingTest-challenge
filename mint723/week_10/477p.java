// https://school.programmers.co.kr/learn/courses/30/lessons/12952
class Solution {
    int answer = 0;
    int[] arr;
    int target;
    
    public int solution(int n) {
        target = n;
        arr = new int[n];
        dfs(0);
        return answer;
    }
    
    void dfs(int depth){
        if(depth == target){
            answer++;
            return;
        }
        
        for(int i=0; i<target; i++){
            arr[depth] = i;
            if(isValid(depth)){
                dfs(depth+1);
            }
        }
    }
    
    boolean isValid(int depth){
        for(int i=0; i<depth; i++){
            if(arr[i] == arr[depth])
                return false;
            if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;
    }
}
