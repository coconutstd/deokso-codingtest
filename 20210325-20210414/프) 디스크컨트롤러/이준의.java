import java.util.*;

class Job implements Comparable<Job>{
    int start, time;

    public Job(int start, int time){
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(Job o){
        return this.time - o.time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int length = jobs.length;
        int answer = 0;

        Arrays.sort(jobs, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else return a[0] - b[0];
        });

        int index = 1;
        int curTime = jobs[0][0] + jobs[0][1];
        int total = jobs[0][1];

        PriorityQueue<Job> pq = new PriorityQueue<>();
        while(index < length || !pq.isEmpty()){
            if(index < length && jobs[index][0] <= curTime){
                pq.offer(new Job(jobs[index][0], jobs[index][1]));
                index++;
                continue;
            }
            if(!pq.isEmpty()){
                Job next = pq.poll();
                total += curTime - next.start + next.time;
                curTime += next.time;
            } else {
                curTime = jobs[index][0] + jobs[index][1];
                total += jobs[index][1];
                index++;
            }
        }

        return total / length;
    }
}