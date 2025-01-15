import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(str.charAt(i) == ')'){
                stack.pop();
                if(str.charAt(i-1) == '('){
                    answer += stack.size();
                }else{
                    answer++;
                }
            }else{
                stack.push(c);
            }
        }

        System.out.println(answer);

        br.close();
    }
}
