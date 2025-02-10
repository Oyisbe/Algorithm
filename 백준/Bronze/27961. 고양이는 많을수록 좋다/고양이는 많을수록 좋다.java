import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long N;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        System.out.println(process(N));
    }

    static int process(long N) {
        long cats = 1;
        int count = 1;

        if (N == 0) {
            return 0; 
        }

        if (N == 1) {
            return 1; // 고양이 1마리면 바로 1번 연산으로 도달
        }

        while (cats < N) {
            // break : cats == N;

            long spare = N - cats;

            // 전체를 복사하거나
            if (cats * 2 <= N) {
                cats += cats;
            }

            // 일부 복사
            else {
                cats += spare;
            }

            count++;  // 연산 횟수 증가
        }

        return count;
    }

}
