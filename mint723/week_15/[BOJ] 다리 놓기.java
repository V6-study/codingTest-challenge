// https://www.acmicpc.net/problem/1010
import java.io.*;
import java.util.*;
import java.math.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());

            BigInteger sF = new BigInteger("1");
            BigInteger mF = new BigInteger("1");

            for(int i=secondNum; i>(secondNum-firstNum); i--){
                sF=sF.multiply(new BigInteger(String.valueOf(i)));
            }
            for(int i=firstNum; i>0; i--){
                mF=mF.multiply(new BigInteger(String.valueOf(i)));
            }
            System.out.println(sF.divide(mF));
        }

        br.close();
    }
}
