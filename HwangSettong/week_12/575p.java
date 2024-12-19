public class Solution {
    int[][] multiplication(int[][] m1, int[][] m2){ // 행렬 곱
        int[][] res = new int[3][3];
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                for(int d=0; d<3; d++){
                    res[r][c] += m1[r][d] * m2[d][c];
                }
            }
        }
        return res;
    }

    int[][] transposed(int[][] m){ // 전치행렬
        int[][] res = new int[3][3];
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                res[r][c] = m[c][r];
            }
        }
       return res;
    }

    int[][] solution(int[][] m1, int[][] m2){
        return transposed(multiplication(m1, m2));
    }
}
