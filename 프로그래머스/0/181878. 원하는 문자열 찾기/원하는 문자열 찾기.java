class Solution {
    public int solution(String myString, String pat) {
        
        String standard = myString.toLowerCase();
        String compare = pat.toLowerCase();
        
        if(standard.contains(compare))
            return 1;
        else
            return 0;
    }
}