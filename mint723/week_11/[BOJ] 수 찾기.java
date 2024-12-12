// https://www.acmicpc.net/problem/1920
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            int low = 0;
            int high = arr.length-1;

            boolean flag = false;

            while(low <= high){
                int mid = (low + high) / 2;

                if(arr[mid] > num){
                    high = mid - 1;
                }else if(arr[mid] < num){
                    low = mid + 1;
                }else{
                    flag = true;
                    break;
                }
            }

            if(flag){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);

        br.close();
    }
}
