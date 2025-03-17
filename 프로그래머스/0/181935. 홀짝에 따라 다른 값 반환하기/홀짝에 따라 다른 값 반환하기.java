class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n%2==0){
            // 짝수면, 각 수의 제곱을
            for(int i=0;i<=n;i=i+2)
                answer+=i*i;
            
        }else{
            // 홀수면 그대로 더하고
            for(int i=1;i<=n;i=i+2)
                answer+=i;
        }
        
        return answer;
    }
}