// https://www.acmicpc.net/problem/2448

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())/3;
        StringBuilder base = new StringBuilder("  *  \n * * \n*****\n");
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        int i = 1;
        while(i<n){
            String[] temp = base.toString().split("\\n");
            b1.delete(0, b1.length()); // b1 초기화
            b2.delete(0, b2.length()); // b2 초기화
            for(String s : temp){
                b1.append("   ".repeat(i) + s+"   ".repeat(i)+"\n"); // 삼각형에 공백 추가
                b2.append(s+ " " +s+"\n"); // 삼각형 두개 나란히 붙이기
            }
            base.delete(0, base.length()); // base 초기화
            base.append(b1); // base에 b1 합쳐주기
            base.append(b2); // base에 b2 합쳐주기
            i*=2;
        }
        System.out.println(base);

    }
}
