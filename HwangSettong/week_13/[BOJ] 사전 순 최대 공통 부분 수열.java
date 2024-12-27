// https://www.acmicpc.net/problem/30805
import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> subseq = new ArrayList<>();

    private static void greedy(List<Integer> A, List<Integer> B) {
        if(A.isEmpty() || B.isEmpty()) return; // A나 B가 비어있으면 return
        int maxA = A.stream().max(Integer::compareTo).get(); // A의 최대값
        int maxB = B.stream().max(Integer::compareTo).get(); // B의 최대값
        int maxIdxA = A.indexOf(maxA); // A의 최대값 인덱스
        int maxIdxB = B.indexOf(maxB); // B의 최대값 인덱스
        if(maxA==-1|| maxB==-1) return; // 모든 값 탐색했으면 return
        // A와 B의 최대값이 같으면 이 값을 suqseq에 추가하고, A와 B를 인덱스 기준으로 자르기
        if(maxA == maxB){
            subseq.add(maxA);
            A = A.subList(maxIdxA+1, A.size());
            B = B.subList(maxIdxB+1, B.size());
        }else if(maxA > maxB){ // A의 최대값이 더 크면 해당 값 -1로 변경하여 무시
            A.set(maxIdxA, -1);
        }else{ // B의 최대값이 더 크면 해당 값 -1로 변경하여 무시
            B.set(maxIdxB, -1);
        }
        greedy(A, B); // 재귀 호출
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) A.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) B.add(Integer.parseInt(st.nextToken()));

        greedy(A, B);

        System.out.println(subseq.size());
        if(!subseq.isEmpty()){
            subseq.stream().forEach(i -> System.out.print(i+" "));
        }
    }
}
