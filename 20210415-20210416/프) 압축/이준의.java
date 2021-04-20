import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> dict = new HashMap<>();
        for(int i = 0; i < 26; ++i) {
            String init = "";
            init += (char) ('A' + i);
            dict.put(init, i + 1);
        }

        for(int i = 0; i < msg.length(); ++i){
            int startIndex = i;
            int nextIndex = i + 1;
            String w = msg.substring(startIndex, nextIndex);

            while(true){
                if(nextIndex + 1 <= msg.length() && dict.containsKey(msg.substring(startIndex, nextIndex + 1))){
                    nextIndex++;
                    w = msg.substring(startIndex, nextIndex);
                } else {
                    break;
                }
            }

            answer.add(dict.get(w));

            char c;
            if(nextIndex < msg.length()){
                c = msg.charAt(nextIndex);
                dict.put(w + c, dict.size() + 1);
                i = nextIndex - 1;
            } else{
                break;
            }
        }

        int[] ret = new int[answer.size()];
        for(int i = 0; i < ret.length; ++i) ret[i] = answer.get(i);
        return ret;
    }
}