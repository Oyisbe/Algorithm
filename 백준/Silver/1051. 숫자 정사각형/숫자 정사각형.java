import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        System.out.println(process(arr));
    }
    static int process(char[][] arr) {

        int width = 1;
        // 2 x 2 부터 탐색을 시작하는데 네 꼭짓점점이 같은 경우가 없으면 ( 최대 크기는 1  )

        boolean forFlag = false;
        boolean whileFlag = true;
        int scope = 2;
        int arraySelect = 1;

        while(whileFlag){
            for(int i=0;i<=N-scope;i++){
                for(int j=0;j<=M-scope;j++){

                    // 이중 루프를 통한 꼭짓점 판단의 기준점은 leftTop ( 좌측 상단 ) 이 된다.
                    char leftTop = arr[i][j];
                    char rightTop = arr[i][j+arraySelect];
                    char leftBottom = arr[i+arraySelect][j];
                    char rightBottom = arr[i+arraySelect][j+arraySelect];

                    if(leftTop==rightTop && leftTop == leftBottom &&  leftTop == rightBottom){
                        width = scope * scope; // 사각형의 넓이는 가로 x 세로
                        forFlag = true;
                        break;
                        // 특정한 범위에서 네 꼭짓점이 같은걸 발견하였다면 바로 break 걸고 크기 갱신
                        // 이후에 범위 확장해서 재탐색
                    }
                }
                if(forFlag) break;
            }
            forFlag = false;
            scope++; // 2 x 2 에서 시작해서 정사각형 변의 크기를 늘려나간다.
            arraySelect++; // 좌 상단 꼭짓점에서 범위 변경에 따른 index 컨트롤을 위한 변수

            // 이후 탐색할 scope 가 주어진 배열 범위를 벗어나면 flag 를 통해서 빠져나가고 종료
            if(scope > N || scope > M){
                whileFlag = false;
            }
        }
        return width;
    }
}