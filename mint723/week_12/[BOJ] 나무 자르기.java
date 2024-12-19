// https://www.acmicpc.net/problem/2805
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int min = 0;
        int max = Arrays.stream(arr).max().getAsInt();

        while(min<max){
            int mid = (min + max) / 2;

            long sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i]>=mid){
                    sum+=(arr[i]-mid);
                }
            }

            if(sum<M){
                max = mid;
            }else{
                min = mid+1;
                answer = mid;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
