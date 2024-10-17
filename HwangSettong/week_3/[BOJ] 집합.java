// https://www.acmicpc.net/problem/11723

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int[] all = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < M; i++){
            String[] query = br.readLine().split(" ");
            if("add".equals(query[0])){
                s.add(Integer.parseInt(query[1]));
            } else if ("remove".equals(query[0])){
                s.remove(Integer.parseInt(query[1]));
            } else if("empty".equals(query[0])){
                s.clear();
            } else if("all".equals(query[0])){
                s = new HashSet<Integer>(){{Arrays.stream(all).forEach(x->add(x));}};
            } else if(s.contains(Integer.parseInt(query[1]))){
                if("toggle".equals(query[0])){
                    s.remove(Integer.parseInt(query[1]));
                }else if("check".equals(query[0])){
                    bw.write("1\n");
                }
            } else {
                if("toggle".equals(query[0])){
                    s.add(Integer.parseInt(query[1]));
                }else if("check".equals(query[0])){
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
