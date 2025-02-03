// https://school.programmers.co.kr/learn/courses/30/lessons/68936
class Solution {
    int[] answer = {0, 0};
    int[][] arr;
    int compressible(int x, int y, int n){
        int sum = 0;
        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                sum+=arr[x+i][y+j];
            }
        }
        if(sum == 0) return 0;
        if(sum == n*n) return 1;
        return -1;
    }
    
    void compress(int x, int y, int n){
        if(n == 0){
            answer[arr[x][y]]++;
            return;
        }
        int i = compressible(x, y, n);
        if(i>-1){
            answer[i]++;
            return;
        }
        compress(x,y,n/2);
        compress(x+n/2,y,n/2);
        compress(x,y+n/2,n/2);
        compress(x+n/2,y+n/2,n/2);
    }
    
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        compress(0,0,arr.length);
        return answer;
    }
}
