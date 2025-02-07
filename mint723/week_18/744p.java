class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int same = 0;
        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i]==0){
                zero++;
            }
            for (int j = 0; j < lottos.length; j++) {
                if(lottos[i]==win_nums[j]){
                    same++;
                }
            }
        }
        int[] answer = {ranking(same+zero), ranking(same)};
        return answer;
    }
    
    int ranking(int num){
        if(num == 0)
            return 6;
        return 7 - num;
    }
}
