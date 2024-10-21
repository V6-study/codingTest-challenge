// https://school.programmers.co.kr/learn/courses/30/lessons/42586
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            int days = (int) Math.ceil((100 - progresses[i]) / (speeds[i] * 1.0));
            q.add(days);
        }
        
        while(!q.isEmpty()) {
            int cnt = 1;
            int a = q.remove();
            while(!q.isEmpty() && q.peek() <= a) {
                cnt++;
                q.remove();
            }
            result.add(cnt);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
