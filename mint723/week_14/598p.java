// https://school.programmers.co.kr/learn/courses/30/lessons/120861
import java.util.*;

class Solution {
    int N, M;
    public int[] solution(String[] keyinput, int[] board) {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        N = board[0];
        M = board[1];

        Map<String, Integer> map = new HashMap<>();
        map.put("up", 0); map.put("down", 1); map.put("left", 2); map.put("right", 3);

        int[] curpos = {0,0};

        for(String input : keyinput){
            int cmd = map.get(input);
            int nx = curpos[0] + dx[cmd];
            int ny = curpos[1] + dy[cmd];
            if(!isValid(nx, ny)){
                continue;
            }
            curpos = new int[]{nx, ny};
        }

        return curpos;
    }

    boolean isValid(int x, int y){
        return Math.abs(x) <= N/2 && Math.abs(y) <= M/2;
    }
}
