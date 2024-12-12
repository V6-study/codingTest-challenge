// https://school.programmers.co.kr/learn/courses/30/lessons/42748
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; // commands 크기만큼의 배열
        for(int i = 0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // 배열 잘라서 복사
            Arrays.sort(temp); // 정렬
            answer[i] = temp[commands[i][2]-1]; // k번째 숫자 answer에 저장
        }
        
        return answer;
    }
}
