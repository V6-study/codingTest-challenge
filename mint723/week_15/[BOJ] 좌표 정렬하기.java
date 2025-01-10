import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        Integer[][] pos = new Integer[num][2];
        
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(pos, (o1, o2) -> {
            if(Objects.equals(o1[0], o2[0])){
                return o1[1] - o2[1]; 
            }
            return o1[0] - o2[0]; 
        });
        
        for(int i=0; i<num; i++){
            System.out.print(pos[i][0]+" "+pos[i][1]);
            System.out.println();
        }
        
        br.close();
    }
}
