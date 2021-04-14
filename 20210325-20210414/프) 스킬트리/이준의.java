import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        HashSet<String> skill_set = new HashSet<>();
        boolean[] alpha = new boolean[26];
        for(int i = 0; i < skill.length(); ++i){
            alpha[skill.charAt(i) - 'A'] = true;
            skill_set.add(skill.substring(0, i + 1));
        }

        for(int i = 0; i < skill_trees.length; ++i){
            String skill_tree = skill_trees[i];
            String temp = "";
            for(int j = 0; j < skill_tree.length(); ++j){
                if(alpha[skill_tree.charAt(j) - 'A']) temp += skill_tree.charAt(j);
            }
            if(temp.length() != 0 && !skill_set.contains(temp)) {
                answer--;
            }
        }

        return answer;
    }
}
