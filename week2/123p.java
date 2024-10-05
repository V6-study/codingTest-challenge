import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] fail = new int[N+2];
        for(int stage : stages){    // O(n)
            fail[stage]++;
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int[] reach = new int[N+2];
        reach[N+1] = fail[N+1];
        for(int i = N; i> 0; i--){  // O(n)
            reach[i] = reach[i+1] + fail[i];
            answer.add(i);
        }
        
        answer.sort((o1, o2)->{ // O(nlog(n))
            double fail1 = reach[o1] == 0 ? 0 :  ((double)fail[o1])/ reach[o1];
            double fail2 = reach[o2] == 0 ? 0 :  ((double)fail[o2])/ reach[o2];
            return fail1 == fail2 ? o1 - o2 : (fail1 > fail2 ? -1 : 1 );
        });
        return answer.stream().mapToInt(i->i).toArray();
        
    }
}
