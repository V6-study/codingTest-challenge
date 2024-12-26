import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] speedLimits, travelSpeed;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		speedLimits = new int[100];
		int current = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			for (int j = 0; j < length; j++) {
				speedLimits[current] = limit; 
				current++;
			}
		}

		travelSpeed = new int[100];
		current = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for (int j = 0; j < length; j++) {
				travelSpeed[current] = speed;
				current++;
			}
		}

		int maxOver = 0;
		for (int i = 0; i < 100; i++) {
			int speedOver = travelSpeed[i] - speedLimits[i];
			maxOver = Math.max(maxOver, speedOver);
		}

		System.out.println(maxOver);
	}
}
