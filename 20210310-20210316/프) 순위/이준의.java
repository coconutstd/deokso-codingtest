class Solution {
    static int[][] graph;
    static final int INF = (int) 1e9;

    public int solution(int n, int[][] results) {
        int answer = 0;
        graph = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; ++i){
            for(int j = 0; j < n + 1; ++j){
                graph[i][j] = INF;
                if(i == j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < results.length; ++i){
            graph[results[i][0]][results[i][1]] = 1;
        }

        for(int k = 1; k < n + 1; ++k){
            for(int a = 1; a < n + 1; ++a){
                for(int b = 1; b < n + 1; ++b){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int i = 1; i < n + 1; ++i){
            int count = 0;
            for(int j = 1; j < n + 1; ++j){
                if(graph[i][j] != INF || graph[j][i] != INF) count++;
                if(n == count) answer++;
            }
        }

        return answer;
    }
}