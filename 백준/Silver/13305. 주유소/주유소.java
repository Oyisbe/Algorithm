import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N; // 도시의 수
    static int [] between; // 인접한 두 도시의 거리 (N-1)
    static int [] cost; // 도시마다의 리터 가격
    static int totalDistance;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        between = new int[N-1];
        cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<between.length;i++){
            between[i] = Integer.parseInt(st.nextToken());
            totalDistance += between[i];
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(process(between,cost));
    }

    public static int process(int[] between, int[] cost) {

        int result = 0;
        int currentCost = cost[0]; // 처음에는 첫 도시의 주유소 가격으로 시작
        int currentTotalDistance = 0; // 현재까지 이동한 거리 (누적 값)

        for (int i = 0; i < between.length; i++) {
            // 해당 구간에 대한 거리
            int distance = between[i];

            // 주유소 가격이 더 저렴하면 그 가격으로 주유
            if (cost[i] < currentCost) {
                currentCost = cost[i];
            }

            // 그 주유소에서 현재 구간 거리만큼 기름을 넣는다.
            result += currentCost * distance;
        }

        return result;
    }
}
