class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        for(int i=0;i<my_string.length();i++){
            
            // 순회하면서 (char 과 String 비교를 위한 casting)
            if(String.valueOf(my_string.charAt(i)).equals(alp)){
                // 처음에는 - 32 로 Ascii 를 활용하려고 했지만 
                // String을 직접적인 char 로 casting 이 불가능하다. 
                answer += alp.toUpperCase();
            }
            else{
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}