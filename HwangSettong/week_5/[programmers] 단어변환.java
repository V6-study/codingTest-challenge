// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int[] visited = new int[words.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {-1, 0});
        int[] qq;
        int len = begin.length();
        loop1: while(!q.isEmpty()){
            qq = q.poll();
            if(qq[0]>=0) {
                visited[qq[0]] = 1;
                begin = words[qq[0]];
            }
            for(int i = 0; i<words.length; i++){
                if(visited[i] == 1){continue;}
                int cnt = 0;
                for(int j=0; j<len; j++){
                    if(words[i].charAt(j) != begin.charAt(j)){
                        cnt++;
                    }
                    if(cnt>1){
                        break;
                    }
                }
                if(cnt == 1){
                    if(words[i].equals(target)){
                        return qq[1]+1;
                    }
                    q.offer(new int[] {i, qq[1]+1});
                }
            }
        }
        
        return 0;
    }
}
