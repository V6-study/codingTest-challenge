import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(set.contains(s))
                list.add(s);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append('\n');

        for (String name : list) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
