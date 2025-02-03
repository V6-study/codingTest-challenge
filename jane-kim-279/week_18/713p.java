import java.util.Stack;

class Solution {
    // 110 전부부 발견, 제거
    // 0 뒤에 110 추가 (개수만큼)

    public static Stack<Character> stack = new Stack<>();
    public static int count;
    public static String[] answer;

    public String[] solution(String[] s) {
        answer = new String[s.length];

        for (int i = 0; i < s.length; i++) { // tc
            stack.clear();;
            count = 0;
            String curr = s[i];
            
            // 1. 110 발견, 제거
            for (int j = 0; j < curr.length(); j++) {
                if (curr.charAt(j) == '1') { // 1인 경우
                    stack.push('1');
                } else {  // 0인 경우
                    if (stack.size() >= 2) {
                        char first = stack.pop();
                        char sec = stack.pop();
                        if ((first == '1') && (sec == '1')) { // 110 발견
                            count++;
                        } else {  // 110 아님
                            stack.push(sec);
                            stack.push(first);
                            stack.push('0');
                        }
                    } else {
                        stack.push('0');
                    }
                }
            }
            
            // 2. 110 추가
            for (int j = 0; j < count; j++) {
                Stack<Character> tmp = new Stack<>();
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push('1');
                        stack.push('1');
                        stack.push('0');
                        while (!tmp.isEmpty()) {
                            stack.push(tmp.pop());
                        }
                        break;
                    } else {
                        char now = stack.pop();
                        if (now == '0') {
                            stack.push(now);
                            stack.push('1');
                            stack.push('1');
                            stack.push('0');
                            while (!tmp.isEmpty()) {
                                stack.push(tmp.pop());
                            }
                            break;
                        } else {
                            tmp.push(now);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String result = sb.reverse().toString();
            answer[i] = result;
        }

        return answer; 
    }
}
