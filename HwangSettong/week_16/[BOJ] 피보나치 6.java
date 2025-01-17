/*
https://www.acmicpc.net/problem/11444

n의 피보나치수 Fn에 대하여 아래 공식을 참고하였다.
| 1  0 | ^n = | Fn+1  Fn   |
| 1  1 |      | Fn    Fn-1 |

n이 짝수일 경우 A^n은 A^(n/2)^2 이다.
n이 홀수일 경우 A^n은 A^(n/2)^2 * A 이다.
제곱 공식을 이용하여 행렬의 n승을 빠르게 계산할 수 있다.

*/
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n == 0 || n == 1 || n == 2){
            System.out.println(Math.min(1, n));
            return;
        }
        long[][] res = fibonacci(n);
        System.out.println(res[0][1]);
    }


    // 피보나치 재귀 함수
    private static long[][] fibonacci(long n){
        if(n == 1){
            return new long[][]  {{1,1}, {1,0}};
        }
        long[][] matrix = fibonacci(n/2);
        if(n % 2 == 0){
            return multipleMatrix(matrix, matrix);
        }else{
            return multipleMatrix(multipleMatrix(matrix, matrix), new long[][] {{1,1}, {1,0}});
        }
    }

    // 행렬 곱셈 연산
    private static long[][] multipleMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                    res[i][j] %= 1000000007;
                }
            }
        }

        return res;
    }
}
