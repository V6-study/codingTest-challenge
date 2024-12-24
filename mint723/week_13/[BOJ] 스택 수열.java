// https://www.acmicpc.net/problem/1874
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            arr[i] = (Integer.parseInt(br.readLine()));
        }

        int idx = 0;
        int num = 1;
        int count = 0;

        while (count <= n * 4 && idx<n){
            if(stack.isEmpty()){
                stack.add(num);
                num++;
                sb.append("+").append('\n');
            }else{
                if(arr[idx] != stack.peek()){
                    stack.add(num);
                    num++;
                    sb.append("+").append('\n');
                }else{
                    stack.pop();
                    idx++;
                    sb.append("-").append('\n');
                }
            }
            count++;
        }
        System.out.println(stack.isEmpty()?sb:"NO");

        br.close();
    }
}
