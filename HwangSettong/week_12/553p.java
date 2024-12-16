// https://school.programmers.co.kr/learn/courses/30/lessons/64065
import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>(); // key:number, value:count
        // map 에 원소 별로 나온 횟수 저장하기
        String[] temp = s.substring(2,s.length()-2).split("\\},\\{");
        for(String ss : temp){
            Arrays.stream(ss.split(",")).forEach(i->map.put(i, map.getOrDefault(i,0)+1));
        }
        String[] keySet = map.keySet().toArray(new String[map.size()]); // keySet 배열 만들기
        Arrays.sort(keySet, (o1, o2)->map.get(o2)-map.get(o1)); // 원소 나온 횟수 내림차순 정렬
        
        return Arrays.stream(keySet).mapToInt(Integer::parseInt).toArray(); // int배열로 바꿔서 리턴
    }
}
