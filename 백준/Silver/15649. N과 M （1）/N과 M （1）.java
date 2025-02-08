import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M;
    static boolean[] isUsed;  // 사용 여부 확인 
    static int[] arr;         // 사용하는 숫자 배열 

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isUsed = new boolean[N + 1];  // 1부터 N까지 사용하기 위해 크기 N+1
        arr = new int[M];              // 길이가 M인 수열 저장

        backTracking(0);
    }

    static void backTracking(int depth) {
        
        if (depth == M) {  // M개를 다 골랐을 때 출력
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) { // 아직 선택되지 않은 숫자라면 선택
                isUsed[i] = true;  // 사용했다면 true 로 판단
                arr[depth] = i;     // 선택한 숫자 저장
                backTracking(depth + 1); // 다음 숫자 선택 (재귀 호출)
                isUsed[i] = false; // 백트래킹 - (역으로 돌아가기)
            }
        }
    }
   
}