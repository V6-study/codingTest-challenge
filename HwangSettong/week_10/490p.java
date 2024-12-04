// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/60062
// 참고 답안: https://github.com/retrogemHK/codingtest_java/blob/main/solution/47.java

import java.util.*;
class Solution {
    int[] org;
    int[] weak; // 두배로 확장한 weak 배열
    boolean[] used; // 배치된 친구 check
    int answer = -1;
    
    // dist 배열의 친구들로 모든 외벽이 점검 가능한지 확인
    boolean check(int[] dist){
        for(int i = 0; i<weak.length/2; i++){ // weak 순회
            int idx = i;
            for(int d: dist){ // dist 순회
                int position = weak[idx++] + d; // position = 취약지점 + 친구의 이동거리
                // 다음 취약지점을 현재 친구가 점검할 수 없을때까지 idx 증가시켜줌.
                while( idx < weak.length && weak[idx] <= position){
                    idx++;
                }
            }
            if(idx-i >= weak.length/2) return true; // 모든 취약지점을 점검함   
        }
        return false;
    }
    
    // cnt: 배치된 친구 수, dist: org 배열의 친구들을 조합한 배열
    void dfs(int cnt, int[] dist, int[] org){
        if(cnt == org.length){ // org의 모든 친구들을 배치함
            // dist 배열의 친구들로 모든 취약지점 점검 가능하면 답 저장
            if(check(dist)) answer = cnt; 
            return;
        }
        
        
        for(int i=0; i<org.length; i++){
            if(!used[i]){ // 한번도 사용된 적 없는 친구
                used[i] = true; // 사용 표시
                dist[cnt] = org[i]; // org 배열의 친구들을 n번째 순서로 차례로 담아서 탐색
                dfs(cnt+1, dist, org);
                used[i] = false; // 백트래킹 되었으면 사용된 적 없음으로 표시
            }
        }
    }
    
    
    public int solution(int n, int[] weak, int[] dist) {
        // weak 배열 두배로 확장
        this.weak = new int[weak.length * 2];
        for(int i = 0; i< weak.length; i++){
            this.weak[i] = weak[i];
            this.weak[i+weak.length] = weak[i]+n;
        }
        
        Arrays.sort(dist); // dist 배열 내림차순 정렬
        this.used = new boolean[dist.length]; // used 배열 생성
        
        
        // 점검범위가 큰 친구부터 1명씩 늘려가며 탐색
        for(int i = 1; i<=dist.length; i++){
            // 점검 범위가 큰 친구 i명 배열 생성
            org = new int[i];
            for(int j = 0; j<i; j++) org[j] = dist[dist.length-1-j];
            // 탐색
            dfs(0, new int[i], org);
            // 모든 취약지점을 점검 완료 했으면 탐색 중지
            if(answer > 0) break;
        }
        
        return answer;
    }
}
