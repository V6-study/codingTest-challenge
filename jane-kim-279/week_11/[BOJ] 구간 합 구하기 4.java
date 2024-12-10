import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int[] number = new int[Integer.parseInt(st.nextToken())];
        int[] sum = new int[number.length];
        int testcase = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<number.length; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 합 계산
        for(int i=0; i<number.length; i++) {
            if(i==0) sum[i] = number[i];
            else sum[i] = sum[i-1] + number[i];
        }      

        int[] result = new int[testcase];
        for(int tc=0; tc<testcase; tc++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(i==1) result[tc] = sum[j-1];
            else result[tc] = sum[j-1] - sum[i-2];
            System.out.println(result[tc]);
        }
    }
}
