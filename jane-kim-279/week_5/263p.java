import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> reported = new HashMap<>(); // 유저별 신고 당한 횟수
        HashMap<String, HashSet<String>> reportByUser = new HashMap<>(); // 유저별 신고한 id 저장
        
        for (String id : id_list) {
            reportByUser.put(id, new HashSet<>());
        }
        
        for (String r : report) {
            String[] split_report = r.split(" ");
            if (!reportByUser.get(split_report[0]).contains(split_report[1])) {
                reportByUser.get(split_report[0]).add(split_report[1]);
                reported.put(split_report[1], reported.getOrDefault(split_report[1], 0) + 1);
            }
        }

        for (String id : id_list) {
            int count = 0;
            for (String p : reportByUser.get(id)) {
                if (reported.get(p) != null && reported.get(p) >= k) {
                    count++;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
