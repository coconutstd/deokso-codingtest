class Solution
{
    static boolean check(String subString){
        int iter = subString.length() / 2 - 1;
        int left = 0, right = subString.length() - 1;
        for(int i = 0; i < iter; ++i){
            if(subString.charAt(left++) != subString.charAt(right--)) return false;
        }
        return true;
    }

    public int solution(String s)
    {
        int max = -1;
        for(int i = 0; i < s.length(); ++i){
            for(int j = i; j < s.length() + 1; ++j){
                if(check(s.substring(i, j))){
                    if(max < i + 1) max = i + 1;
                }
            }
        }
        return max;
    }
}