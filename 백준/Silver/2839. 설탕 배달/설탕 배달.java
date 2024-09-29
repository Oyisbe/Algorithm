import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        System.out.println(judge(N));

    }

    public static int judge(int input) {

        // 케이스 1 : 5 단위로만 나누어 떨어지는 경우 ( 가장 큰 단위 -> 결과는 당연히 가장 최소가 됨. )
        if (input % 5 == 0)
            return input / 5;

            // 케이스 2 : 두 단위가 혼합된 형태.
            // 그리디의 목적에 따라, 우선 큰 단위에서 부터 최대한 많이 나눠본다.
            // 큰 단위로 나눴을 때의 나머지가 3으로 나누어 떨어진다는 보장이 없다.

            // 11 의 경우 : ( 11 % 5 ) % 3 은 0 이 아니기에,
            // 큰 단위로 나눴을때의 몫에서 하나씩 줄여나가며 3 으로 나누어 떨어지는 구간을 찾는다.

        else if (input / 5 >= 1) {
            int share = input / 5;

            for (int i = share; i >= 1; i--) {
                int spare = input - (i * 5);
                if (spare % 3 == 0)
                    return i + spare / 3;
            }
        }

        // 케이스 3 : 3 단위로만 나누어떨어지는 경우
        if (input % 3 == 0) {
            return input / 3;
        }

        // 모두 해당하지 않는 케이스
        return -1;
    }
}
