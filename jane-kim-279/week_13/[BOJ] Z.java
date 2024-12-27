import java.io.*;
import java.util.*;

public class Main {
	static int n, r, c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		
		n = (int) Math.pow(2, n);
		int answer = 0;

		while (true) {
			int half = n/2;
			if (r < half && c >= half) {
				answer += half * half;
				c -= half;
			} else if (r >= half && c < half) {
				answer += half * half * 2;
				r -= half;
			} else if (r >= half && c >= half) {
				answer += half * half * 3;
				r -= half;
				c -= half; 
			}
			if (n == 2) break;
			n /= 2;
		}

		System.out.println(answer);
	}
}
