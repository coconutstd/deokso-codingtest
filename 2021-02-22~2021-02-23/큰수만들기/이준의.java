import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Deque<Character> dq = new LinkedList<>();
        for(int i = 0; i < number.length(); ++i){
            while(k > 0 && !dq.isEmpty() && dq.getLast() < number.charAt(i)){
                dq.removeLast();
                k--;
            }
            dq.addLast(number.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while(dq.size() > k){
            ans.append( dq.removeFirst());
        }
        bw.write(ans.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
