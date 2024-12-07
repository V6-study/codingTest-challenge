import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        // Arrays.sort(strings, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         if(o1.charAt(n) == o2.charAt(n)) {
        //             return o1.compareTo(o2);
        //         }
        //         return o1.charAt(n) - o2.charAt(n);
        //     }
        // });

        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
        
        return strings;
    }
}