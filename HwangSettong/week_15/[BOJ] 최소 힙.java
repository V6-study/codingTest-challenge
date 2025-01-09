//https://www.acmicpc.net/problem/1927
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-->0){
            int query = Integer.parseInt(br.readLine());
            if(query == 0 ){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
                pq.add(query);
            }
        }
    }
}
