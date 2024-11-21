import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + numbers[i][j];
            }
        }

        for(int tc=0; tc<m; tc++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
        }
    }
}
