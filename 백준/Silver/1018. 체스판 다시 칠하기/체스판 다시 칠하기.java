import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minChanges = Integer.MAX_VALUE;

        // 8x8 체스판 영역을 슬라이딩하면서 최소 변경 횟수 계산
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int changes1 = countChanges(i, j, 'W');  // 첫 번째 칸이 W인 경우
                int changes2 = countChanges(i, j, 'B');  // 첫 번째 칸이 B인 경우
                minChanges = Math.min(minChanges, Math.min(changes1, changes2));
            }
        }

        // 결과 출력
        System.out.println(minChanges);
    }

    // 8x8 영역에서 시작칸 색에 맞춰 변경 횟수 계산
    static int countChanges(int x, int y, char firstColor) {
        char secondColor = (firstColor == 'W') ? 'B' : 'W';
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColor = ((i + j) % 2 == 0) ? firstColor : secondColor;
                if (board[x + i][y + j] != expectedColor) {
                    count++;
                }
            }
        }

        return count;
    }
}