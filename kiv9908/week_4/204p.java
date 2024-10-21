// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

        // 최소 개발 일수 계산해서 q에 넣기
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        // 개발일수 비교해서 앞단에 위치한 개발 일수보다 작은 값들 모두 배포
        while (!q.isEmpty()) {
            int days = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && q.peek() <= days) {
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
