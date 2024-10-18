//https://www.acmicpc.net/problem/1158

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb= new StringBuilder("<");
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=nk[0];i++){
            queue.add(i);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            cnt++;
            if(cnt==nk[1]) {
                sb.append(queue.poll()+", ");
                cnt = 0;
            }else{
                queue.offer(queue.poll());
            }
        }
        sb.setLength(sb.length()-2);
        System.out.println(sb+">");

    }
}
