import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] curPos = {5, 5};
        Set<String> visited = new HashSet<>();
        
        int[] dx = {0,0,1,-1}; // U:0 D:1 R:2 L:3
        int[] dy = {1,-1,0,0};
        
        int answer = 1;
        
        for(int i=0; i<dirs.length(); i++){
            char act = dirs.charAt(i);
            int actIndex = -1;
            if(act=='U'){
                actIndex = 0;
            }else if(act=='D'){
                actIndex = 1;
            }else if(act=='R'){
                actIndex = 2;
            }else if(act=='L'){
                actIndex = 3;
            }
            
            int xPos = curPos[0] + dx[actIndex]; 
            int yPos = curPos[1] + dy[actIndex];
            
            if(xPos>=0 && yPos>=0 && xPos<=10 && yPos<=10){
                visited.add(curPos[0] + "," + curPos[1] + " -> " + xPos + "," + yPos);
                visited.add(xPos + "," + yPos + " -> " + curPos[0] + "," + curPos[1]);
                curPos[0] = xPos;
                curPos[1] = yPos;
            }
        }
        
        return visited.size()/2;
    }
}
