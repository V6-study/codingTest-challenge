// https://school.programmers.co.kr/learn/courses/30/lessons/43163

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    String tarStr;
    
    public int solution(String begin, String target, String[] words) {
        tarStr = target;
        visited = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            if(isDiff(begin, words[i])){
                dfs(i, words, 1);
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        
        return answer;
    }
    
    void dfs(int idx, String[] words, int count){
        if(words[idx].equals(tarStr)){
            answer = Math.min(answer, count);
        }
        
        for(int i=0; i<words.length; i++){
            // 방문하지 않은 곳인지 확인
            if(i != idx && isDiff(words[idx], words[i]) && !visited[i]){
                visited[idx] = true;
                dfs(i, words, count+1);
                visited[idx] = false;
            }
        }
    }
    
    boolean isDiff(String curStr, String diffStr){
        int diff = 0;
        for(int i=0; i<curStr.length(); i++){
            if(curStr.charAt(i) != diffStr.charAt(i)){
                diff++;
            }
        }
        
        if(diff != 1) return false;
        return true;
    }
}
