import java.util.*;

class Music implements Comparable<Music>{
    int number;
    int play;
    public Music(int number, int play) {
        this.number = number;
        this.play = play;
    }

    @Override
    public int compareTo(Music o) {
        if(this.play == o.play){
            return this.number - o.number;
        } else {
            return o.play - this.play;
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genresTotal = new HashMap<>();
        Map<String, ArrayList<Music>> genresMusic = new HashMap<>();
        for(int i = 0; i < genres.length; ++i){
            genresTotal.put(genres[i], genresTotal.getOrDefault(genres[i], 0) + plays[i]);
            genresMusic.put(genres[i], genresMusic.getOrDefault(genres[i], new ArrayList<>()));
        }

        for(int i = 0; i < plays.length; ++i){
            genresMusic.get(genres[i]).add(new Music(i, plays[i]));
        }

        for(Map.Entry<String, ArrayList<Music>> elem : genresMusic.entrySet()){
            Collections.sort(elem.getValue());
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(genresTotal.entrySet());

        Collections.sort(entries, (genre1, genre2) -> {
            return genre2.getValue() - genre1.getValue();
        });

        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> elem : entries){
            int count = 0;
            for(Music music : genresMusic.get(elem.getKey())){
                if(count == 2) break;
                answer.add(music.number);
                count++;
            }
        }

        int[] ret = new int[answer.size()];
        for(int i = 0; i < ret.length; ++i) ret[i] = answer.get(i);
        return ret;
    }
}