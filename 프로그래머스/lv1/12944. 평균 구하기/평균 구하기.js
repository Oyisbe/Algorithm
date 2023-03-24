function solution(arr) {
    var answer = 0;
    var total = 0;
    var step;
    var length = arr.length 
    if(1<=length<=100)
        {
            for(step= 0; step<length; step++)
                total +=arr[step]
        }
    answer = total / length ;
    return answer;
}