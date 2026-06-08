import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 - 누적재생수
        HashMap<String, Integer> genrePlayMap = new HashMap<>();
        // 장르 - {노래번호, 재생수}
        HashMap<String, ArrayList<int[]>> songMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayMap.put(genre, genrePlayMap.getOrDefault(genre, 0) + play);
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new int[] {i, play});
        }
        
        // 장르를 누적 재생횟수 내림차순으로 정렬
        List<String> genreList = new ArrayList<>(genrePlayMap.keySet());
        genreList.sort(
            (a,b) -> genrePlayMap.get(b) - genrePlayMap.get(a)
        );
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String genre : genreList) {
            ArrayList<int[]> songs = songMap.get(genre);
            
            songs.sort((a,b) -> {
                // 재생수 같으면 번호 오름차순
                if(a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            
            answer.add(songs.get(0)[0]);
            if(songs.size() > 1) {
                answer.add(songs.get(1)[0]);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}