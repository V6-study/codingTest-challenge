// https://www.acmicpc.net/problem/11286
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                return o1-o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for(int i=0; i<N; i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll());
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            }else{
                pq.offer(cmd);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
