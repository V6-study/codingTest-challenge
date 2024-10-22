// https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        // 다리를 0으로 초기화
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        // 모든 트럭이 지나갈 때까지 반복
        while(truckIndex < truck_weights.length) {
            // 시간 증가
            time++;
            
            // 다리에서 나가는 트럭의 무게를 뺌
            currentWeight -= bridge.poll();
            
            // 새 트럭이 들어갈 수 있는지 확인
            if(currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridge.offer(0);
            }
        }
        
        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        return time + bridge_length;
    }
}
