package kiv9908.week_6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static private int[] dx = { 0, 1, 0, -1 };
	static private int[] dy = { 1, 0, -1, 0 };
	static private boolean[][] visited;
	static private int[][] A;
	static private int n;
	static private int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());


		// 방문 체크
		visited = new boolean[n][m];

		// 입력한 미로 배열에 넣기
		A = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}

		}

		BFS(0, 0);
		System.out.println(A[n - 1][m - 1]);

	}

	private static void BFS(int i, int j) {
		// 큐를 만들고, 방문한 노드를 넣는다, 그리고 방문표시를 한다
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		// 탐색 시작
		// 큐가 비면 탐색 끝
		// 큐에서 하나 꺼내서 시작
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k =0 ;k<4;k++) {
				int x = now[0]+dx[k];
				int y = now[1]+dy[k];
				if (x<n && y<m && x>=0 && y>=0 && A[x][y] != 0 && !visited[x][y]) {
					visited[x][y] = true;
					A[x][y] = A[now[0]][now[1]]+1;
					queue.add(new int[] {x,y});
				}
			}
		}
		
		
	}

}