//https://school.programmers.co.kr/learn/courses/30/lessons/120861
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] res = {0,0};
        int x = board[0]/2;
        int y = board[1]/2;
        for(String k: keyinput){
            if(k.equals("right") && res[0] < x){
                res[0]++;
            } else if(k.equals("left") && res[0] > -x){
                res[0]--;
            } else if(k.equals("up") && res[1] < y){
                res[1]++;
            }else if(k.equals("down") && res[1] > -y){
                res[1]--;
            }
        }
        return res;
    }
}
