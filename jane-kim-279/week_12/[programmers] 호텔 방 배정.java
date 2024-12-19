import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        HashMap<Long, Long> roomMap = new HashMap<>();  // 다음 사용 가능한 방 번호를 저장하기로 하자
        int n = room_number.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = findEmptyRoom(room_number[i], roomMap);
        }
        
        return answer;
    }
    
    private long findEmptyRoom(long want, HashMap<Long, Long> roomMap) {
        // 원하는 방이 비어있으면 바로 배정
        if (!roomMap.containsKey(want)) {
            roomMap.put(want, want + 1);  // 다음 사용 가능한 방을 want + 1로 설정
            return want;
        }
        
        // 이미 배정된 방이면 재귀적으로 다음 방 찾기
        long nextRoom = findEmptyRoom(roomMap.get(want), roomMap);
        roomMap.put(want, nextRoom + 1);  // 현재 방의 다음 가능한 방 업데이트
        return nextRoom;
    }
}
