import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class score{
        String name;
        int kor,eng,math;
        public score(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        score[] arr = new score[n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new score(name, kor, eng, math);
        }
        Arrays.sort(arr,(o1,o2)->{
            if(o1.kor == o2.kor){
                if(o1.eng == o2.eng){
                    if(o1.math == o2.math){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.eng-o2.eng;
            }
            return o2.kor-o1.kor;
        });

        for(score s : arr){
            System.out.println(s.name);
        }
    }
}

