package sort;

import java.util.*;
import java.io.*;

public class n번째큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j){
                heap.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0; i < n - 1; ++i){
            heap.poll();
        }
        bw.write(heap.poll() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
5
12 7 9 15 5
13 8 11 19 6
21 10 26 31 16
48 14 28 35 25
52 20 32 41 49
 */

