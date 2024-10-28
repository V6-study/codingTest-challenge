import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> history = new ArrayList<>();

        for (String r : record) {
            String[] split_record = r.split(" ");
            if (split_record[0].equals("Enter")) {
                map.put(split_record[1], split_record[2]);
            } else if (split_record[0].equals("Change")) {
                map.put(split_record[1], split_record[2]);
            } else {
                continue;
            }
        }

        for (String r : record) {
            String[] split_record = r.split(" ");
            if (split_record[0].equals("Enter")) {
                history.add(map.get(split_record[1]) + "님이 들어왔습니다.");
            } else if (split_record[0].equals("Leave")) {
                history.add(map.get(split_record[1]) + "님이 나갔습니다.");
            } else {
                continue;
            }
        }

        return history.stream().toArray(String[]::new);
    }
}
