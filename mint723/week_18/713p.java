https://school.programmers.co.kr/learn/courses/30/lessons/77886

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int n = s.length;
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder(str);
            int idx = 3;

            Stack<String> removed110 = new Stack<>();

            while (idx <= sb.length()) {
                if (sb.substring(idx - 3, idx).equals("110")) {
                    sb.delete(idx - 3, idx);
                    removed110.push("110");
                    idx = Math.max(3, idx - 3);
                } else {
                    idx++;
                }
            }

            int zeroIdx = sb.lastIndexOf("0");

            while (!removed110.isEmpty()) {
                if (zeroIdx == -1) {
                    sb.insert(0, removed110.pop());
                } else {
                    sb.insert(zeroIdx + 1, removed110.pop());
                    zeroIdx += 3;
                }
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
}
