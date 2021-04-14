import java.util.*;
import java.io.*;

class Node2 implements Comparable<Node2>{
    int from, to, cost;
    public Node2(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.cost - o.cost;
    }
}

public class Main {

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        p = new int[V + 1];
        for(int i = 0; i < V + 1; ++i) p[i] = i;

        ArrayList<Node2> graph = new ArrayList<>();
        for(int i = 0; i < E; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node2(a, b, c));
        }
        Collections.sort(graph);

        int answer = 0;
        for(Node2 node : graph){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                answer += node.cost;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
3 3
1 2 1
2 3 2
1 3 3
 */
