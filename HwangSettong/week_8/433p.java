// https://school.programmers.co.kr/learn/courses/30/lessons/12978
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 도로 길이를 담을 (n+1)*(n+1) 배열 만듦. n+1인 이유는 index 쉽게 접근하려고.
        int[][] map = new int[N+1][N+1]; 
        // road 순회하면서 map 채우기
        for(int[] r : road){             
            map[r[0]][r[1]] = map[r[0]][r[1]]==0?r[2]:Math.min(r[2],map[r[0]][r[1]]);
            map[r[1]][r[0]] = map[r[0]][r[1]]==0?r[2]:Math.min(r[2],map[r[0]][r[1]]);
        }
        map[1][1] = -1;
        
        // 최단거리 정보를 저장하는 배열
        int[] len = new int[N+1];
        // 이미 들린 마을 체크
        boolean[] visited = new boolean[N+1];
        // 거리 최소값과 출발 마을 인덱스
        int min_idx, idx = 1;
        for(int i = 0; i< N; i++){
            min_idx = 1; // min_idx 초기화;
            visited[idx] = true; // 방문했다고 체크
            for(int j=2; j<N+1; j++){ // 2~n까지 loop
                if(idx==j){continue;} // 출발 마을과 도착마을이 같으면 continue
                if(map[idx][j] != 0){ //map[출발][도착]이 0이 아니어야 함.
                    int temp = Math.max(0,len[idx]) + map[idx][j]; // 거리 합
                    if(len[j] == 0){ // len[도착] == 0이면 아묻따 temp로 바꿔줌
                        len[j] = temp;
                    }else{ // len[도착]이 0이 아니라면 len[도착]과 temp(거리합) 중 최소값으로 바꿔줌
                        len[j] = Math.min(len[j], temp);
                    }
                }
                
                // 다음 출발 마을 인덱스 구하기: 방문하지 않았고, len의 최소값 인덱스인 것
                if((min_idx == 1  || len[j] < len[min_idx] )&& len[j]>0 && !visited[j]){
                    min_idx = j;
                }
            }
            idx = min_idx;
        }
        
        answer = 0;
        for(int l : len){
            if(l>0 && l<=K){
                answer++;
            }
        }
        return answer+1;
    }
}
