import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(Integer.toString(num));
        }
        list.sort((n1, n2) -> {
            int a = Integer.parseInt(n1 + n2);
            int b = Integer.parseInt(n2 + n1);
            return Integer.compare(b, a);
        });
        StringBuilder answer = new StringBuilder();
        for (String str : list) {
            answer.append(str);
        }
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}
