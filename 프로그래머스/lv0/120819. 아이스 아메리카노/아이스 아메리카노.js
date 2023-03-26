function solution(money) {
    var answer = [];
    var amount;
    var change;
    
    amount = parseInt(money / 5500);
    change = parseInt(money % 5500);
    
    if(0<money<=1000000)
        {
            answer[0] = amount;
            answer[1] = change;
        }
    return answer;
}