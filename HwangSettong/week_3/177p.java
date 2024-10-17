// https://school.programmers.co.kr/learn/courses/30/lessons/81303
import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[][] list = new int[n][2]; // {prev, next}
        int temp;
        for(int i = 0; i<n; i++){
            list[i][0] = i-1; // prev
            list[i][1] = i+1; // next
            answer.append("O");
        }
        for(String c : cmd){
            if(c.charAt(0) == 'D'){
                temp = Integer.parseInt(c.split(" ")[1]);
                for(int i = 0; i<temp; i++){
                    k = list[k][1];
                }
            }else if(c.charAt(0) == 'U'){
                temp = Integer.parseInt(c.split(" ")[1]);
                for(int i = 0; i<temp; i++){
                    k = list[k][0];
                }
            }else if(c.charAt(0) == 'C'){
                stack.push(k);
                //list[prev]의 next값을 현재 next값으로 변경
                if(list[k][0] > -1){
                    list[list[k][0]][1] = list[k][1];
                }
                //list[next]의 prev값을 현재 prev값으로 변경
                if(list[k][1] < n){
                    list[list[k][1]][0] = list[k][0]; 
                }
                // k 값 변경
                k = list[k][1] < n ? list[k][1] : list[k][0];
            }else{
                temp = stack.pop();
                if(list[temp][1] < n){
                    list[list[temp][1]][0] = temp;
                }if(list[temp][0] > -1){
                    list[list[temp][0]][1] = temp;
                }
            }
        }
        while(!stack.isEmpty()){
            temp = stack.pop();
            answer.replace(temp, temp+1, "X");
        }
        
        return answer.toString();
    }
}
