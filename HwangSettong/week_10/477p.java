// https://school.programmers.co.kr/learn/courses/30/lessons/12952
class Solution {
    int n;
    boolean[][] board; // n x n의 체스판
    int answer = 0; // 퀸이 n개 배치되면 1씩 증가
    
    
    // 대각선이나 같은 행, 열에 퀸이 있는지 체크. 있으면 true, 없으면 false
    boolean checkCondition(int x, int y){
        for(int i=0; i<n; i++){
            if(board[x][i]) return true;
            if(board[i][y]) return true;
            if(x>=i && y>=i && board[x-i][y-i]) return true; 
            if(x>=i && y+i<n && board[x-i][y+i]) return true;
            if(x+i<n && y>=i && board[x+i][y-i]) return true; 
            if(x+i<n && y+i<n && board[x+i][y+i]) return true;
        }
        return false;
    }
    
    
    void backtracking(int row){
        // 마지막 행까지 퀸을 배치됐다면 answer를 1 증가시킴
        if( row == n){ 
            answer++;
            return;
        }
        
        for(int col=0; col<n; col++){
            if(checkCondition(row, col)) continue; // 백트래킹 조건에 걸리면 탐색 안함
            board[row][col] = true; // 해당 위치에 퀸 배치
            backtracking(row+1); // 재귀호출하여 다음 행 퀸 배치
            board[row][col] = false; // 해당 위치에 퀸 배치 취소
        }
    }
    
    
    
    public int solution(int n) {
        this.n = n;
        this.board = new boolean[n][n];
        backtracking(0);
        return this.answer;
    }
}
