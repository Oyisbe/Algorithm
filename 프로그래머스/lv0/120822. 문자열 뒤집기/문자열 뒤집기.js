function solution(my_string) {
    var answer = '';
    var step;
    var arr = Array.from(my_string) // 문자열을 배열로 바꾸고, 배열 메소드 사용
    
    answer = (arr.reverse()).join("");  //reverse() 사용 후, join으로 문자열로 바꾸기
    
    return answer;
}