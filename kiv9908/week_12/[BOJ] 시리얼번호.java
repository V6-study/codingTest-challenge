import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr,(o1,o2)->{
            if(o1.length()!=o2.length()) return o1.length()-o2.length();
            else {
                int sum1 = 0;
                int sum2 = 0;
                for(char c : o1.toCharArray()){
                    if(Character.isDigit(c)){
                        sum1 += Character.getNumericValue(c);
                    }
                }
                for(char c : o2.toCharArray()){
                    if(Character.isDigit(c)){
                        sum2 += Character.getNumericValue(c);
                    }
                }
                if(sum1!=sum2) return sum1-sum2;
                else return o1.compareTo(o2);
            }
        });
        for (String str : arr) {
            System.out.println(str);
        }

    }
}
