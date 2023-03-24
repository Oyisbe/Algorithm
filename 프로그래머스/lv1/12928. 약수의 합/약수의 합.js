function solution(n) {
    var answer = 0;
    var step;
    if(0<=n<=3000)
        {
            for(step=0; step<=n; step++)
                if(n%step==0)
                    answer+=step;
        }
    return answer;
}