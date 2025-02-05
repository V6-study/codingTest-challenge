import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static int solution(int[] q1, int[] q2) {
		int answer = 0;
		long sum1 = 0; 
		long sum2 = 0;
		Queue<Integer> qq1 = new LinkedList<Integer>();
		Queue<Integer> qq2 = new LinkedList<Integer>();
		for(int i = 0; i < q1.length; i++) { 
			sum1 += q1[i] + q2[i];
			sum2 += q1[i];
			qq1.add(q1[i]);
			qq2.add(q2[i]);
		}
    
		if(sum1 % 2 != 0) return -1;
		long target = sum1 / 2;
		while (true) {
			if(answer > (q1.length + q2.length) * 2) return -1;
			if(sum2 == target) break;
			else if (sum2 > target) {
				sum2 -= qq1.peek();
				qq2.add(qq1.poll());
			}else {
				sum2 += qq2.peek();
				qq1.add(qq2.poll());
			}
			answer++;
		}
		
		return answer;
	}
}
