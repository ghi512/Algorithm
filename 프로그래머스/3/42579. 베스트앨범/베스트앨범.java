import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();
        
        // 1. 장르별 총 횟수와 각 곡의 재생 횟수 저장
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            // genreMap에 현재 장르가 없는 경우 초기화
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            
            genreMap.get(genre).add(new int[]{i,play});
            playMap.put(genre, playMap.get(genre)+play);
        }
        
        // 2. 총 재생횟수가 많은 순으로 장르 내림차 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre =
            playMap.entrySet().stream()
            .sorted((o1,o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        // 3. 각 장르 내에서 노래 횟수를 재생횟수 순으로 정렬하여 최대 2곡 선택
        ArrayList<Integer> answer = new ArrayList<>();
        sortedGenre.forEach (entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1,o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}