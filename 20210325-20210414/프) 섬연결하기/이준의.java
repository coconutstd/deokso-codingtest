import java.util.*;

class Node implements Comparable<Node>{
    int from, to, cost;

    public Node(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Node o){
        return this.cost - o.cost;
    }

}

class Solution {

    static int[] p;

    public static int find(int x){
        if(x != p[x]){
            return p[x] = find(p[x]);
        } else return p[x];
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        p = new int[n + 1];
        for(int i = 0; i < n + 1; ++i){
            p[i] = i;
        }

        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i < costs.length; ++i){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph);

        for(Node node : graph){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                answer += node.cost;
            }
        }

        return answer;
    }
}