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