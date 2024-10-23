import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean answer = false;
        
        int[] arr = {1,2,3,4,8};
        int target = 6;
//        int[] arr = {2,3,5,9};
//        int target = 10;

        Set<Integer> set = new HashSet<>();
        
        for (int i : arr) {
            if(set.contains(target-i)){
                answer = true;
            }else{
                set.add(i);
            }
        }
        System.out.println(answer);
    }
}

