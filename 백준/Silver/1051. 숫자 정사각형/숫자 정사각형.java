import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxSize = 1;  // 최소 정사각형 크기 1x1

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int size = 0; size + r < N && size + c < M; size++) {
                    if (board[r][c] == board[r][c + size] &&
                        board[r][c] == board[r + size][c] &&
                        board[r][c] == board[r + size][c + size]) {
                        maxSize = Math.max(maxSize, (size + 1) * (size + 1));  
                    }
                }
            }
        }

        System.out.println(maxSize);
    }
}
