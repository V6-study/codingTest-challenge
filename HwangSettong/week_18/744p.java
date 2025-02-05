//https://school.programmers.co.kr/learn/courses/30/lessons/77484#
import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zero = 0, same=0;
        int idx1=0, idx2=0;
        while(idx1<6 && idx2<6){
            if(lottos[idx1] == win_nums[idx2]){
                idx1++;
                idx2++;
                same++;
            }else if(lottos[idx1] < win_nums[idx2]){
                if(lottos[idx1] == 0) zero++;
                idx1++;
            }else{
                idx2++;
            }
        }
        
        return new int[] {Math.min(6, 7-zero-same), Math.min(6, 7-same)};
    }
}
