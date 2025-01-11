import java.io.*;
import java.util.*;

public class Main {
    static int max = 100001;
    static int n, numOfStudents, grade;
    static int[] A = new int[max];
    static int[] B = new int[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int score = 1; score <= 5; score++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (A[i] == score || B[i] == score) count++;
                else count = 0;
                if (numOfStudents < count) {
                    numOfStudents = count;
                    grade = score;   
                }
            }
        }

        System.out.println(numOfStudents + " " + grade);
    }
}
