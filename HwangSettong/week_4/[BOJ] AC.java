//https://www.acmicpc.net/problem/5430
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        testcase:for(int t=0;t<T;t++) {
            String query = br.readLine();
            br.readLine();
            String arr = br.readLine();
            Deque<Integer> q = new ArrayDeque<Integer>(){{
                Arrays.stream(arr.split("[\\[\\],]")).forEach(i -> {if(!"".equals(i)) offer(Integer.parseInt(i));});
            }};
            boolean toggle = true; // ture:정상 false:뒤집음
            for(int i=0;i<query.length();i++) {
                if(query.charAt(i)=='R') {
                    toggle = !toggle;
                }else if (q.isEmpty()){
                    bw.write("error\n");
                    continue testcase;
                }
                else{
                    if(toggle){
                        q.pollFirst();
                    }else{
                        q.pollLast();
                    }
                }
            }
            bw.write("[");
            while(!q.isEmpty()){
                if(toggle){
                    bw.write(String.valueOf(q.pollFirst()));
                }else{
                    bw.write(String.valueOf(q.pollLast()));
                }
                if(!q.isEmpty()){
                    bw.write(",");
                }
            }
            bw.write("]\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
