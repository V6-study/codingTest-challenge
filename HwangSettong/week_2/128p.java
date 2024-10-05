// 방문 길이 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int x = 0;
        int y = 0;
        for(int i = 0; i<dirs.length(); i++){
            if('U'==dirs.charAt(i) && y < 5){
                map.put(x+" "+y+" -> "+ x+" "+(++y), 1);
            }else if('D'==dirs.charAt(i) && y > -5){
                map.put(x+" "+(y-1)+" -> "+ x+" "+(y--), 1);
            }else if('R'==dirs.charAt(i) && x < 5){
                map.put(x+" "+y+" -> "+ (++x)+" "+y, 1);
            }else if('L'==dirs.charAt(i) && x > -5){
                map.put((x-1)+" "+y+" -> "+ (x--)+" "+y, 1);
            }
        }
        return map.size();
    }
}
