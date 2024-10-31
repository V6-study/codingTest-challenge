// https://school.programmers.co.kr/learn/courses/30/lessons/72411
import java.util.*;
class Solution {
    int max; // 최대 주문 횟수
    int cnt; // 코스의 구성 메뉴 수
    String[] order; // 주문 메뉴 배열
    HashMap<String, Integer> map = new HashMap<>(); // key:코스, value:주문횟수
    
    void combination(int i, String combi){ // dfs 방식으로 조합 만듦. i:인덱스, combi:코스조합
        combi = combi + order[i]; // 코스 조합하기.
        // 조합된 메뉴 수가 요구되는 메뉴 수랑 같으면 map에 update하고 return
        if(cnt == combi.length()){ 
            int temp =  map.getOrDefault(combi, 0) + 1;
            map.put(combi, temp);
            max = max<temp ? temp:max;
            return;
        }
        // 아직 요구되는 메뉴 수량보다 조합된 메뉴 슈가 작으면 조합 이어가기
        if(cnt > combi.length()){
             for(int idx = i+1; idx < order.length; idx++){
                combination(idx, combi);
            }
        }
       
    } 
    
    
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for(int c : course){
            map.clear(); // map 초기화
            max = 2; // max 초기화
            cnt = c; // cnt 값 초기화
            for(String o: orders){ 
                order = o.split(""); // order 초기화
                Arrays.sort(order); // order 정렬
                for(int i = 0; i < order.length; i++){
                    combination(i, "");
                }
            }
            
            // 주문횟수가 max와 같은것 answer에 담기
            for(String o: map.keySet()){ 
                if(map.get(o) == max){
                    answer.add(o);
                }   
            }
            
        }
        
        Collections.sort(answer); // answer 오름차순 정렬
        return answer.toArray(new String[answer.size()]);
    }
}
