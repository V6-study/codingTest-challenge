public class Solution {
    int[][] solution (int[][] arr, int n){
        if(n == 4) return arr; // n이 4면 바로 return

        for(int cnt = 0; cnt<n; cnt++){ // n번 90도 회전 시행
            int[][] temp = new int[arr[0].length][arr.length];
            for(int r = 0; r < arr.length; r++){
                for(int c = 0; c < arr[0].length; c++){
                    temp[c][arr.length-1-r] = arr[r][c];
                }
            }
            arr = temp; // arr를 temp로 교체
        }
        return arr;
    }
}
