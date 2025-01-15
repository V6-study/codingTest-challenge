import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int a = amount / 100;
        for(int i = 0; i < a; i++) {
            list.add(100);
        }
        amount = amount % 100;
        int b = amount / 50;
        for(int i = 0; i < b; i++) {
            list.add(50);
        }
        amount = amount % 50;
        int c = amount / 10;
        for(int i = 0; i < c; i++) {
            list.add(10);
        }
        amount = amount % 10;
        int d = amount / 1;
        for(int i = 0; i < d; i++) {
            list.add(1);
        }

        System.out.println(list);

    }
}
