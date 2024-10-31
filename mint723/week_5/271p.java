// https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {
    static Map<Integer, Map<String,Integer>> courseMap;
    
    public List<String> solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for(int i : course){
            courseMap.put(i, new HashMap<>());
        }
        
        // 각 주문에 대해 모든 가능한 조합 생성
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            // 조합에서 AB, BA는 같은 코스로 체크해야함
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        List<String> answer = new ArrayList<>();
        
        // 각 코스 길이별로 정리
        for(Map<String, Integer> count : courseMap.values()){
            count.values()
                .stream()
                .max(Comparator.comparingInt(i -> i)) // 가장 빈도수가 높은 코스
                .ifPresent(cnt -> count.entrySet() // 코스에 대한 메뉴 수가 가능할 때만
                         .stream()
                         .filter(entry -> cnt.equals(entry.getValue()) && cnt>1) // 2명 이상의 손님으로부터 주문된 단품 메뉴 조합
                         .forEach(entry -> answer.add(entry.getKey()))); 
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    // 조합 메서드
    static void combinations(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            Map<String, Integer> map = courseMap.get(result.length());
            
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for(int i=idx; i<order.length; i++){
            combinations(i + 1, order, result + order[i]);
        }
    }
}
