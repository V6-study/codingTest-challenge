// https://www.acmicpc.net/workbook/view/4349

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> under = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> over = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(under.size() == over.size()){
                under.add(num);
            }else{
                over.add(num);
            }
            
            if(!under.isEmpty() && !over.isEmpty() && under.peek() > over.peek()){
                int tmp = under.poll();
                under.add(over.poll());
                over.add(tmp);
            }
            System.out.println(under.peek());
        }
        br.close();
    }
}
