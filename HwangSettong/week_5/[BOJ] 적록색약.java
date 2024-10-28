//https://www.acmicpc.net/problem/10026
import java.io.*;
public class Main {
    static void normal(char[][] map, int i, int j, char pre){
        if(i>=0 && j>=0 && i<map.length && j<map[0].length && map[i][j] == pre){
            map[i][j] = '.';
            normal(map, i+1, j, pre);
            normal(map, i, j+1, pre);
            normal(map, i-1, j, pre);
            normal(map, i, j-1, pre);
        }
    }
    static void notNormal(){
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String temp;
        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];
        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            for(int j = 0; j < N; j++) {
                map1[i][j] = temp.charAt(j);
                map2[i][j] = temp.charAt(j)=='B'?'B':'A';
            }
        }
        int[] answer= {0,0}; //[일반, 적록색약]
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map1[i][j] != '.'){
                    normal(map1, i, j, map1[i][j]);
                    answer[0]++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map2[i][j] != '.'){
                    normal(map2, i, j, map2[i][j]);
                    answer[1]++;
                }
            }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
