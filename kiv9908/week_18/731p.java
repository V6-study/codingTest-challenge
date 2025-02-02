import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        // 두 큐의 합 계산 및 초기화
        long sumQ1 = 0;
        long sumQ2 = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        for (int q : queue1) {
            sumQ1 += q;
            q1.offer(q);
        }
        for (int q : queue2) {
            sumQ2 += q;
            q2.offer(q);
        }

        // 전체 합 계산
        long sumTotal = sumQ1 + sumQ2;

        // 합이 홀수면 같은 합을 만들 수 없음
        if (sumTotal % 2 != 0) {
            return -1;
        }

        long target = sumTotal / 2;
        int limit = 2 * (queue1.length + queue2.length); // 반복 제한

        while (answer < limit) {
            if (sumQ1 == target) {
                return answer; // 성공적으로 합을 맞춤
            }

            if (sumQ1 > target) {
                // q1에서 q2로 이동
                int temp = q1.poll();
                sumQ1 -= temp;
                sumQ2 += temp;
                q2.offer(temp);
            } else {
                // q2에서 q1로 이동
                int temp = q2.poll();
                sumQ1 += temp;
                sumQ2 -= temp;
                q1.offer(temp);
            }

            answer++;
        }

        return -1; // 제한 횟수를 초과한 경우
    }
}
