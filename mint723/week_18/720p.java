import java.util.*;
class Solution {
    String[] user_id;
    String[] banned_id;
    boolean[] visited;
    int n,m;
    Set<Set<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        n = user_id.length; m = banned_id.length;
        visited = new boolean[n];
        
        dfs(new HashSet<>(),0);
        return answer.size();
    }
    
    void dfs(Set<String> set, int depth){
        if(depth == m){
            answer.add(set);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(set.contains(user_id[i])){
                continue;
            }
            
            if(check(user_id[i], banned_id[depth])){
                set.add(user_id[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(user_id[i]);
            }
        }
    }
    
    boolean check(String userId, String bannedId){
        if(userId.length() != bannedId.length())
            return false;
        
        for(int i=0; i<userId.length(); i++){
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i))
                return false;
        }
        
        return true;
    }
}
