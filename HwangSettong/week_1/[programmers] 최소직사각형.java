// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java
import java.lang.*;
class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        for(int[] size : sizes){
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }
        return w*h;
    }
}
