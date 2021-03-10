package twopointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0, right = 1;
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        while(left < N && right < N){
            if(arr[right] - arr[left] < M){
                right++;
            } else {
                if(answer > arr[right] - arr[left]){
                    answer = arr[right] - arr[left];
                }
                left++;
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
1
5
3
*/

/*
5 3
1
2
3
4
5
 */
