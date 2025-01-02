import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            if(str.equals("END")) break;
            sb.append(str).reverse();
            System.out.println(sb);
        }
    }
}
