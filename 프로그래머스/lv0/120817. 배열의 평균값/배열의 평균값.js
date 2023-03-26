function solution(numbers) {
    var answer = 0;
    var total = 0;
    var step;
    var length = numbers.length;
    
    for(step=0;step<length;step++)
        total += numbers[step];
    
    answer = total / length;
    return answer;
}