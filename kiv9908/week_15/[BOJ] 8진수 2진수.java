import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octalInput = br.readLine(); // 8진수 입력받기

        // BigInteger를 사용하여 8진수 저장
        BigInteger decimal = new BigInteger(octalInput, 8);

        // BigInteger를 사용하여 2진수 문자열로 변환
        String binary = decimal.toString(2);

        System.out.println(binary);
    }
}

