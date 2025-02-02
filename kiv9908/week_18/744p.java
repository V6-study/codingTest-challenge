import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        Set<Integer> win = new HashSet<>();
        int zero = 0;
        int match=0;
        for(int w : win_nums){
            win.add(w);
        }
        for(int l : lottos){
            if(win.contains(l)){
                match++;
            }else if(l==0){
                zero++;
            }
        }
        
        return new int[]{7 - Math.max((match + zero), 1), 7 - Math.max(match, 1)};
    }
}
