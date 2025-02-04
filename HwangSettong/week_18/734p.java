//https://school.programmers.co.kr/learn/courses/30/lessons/12987
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int a=0, b=0;
        Arrays.sort(A);
        Arrays.sort(B);
        while(a<A.length && b<B.length){
            if(A[a] < B[b]){
                a++;
                answer++;
            }
            b++;
        }
        return answer;
    }
}
