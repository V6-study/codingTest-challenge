import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        // <장르,Map<고유번호,재생수>>
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new HashMap<>());
                map.get(genres[i]).put(i, plays[i]);
            } else {
                map.get(genres[i]).put(i, plays[i]);
            }
        }

        // <장르, 재생수 함>
        Map<String, Integer> max_g = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            max_g.put(genres[i], max_g.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 재생수 합 기준 내림차순 정렬
        List<String> lst = new ArrayList<>(max_g.keySet());
        Collections.sort(lst, (s1, s2) -> max_g.get(s2).compareTo(max_g.get(s1)));

        for (String g : lst) {
            // map_temp에 장르(g)와 한 쌍인 Map<Integer(고유번호), Integer(재생수)>을 저장
            Map<Integer, Integer> map_temp = map.get(g);
            // 장르가 g인 곡번호가 순서없이 담김
            List<Integer> song_no = new ArrayList<>(map_temp.keySet());
            // 고유번호가 작은 순으로 오름차순 정렬
            Collections.sort(song_no, (s1, s2) -> map_temp.get(s2) - map_temp.get(s1));

            // 장르 별로 가장 많이 재생된 노래를 두 개씩 모음
            if (song_no.size() == 1) {
                answer.add(song_no.get(0));
            } else if (song_no.size() > 1) {
                answer.add(song_no.get(0));
                answer.add(song_no.get(1));
            }

        }

        return answer;
    }
}