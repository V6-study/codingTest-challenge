// https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int type; // 폰켓몬 종류
        for(int i = 0; i<nums.length; i++ ){ // nums를 순회
            // 폰켓몬 종류 별 개수 담기
            type = nums[i]; 
            map.put(type, map.getOrDefault(type, 0) + 1); 
        }
        // 만약 폰켓몬의 종류 수가 N/2보다 크거나 같으면 N/2를 리턴
        if(map.size() >= nums.length/2){
            return nums.length/2;
        }
        // 만약 폰켓몬의 종류가 N/2보다 작으면 폰켓몬의 종류 수를 리턴
        return map.size();
    }
}
