class Solution {
    int max = 0;
    int[] answer;
    int[] apeach;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);
        
        return max == 0 ? new int[]{-1} : answer;
    }
    
    int getScore(int[] ryan){
        int score = 0;
        
        for(int i=0; i<11; i++){
            if(ryan[i] + apeach[i] > 0){
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }
    
    void calculateDiff(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        }else if(max > 0 && max == score){
            for(int i=10; i>=0; i--){
                if(answer[i] != ryan[i]){
                    if(answer[i] < ryan[i]){
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    
    void backtrack(int n, int idx, int[] ryan){
        if(n == 0){ // 화살을 모두 사용한 경우
            calculateDiff(ryan); // 현재 배열로 점수 차이 계산
            return;
        }
        
        for(int i=idx; i<=10; i++){ // 현재 점수 구간부터 탐색
            int cnt = Math.min(n, apeach[i] + 1); // 최대한 필요한 화살만큼
            ryan[i] = cnt; // 현재 점수 구간에 화살 할당
            backtrack(n - cnt, i + 1, ryan); // 남은 화살과 다음 점수 구간 탐색
            ryan[i] = 0; // 상태 복구
        }
    }
    
}
