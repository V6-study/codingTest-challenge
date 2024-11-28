import java.util.*;

class Solution{
    int[][] board;
    List<int[]> empty; // 비어있는 칸 {row, col}
    void init(int[][] board){ // board, empty 초기화
        this.board = board;
        empty = new ArrayList<>();
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if(board[row][col] == 0) empty.add(new int[]{row, col});
            }
        }
    }

    // 백트래킹 조건 확인하는 함수. true면 백트래킹
    boolean conditionCheck(int row, int col, int num){
        for(int i=0; i<9; i++){
            if(board[row][i] == num || board[i][col] == num) return true; // 같은 행 또는 열에 num이 있음
            if(i<3){ // 같은 3x3박스에 num이 있음
                if(board[(row/3)*3+i][(col/3)*3+0] == num) return true;
                if(board[(row/3)*3+i][(col/3)*3+1] == num) return true;
                if(board[(row/3)*3+i][(col/3)*3+2] == num) return true;
            }
        }
        return false;
    }

    // 백트래킹 함수
    boolean backtracking(int emptyIdx, int num){
        if(emptyIdx == empty.size()) return true; // 빈 칸 다 채웠으면 끝. true 리턴
        int[] cur = empty.get(emptyIdx); // 값 채워줄 빈칸 꺼내기
        if(conditionCheck(cur[0], cur[1], num)){ // 백트래킹 조건 확인
            return false;
        }

        board[cur[0]][cur[1]] = num; // board에 값 채워주기

        // 재귀하여 다음 빈 칸 확인
        for(int n = 1; n <= 9; n++){
            if(backtracking(emptyIdx+1 ,n)) return true; // 리턴값이 true면 탐색 중지
        }

        board[cur[0]][cur[1]] = 0; // 백트래킹 되었으면 값 0으로 돌려놓기
        return false;
    }


    int[][] solution(int[][] board){
        init(board);
        for(int num = 1; num <= 9; num++){ // 첫번째 빈 칸에 1부터 값 넣어보기
            if(backtracking(0, num)) break;
        }
        return board;
    }
}
