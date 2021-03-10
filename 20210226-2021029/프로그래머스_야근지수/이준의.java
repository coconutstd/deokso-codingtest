import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Integer works2[] = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(works2, Collections.reverseOrder());
        int index = 0;
        int size = works2.length;
        for(int i = 0; i < n; ++i){
            if(index == size) index = 0;
            works2[index++] -= 1;
        }


        for(int i = 0; i < works.length; ++i){
            if(works2[i] <= 0) continue;
            answer += works2[i] * works2[i];
        }
        return answer;
    }
}