// https://school.programmers.co.kr/learn/courses/30/lessons/92342
class Solution {
    int maxScore = -1;
    int[] info;
    int[] answer = {-1};
    
    void updateAnswer(int[] arr, int score){
        // 최고 점수 차보다 score값이 작으면 return
        if(score < maxScore) return;
        // 최고 점수 차이면 answer을 arr로 교체
        if(score > maxScore){
            maxScore = score; // 최고 점수 차 update
            answer = arr.clone(); // answer arr로 교체
            return;
        }
        // 낮은 점수부터 확인. arr[i] < answer[i]이면 answer을 arr로 교체
        for(int i=10; i>=0; i--){ 
            if(arr[i] != answer[i]){ 
                if(arr[i] > answer[i]) answer = arr.clone();
                return;
            }
        }
    }
    
    void solution(int n, int i, int ryan, int apeach, int[] arr){
        if(n<0) return; // 횟수 초과
        if(n==0 || i == 10){// 모든 횟수 소진 또는 모든 점수 탐색 완료.
            // ryan이 apeach 보다 점수가 높으면 updateAnswer 호출해서 answer 값 변경
            if(ryan > apeach){ 
                arr[10] = n; // 남은 횟수 0점으로 소진
                updateAnswer(arr, ryan-apeach);
            } 
            return;
        }
    
        // ryan이 점수를 가져가는 경우
        arr[i] = info[i]+1;
        solution(n-arr[i], i+1, ryan+10-i, apeach-(info[i]==0?0:10-i), arr); 
        
        // ryan이 점수를 가져가지 않는 경우
        arr[i] = 0;
        solution(n, i+1, ryan, apeach, arr);
    }
    
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        int apeach = 0;
        for(int i = 0; i<11; i++){
            if(info[i] != 0) apeach += 10-i;
        }
        solution(n,0,0,apeach, new int[11]);
        return answer;
    }
}
