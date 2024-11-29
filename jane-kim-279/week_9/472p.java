class Solution {
    static int n, answer;
    static boolean[] visited;
    
    static void dfs(int k, int cnt, int[][] dungeons) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k, 0, dungeons);
        return answer;
    }
}
