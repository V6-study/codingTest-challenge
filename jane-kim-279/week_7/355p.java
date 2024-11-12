import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        HashSet<String> used = new HashSet<>();
        char lastWord = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (used.contains(words[i]) || words[i].charAt(0) != lastWord) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            used.add(words[i]);
            lastWord = words[i].charAt(words[i].length() - 1);
        }
        return new int[] {0, 0};
    }
}
