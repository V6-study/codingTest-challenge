import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i<prices.length;i++){
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int temp = stack.pop();
                answer[temp] = i - temp;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()){
            int temp = stack.pop();
            answer[temp] = prices.length - 1 - temp;
        }
        return answer;
    }
}
