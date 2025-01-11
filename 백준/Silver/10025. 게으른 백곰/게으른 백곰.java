import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N; // 양동이의 수
    static int K; // 북극곰이 자리를 잡고, 닿을 수 있는 좌우 반경
    static ArrayList<Integer> ice = new ArrayList<>(); // 해당하는 x 좌표의 얼음 양

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 먼저 N,K  가 주어지고

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            while (ice.size() <= x) {
                // 입력으로 주어지는 X의 좌표 중 가장 큰 x 좌표로 크기 생성
                ice.add(0); 
            }
            ice.set(x,g);
        }

        System.out.println(process(ice, K));
    }
    public static int process(ArrayList<Integer> ice, int sizeOfWindow){
        int maxSum = 0;
        int windowSum = 0;
        int windowSize = 2 * sizeOfWindow + 1; // ice[i-k] 부터 ice[i+k]까지 ( 현 위치 포함 +1 )

        // 초기 윈도우 설정
        for (int i = 0; i < windowSize && i < ice.size(); i++) {
            windowSum += ice.get(i);
        }
        maxSum = windowSum;

        // 슬라이딩 윈도우
        for (int i = 1; i < ice.size(); i++) {
            // 윈도우 왼쪽 값 제외
            if (i - 1 >= 0) {
                windowSum -= ice.get(i - 1);
            }

            // 윈도우 오른쪽 값 추가
            if (i + windowSize - 1 < ice.size()) {
                windowSum += ice.get(i + windowSize - 1);
            }

            // 최대 합 갱신
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
