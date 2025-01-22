class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2*w+1; // 기지국이 커버할 수 있는 범위
        int curCoverage = 0; // 현재 전파가 닿는 최대 위치
        
        for(int station : stations){
            // station 기준 전파가 닿는 시작 끝 지점
            int start = station - w;
            int end = station + w;
            
            // 전체 중 전파가 닿지 않는 범위의 시작 끝 지점
            int uncoveredStart = curCoverage +1;
            int uncoveredEnd = Math.max(0, start - 1);
            
            // 전파가 닿지 않는 영역이 존재할 때
            if(uncoveredStart <= uncoveredEnd){
                int uncoveredLength = uncoveredEnd - uncoveredStart + 1;
                answer += Math.ceil((double)uncoveredLength / range);
            }
            
            curCoverage = end;
        }
        
        // 마지막 station 이후 남은 구간 처리
        if(curCoverage < n){
            int uncoveredLength = n - curCoverage;
            answer += Math.ceil((double) uncoveredLength / range);
        }
        
        return answer;
    }
}
