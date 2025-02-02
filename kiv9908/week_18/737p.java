import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); // 팀 A 정렬
        Arrays.sort(B); // 팀 B 정렬
        
        int answer = 0;
        int j = B.length-1; // 팀 B의 포인터
        
        for (int i = A.length-1; i >= 0 ; i--) {
            if(A[i]<B[j]){
                answer++;
                j--;
            }
        }
        
        return answer;
    }
}
