function solution(n) {
    var answer = 0;
    var step;
    var total = 0;
    
    for(step=1;step<=n;step++)
        if(step%2==0) // 짝수 : 2로 나누어떨어짐.
            {
                total +=step; 
            }
    answer = total;
    return answer;
}