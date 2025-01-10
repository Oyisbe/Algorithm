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

        System.out.println(process(N,between,cost));
    }
    public static int process(int numOfCity, int[] between, int[] cost){

        int result = cost[0] * totalDistance;
        // 만약 처음의 도시가 가장 저렴한 기름값일 수도 있는 경우를 대비하여
        // 시작점에서 총 거리만큼 가득 넣는다. 

        int compare = 0;
        // 이후 compare 라는 변수를 통해서,
        // 다음 도시까지의 거리 만큼 넣고, 이동한 도시에서 남은 거리만큼 전부 넣는 경우를 비교한다.

        for(int i=0; i<between.length; i++){
            compare = cost[i] * between[i] + cost[i+1] * totalDistance - between[i];
            // 다음 도시로 갈 수 있는 만큼만 넣고, 도착한 도시에서 남은 전체 거리만큼 기름을 채우며 계속 비교
            if(result>compare)
                result = compare;
        }
        return result;
    }
}
