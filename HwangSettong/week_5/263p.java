// https://school.programmers.co.kr/learn/courses/30/lessons/92334
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // report_list: <key,value> = <신고당한id, 신고 한 사람 list>
        HashMap<String, Set<String>> report_list = new HashMap<>();
        
        for(String r : report){ // report 순회하기
            String[] rs = r.split(" "); // 공백 문자 기준으로 split
            if(report_list.keySet().contains(rs[1])){ // 신고당한 전적 있으면
                report_list.get(rs[1]).add(rs[0]); // 신고자 추가
            }else{ // 신고당한 전적 없으면
                Set<String> list = new HashSet<String>(); 
                list.add(rs[0]); // 신고자 추가하고
                report_list.put(rs[1], list); // report_list에 추가
            }
        }
        
        int[] answer = new int[id_list.length]; // answer 를 id_list 개수만큼의 배열로 만듦
        // id_idx : id로 index를 빨리 찾기 위한 hashmap <key, value> = <id, index>
        HashMap<String, Integer> id_idx = new HashMap<>();
        for(int i = 0; i<id_list.length; i++){ // id_idx에 값 넣기
            id_idx.put(id_list[i],i);
        }
        
        for(String key : report_list.keySet()){ // report_list 순회
            if(report_list.get(key).size() >= k){ // 신고한 사람 리스트의 크기가 k와 같거나 크면
                for(String idx :report_list.get(key)){ // 신고한 사람 리스트 순회
                    answer[id_idx.get(idx)]++; // 신고한 사람 answer 배열에 +1해줌.
                }
            }
        }
        
        return answer;
    }
}
