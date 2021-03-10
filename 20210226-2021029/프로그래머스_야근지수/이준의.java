import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(works.length, Collections.reverseOrder());
        for(int i = 0; i < works.length; ++i){
            pq.offer(works[i]);
        }
        for(int i = 0; i < n; ++i){
            int m = pq.poll();
            if(m != -1){
                pq.offer(m - 1);
            } else{
                break;
            }
        }
        while(!pq.isEmpty()){
            int m = pq.poll();
            if(m > 0) answer += m * m;
        }
        return answer;
    }
}