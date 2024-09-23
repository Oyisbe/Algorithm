import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N; // 입력 데이터의 수
    static boolean flag;

    /*
     * VPS 가 성립하려면 내부 문자열이 어떻게 구성되던지 상관없이, 내부에서 ( ) 로 온전한 괄호가 존재해야됨.
     *
     * 기존의 로직 ( 순수한 구현 -> 해당 로직은 계속해서 순회하면서, 특정 문자열을 삭제해야. 효율적이지 못함 )
     * '(' 가 문자열 내에 존재할 때 해당 index + 1 이 ')' 라면 ( ) 을 계속해서 제거한다.
     * 처리된 최종적인 형태가 빈 문자열 이라면 -> Valid 아니라면 Invalid
     *
     *
     * 1. 열린 괄호와 닫힌 괄호의 수는 동일해야 한다.
     * 2. 하지만 괄호의 개수는 같으나 순서가 ))(( 와 같다거나 하는 예외가 존재.
     * 3. 순회해 나갈때, 특정 규칙을 정의한다. "(" 는 1,  ")" 는 -1 -> 별도의 카운트 변수로의 판별
     * 4. 혹은 Stack 을 통해서도 판별이 가능.
     *
     * 순회하며, 열리는 괄호는 얼마든지 존재해도 되나 닫히는 괄호의 수가 절대 더 많아져서는 안된다.
     * 닫히는 괄호가 더 많아졌다면, 바로 판별.
     * */

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            System.out.println(judge(input));
        }
    }

    public static String judge(String input) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            //순회 하면서 열린 괄호면 추가해주고
            if (input.charAt(i) == '(') {
                stack.add(input.charAt(i));
            } else {
                // 인덱스의 해당 값이 닫힌 괄호일때
                if (stack.isEmpty()) {
                    // 스택이 비어있다면. 즉 닫힌 괄호만 존재하면 VPS 가 바로 될수 없기에.
                    stack.add(input.charAt(i));
                    break;
                } else {
                    // 스택에 값이 존재한다면 ( 열린 괄호가 있다면 ) -> 값을 빼준다.
                    stack.removeLast();
                }
            }
        }

        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }
}