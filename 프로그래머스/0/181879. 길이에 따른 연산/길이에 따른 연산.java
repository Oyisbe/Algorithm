class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int length = num_list.length;;
        
        if(length>=11){
            for(int i=0;i<length;i++)
                answer += num_list[i];
        }else{
            
            answer = 1; // 출력 0 방지 
            
            for(int i=0;i<length;i++)
                answer *= num_list[i];
        }
        
        return answer;
    }
}