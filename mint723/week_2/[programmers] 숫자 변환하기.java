import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x,0});
        visited.add(x);
        while(!q.isEmpty()){
            int[] curX = q.poll();
            
            if(curX[0] == y){
                return curX[1];
            }
            
            if(curX[0]<y){
                if(!visited.contains(curX[0] * 2) && curX[0]*2<=y){
                    q.offer(new int[]{curX[0] * 2, curX[1] + 1});
                    visited.add(curX[0] * 2);
                }
                if (!visited.contains(curX[0] * 3) && curX[0]*3<=y){
                    q.offer(new int[]{curX[0] * 3, curX[1] + 1});
                    visited.add(curX[0] * 3);
                } 
                if (!visited.contains(curX[0] + n) && curX[0]+n<=y){
                    q.offer(new int[]{curX[0] + n, curX[1] + 1});
                    visited.add(curX[0] + n);
                }
            }
            
        }
        return -1;
    }
}
