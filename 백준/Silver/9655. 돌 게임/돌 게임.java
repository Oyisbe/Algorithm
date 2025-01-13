import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; //  돌의 수

    // 상근이(선공)와 창영
    // 돌은 1개 또는 3개를 가져갈 수 있다.
    // 마지막 돌을 가져가는 사람이 승자가 됨.
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        System.out.println(process(N));
    }
    public static String process(int N){
        if(N%2==0){
            return "CY";
        }else{
            return "SK";
        }
    }
}
