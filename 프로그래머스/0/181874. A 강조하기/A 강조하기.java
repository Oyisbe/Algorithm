class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for(int i=0; i<myString.length(); i++){
            
            char cur = myString.charAt(i);
            
            if(cur=='a'){
                answer += "A";
            }else if(cur!='A' && Character.isUpperCase(cur)){
                // Reference 타입과 Primitive 타입의 차이를 이해할 것 
                // ( 스트링 메소드 사용 관련 ) 
                answer += Character.toLowerCase(cur);
            }else{
                answer += cur;
            }
                
        }
        return answer;
    }
}