// https://www.acmicpc.net/problem/1158

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        
        sb.append("<");
        
        while(!q.isEmpty()){
            for(int i=1; i<K; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if(q.size()==0){
                sb.append(">");
            }else{
                sb.append(", ");
            }
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}
