import java.util.*;

class Node implements Comparable<Node>{
    int to, cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int[] dijkstra(int start, int n){
        int[] distance = new int[n + 1];
        for(int i = 0; i < n + 1; ++i) distance[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(distance[cur.to] < cur.cost){
                continue;
            }

            for(Node next : graph.get(cur.to)){
                int cost = next.cost + cur.cost;
                if(distance[next.to] > cost){
                    distance[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }

        return distance;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n + 1; ++i){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < fares.length; ++i){
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        int[] distance = dijkstra(s, n);
        int[] distance2 = dijkstra(a, n);
        int[] distance3 = dijkstra(b, n);
        answer = Integer.MAX_VALUE;
        for(int i = 1; i < n + 1; ++i){
            if(distance[i] + distance2[i] + distance3[i] < answer) answer =
                    distance[i] + distance2[i] + distance3[i];
        }

        return answer;
    }
}


/*
정확성  테스트
테스트 1 〉	통과 (0.79ms, 52.2MB)
테스트 2 〉	통과 (0.70ms, 54.3MB)
테스트 3 〉	통과 (0.77ms, 52MB)
테스트 4 〉	통과 (1.04ms, 51.8MB)
테스트 5 〉	통과 (0.90ms, 52.1MB)
테스트 6 〉	통과 (0.82ms, 54.1MB)
테스트 7 〉	통과 (0.87ms, 52.6MB)
테스트 8 〉	통과 (1.06ms, 52.9MB)
테스트 9 〉	통과 (1.67ms, 53.7MB)
테스트 10 〉	통과 (0.94ms, 51.8MB)
효율성  테스트
테스트 1 〉	통과 (3.98ms, 52.4MB)
테스트 2 〉	통과 (24.75ms, 58.1MB)
테스트 3 〉	통과 (4.63ms, 52.5MB)
테스트 4 〉	통과 (3.59ms, 53.3MB)
테스트 5 〉	통과 (3.98ms, 54.9MB)
테스트 6 〉	통과 (4.50ms, 53MB)
테스트 7 〉	통과 (23.60ms, 64.3MB)
테스트 8 〉	통과 (31.26ms, 66.6MB)
테스트 9 〉	통과 (22.72ms, 65.5MB)
테스트 10 〉	통과 (22.07ms, 65.8MB)
테스트 11 〉	통과 (22.63ms, 65.2MB)
테스트 12 〉	통과 (14.92ms, 58.4MB)
테스트 13 〉	통과 (22.92ms, 58.8MB)
테스트 14 〉	통과 (16.37ms, 60.3MB)
테스트 15 〉	통과 (14.54ms, 60.7MB)
테스트 16 〉	통과 (3.61ms, 53.1MB)
테스트 17 〉	통과 (4.19ms, 52.7MB)
테스트 18 〉	통과 (4.13ms, 52.8MB)
테스트 19 〉	통과 (5.89ms, 54.1MB)
테스트 20 〉	통과 (9.81ms, 53.5MB)
테스트 21 〉	통과 (7.87ms, 54.2MB)
테스트 22 〉	통과 (14.47ms, 61.8MB)
테스트 23 〉	통과 (30.42ms, 61.6MB)
테스트 24 〉	통과 (28.51ms, 63.3MB)
테스트 25 〉	통과 (2.35ms, 53.3MB)
테스트 26 〉	통과 (2.81ms, 52.5MB)
테스트 27 〉	통과 (10.32ms, 53.7MB)
테스트 28 〉	통과 (9.20ms, 53.6MB)
테스트 29 〉	통과 (3.11ms, 52.7MB)
테스트 30 〉	통과 (3.19ms, 53.2MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
 */