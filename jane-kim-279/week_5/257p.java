import java.util.*;

class Solution {
    class Song {
        int id;
        int plays;
        
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playByGenre = new HashMap<>(); // 장르별 총 재생횟수
        HashMap<String, ArrayList<Song>> playlist = new HashMap<>(); // 장르별 노래 목록
        int num = genres.length; // 전체 노래 개수

        for (int i=0; i < num; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 재생횟수 누적합 저장
            playByGenre.put(genre, playByGenre.getOrDefault(genre, 0) + play);
            
            // 장르별 노래 정보 저장
            if (!playlist.containsKey(genre)) {
                playlist.put(genre, new ArrayList<>());
            }
            playlist.get(genre).add(new Song(i, play));
        }

        // 장르를 총 재생횟수를 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(playByGenre.keySet());
        sortedGenres.sort((g1, g2) -> playByGenre.get(g2).compareTo(playByGenre.get(g1)));

        ArrayList<Integer> answer = new ArrayList<>();

        // 장르 내 노래를 재생횟수(내림차순), 고유번호(오름차순) 기준으로 정렬
        for (String genre : sortedGenres) {
            ArrayList<Song> songs = playlist.get(genre);

            songs.sort((s1, s2) -> {
                if (s1.plays != s2.plays) {
                    return s2.plays - s1.plays; // 내림차순
                }
                return s1.id - s2.id; // 오름차순
            });

            for (int i=0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).id);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
