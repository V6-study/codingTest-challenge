import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.startsWith("push")){
                stack.push(Integer.parseInt(str.split(" ")[1]));
                continue;
            }else if(str.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(stack.pop());
                }
            }else if(str.equals("size")){
                sb.append(stack.size());
            }else if(str.equals("empty")){
                sb.append(stack.isEmpty()?1:0);
            }else{
                if(stack.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(stack.peek());
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
