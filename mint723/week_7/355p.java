// https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // {번호, 라운드}
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if(set.contains(words[i]) || i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                // 이미 나온 단어 혹은 끝말잇기 규칙에 어긋날 때
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                return answer;
            }else{
                set.add(words[i]);
            }
        }
        return answer;
    }
}
