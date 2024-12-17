import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> book = new HashSet<>();
        for(String number : phone_book) {
            book.add(number);
        }
        boolean answer = true;
        for(String number : phone_book) {
            for(int i=1; i<number.length(); i++) {
                if(book.contains(number.substring(0, i))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}
