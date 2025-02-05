import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static char[][] board;

    public static void main(String[] args) throws IOException {

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = input.charAt(j); // 입력 배열을 만들어주고
            }
        }

        // 8 * 8 배열을 탐색하므로, 좌측 상단에서 부터 탐색을 이어갈 때 최소한으로 8칸이 남아있어야한다.
        // 탐색이 가능한 범위(시작점)를 설정해주고 인수로 넘겨서 최소값 비교
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                minValue = Math.min(minValue, process(board,i,j));
                // 범위마다 탐색하며 최소값을 갱신해주고
            }
        }
        System.out.println(minValue);
    }

    static int process(char[][] board, int r, int c){
        int countW = 0; // w 로 시작하는 케이스와의 비교
        int countB = 0; // b 로 시작하는

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                // 선택한 범위 내에서
                // 체스판에서의 각 칸의 글자를 발견한 규칙성으로 비교
                char current = board[i+r][j+c];

                //W로 시작하는 체스판을 기준으로 한다.
                if((i+j)%2==0){
                    // 짝수칸의 경우 ( (i + j) % 2 == 0 )
                    if(current!='W') countW++; // W로 시작하는 체스판에는 짝수칸에 W가 오고
                    if(current!='B') countB++; // B로 시작하는 경우에는 B가 와야한다.
                }
                else
                {
                    // 홀수칸의 경우
                    if(current!='B') countW++; // W로 시작 체스판에서는 B가 와야하고
                    if(current!='W') countB++; // B로 시작하는 체스판에서는 w 가 와야한다.
                }
            }
        }
        // 8 x 8 범위를 탐색한 이후 최소값을 리턴해주자
        return Math.min(countW,countB);
    }
}
