//https://school.programmers.co.kr/learn/courses/30/lessons/64064#
import java.util.*;
class Solution {
    ArrayList<ArrayList<String>> ban_arr = new ArrayList<>(); // 매핑된 제재 아이디 리스트
    HashSet<String> answer = new HashSet<>(); // 모든 제재아이디 매핑 완료된 것들 중복 없이 저장
    void backtracking(int n, HashSet<String> set){
        // 중복 없이 전부 매핑 시 return
        if(n == ban_arr.size()){
            List<String> tempSet = new ArrayList<>(set);
		    Collections.sort(tempSet);
            answer.add(tempSet.toString());
            return;
        }
        
        for(String id : ban_arr.get(n)){
            if(!set.contains(id)){ // set에 없는 id만
                set.add(id);       // set에 추가
                backtracking(n+1, set); // 재귀
                set.remove(id);    // set에서 삭제
            }
        }
    }
    
    
    public int solution(String[] user_id, String[] banned_id) {
        for(String bid: banned_id){
            ArrayList<String> temp = new ArrayList<>();
            String cp = bid.replace("*",".");
            for(String id: user_id){
                if(id.matches(cp)){
                    temp.add(id);
                }  
            }
            ban_arr.add(temp);
        }
        
        backtracking(0, new HashSet<String>());
        return answer.size();
    }
    
}
