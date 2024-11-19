/*
https://www.acmicpc.net/problem/1629
이 문제는 a, b, c의 숫자가 굉장히 클 수 있다는 점을 고려해야한다.
시간제한은 0.5초인데 for문을 그냥 사용하면 최악의 경우 2,147,483,647번 돌아야 하므로 시간초과가 발생할 수 있음.
때문에 분할정복으로 풀어야 함.
*/
import java.io.*;
import java.util.*;

public class Main {

    static long sqrt(long a, long b, long c){
        if(b==1) return a%c; // b가 1이면 a%c를 반환
        long temp = sqrt(a, b/2, c); // b를 2로 나누어 재귀호출
        if(b%2 == 0){ // b가 짝수이면 재귀호출 결과를 제곱하고 c로 나눈 나머지 반환
            return temp*temp % c;
        }else{ // b가 홀수이면 재귀호출 결과를 제곱하고 a를 한번 더 곱해준 후 c로 나눈 나머지 반환
            return ((temp*temp % c) *a) % c;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // a, b, c 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(sqrt(a, b, c));
    }
}
