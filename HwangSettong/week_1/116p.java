import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] st1 = {1,2,3,4,5}; // 5
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int[] a = new int[3];
        for(int i = 0; i<answers.length; i++){
            a[0] += st1[i%5] == answers[i] ? 1 : 0;
            a[1] += st2[i%8] == answers[i] ? 1 : 0;
            a[2] += st3[i%10] == answers[i] ? 1 : 0;
        }
        int maxScore = Arrays.stream(a).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i =0; i<3; i++){
           if(maxScore == a[i]){
               answer.add(i+1);
            }            
        }
        return answer.stream().mapToInt(i -> i).toArray();

    }
}
