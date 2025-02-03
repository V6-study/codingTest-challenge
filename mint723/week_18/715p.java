// https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    int[][] arr;
    int[] answer = {0, 0};
    
    public int[] solution(int[][] a) {
        arr = a;
        compress(0,0, arr.length);
        
        return answer;
    }
    
    boolean isValid(int x, int y, int n){
        int sum = 0;
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                sum += arr[i][j];
            }
        }
        
        if(sum == 0 || sum == n*n)
            return true;
        
        return false;
    }
    
    void compress(int x, int y, int n){
        if(isValid(x,y,n)){
            answer[arr[x][y]] ++;
        }else{
            compress(x, y, n/2);
            compress(x+n/2, y, n/2);
            compress(x, y+n/2, n/2);
            compress(x+n/2, y+n/2, n/2);
        }
    }
}
