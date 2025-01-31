import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> expire = new HashMap<>();

        int date = getDate(today);

        for (String term : terms) {
            String[] t = term.split(" ");
            expire.put(t[0], Integer.parseInt(t[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");

            if (getDate(p[0]) + expire.get(p[1]) * 28 <= date) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public int getDate(String today) {
        String[] t = today.split("\\.");
        int year = Integer.parseInt(t[0]);
        int month = Integer.parseInt(t[1]);
        int day = Integer.parseInt(t[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}
