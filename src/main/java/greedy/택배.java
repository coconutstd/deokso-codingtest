package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class City{
    int from, to, num;
    public City(int from, int to, int num) {
        this.from = from;
        this.to = to;
        this.num = num;
    }
}

public class 택배 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int listNumber = Integer.parseInt(br.readLine());
        City[] cities = new City[listNumber];
        for(int i = 0; i < listNumber; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            cities[i] = new City(from, to, num);
        }
        Arrays.sort(cities, (a, b) -> {
            if(a.to == b.to){
                return a.from - b.from;
            } else {
                return a.to - b.to;
            }
        });


        int[] weight = new int[n + 1];
        for(int i = 1; i < n; ++i){
            weight[i] = capacity;
        }

        int answer = 0;
        for(int i = 0; i < listNumber; ++i){
            City city = cities[i];

            int maxBoxNum = Integer.MAX_VALUE;

            for(int j = city.from; j < city.to; ++j){
                maxBoxNum = Math.min(maxBoxNum, weight[j]);
            }

            if(maxBoxNum >= city.num){
                for(int j = city.from; j < city.to; ++j){
                    weight[j] -= city.num;
                }
                answer += city.num;
            } else {
                for(int j = city.from; j < city.to; ++j){
                    weight[j] -= maxBoxNum;
                }
                answer += maxBoxNum;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20
 */