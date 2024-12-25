// https://school.programmers.co.kr/learn/courses/30/lessons/132265
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map1 = new HashMap<>(); // key:topping type, value: count
        HashMap<Integer, Integer> map2 = new HashMap<>(); // key:topping type, value: count
        for(int t: topping){ // topping 순회하며 map1 완성시키기
            map1.put(t, map1.getOrDefault(t, 0)+1);
        }
        int answer = 0;
        for(int t:topping){ // topping 순회하며 map1의 count 줄이고, map2의 count 늘리기
            map2.put(t, map2.getOrDefault(t, 0)+1); // map2의 count 1씩 늘리기
            map1.put(t, map1.get(t)-1); // map1의 count 1씩 줄이기
            if(map1.get(t) == 0) map1.remove(t); // map1에서 t의 count가 0이면 map1에서 아예 삭제
            if(map2.size() == map1.size()) answer++; // map1과 map2의 key(topping type) 수가 같으면 answer 1 증가
        }
        return answer;
    }
}
