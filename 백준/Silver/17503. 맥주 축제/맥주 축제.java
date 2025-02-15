import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N; // 축제의 기간 ( N 병 )
    static int M; // 선호도의 합 ( M 이상이 되도록 고려 )
    static int K; // 맥주 종류의 수

    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int alcohol = Integer.parseInt(st.nextToken());
            list.add(new int[]{like, alcohol});
        }

        System.out.println(process(list));
    }

    static int process(List<int[]> list) {
        // 도수 레벨을 기준으로 오름차순 정렬
        list.sort(Comparator.comparingInt(value -> value[1]));

        // 2우선순위 큐 (최소 힙) - 선호도를 낮은 순으로 유지
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sumLike = 0; // 현재 선택된 맥주들의 선호도 합
        int minAlcohol = -1; // 정답으로 저장할 최소 도수 레벨

        // 맥주 리스트 순회
        for (int[] beer : list) {
            int like = beer[0];
            int alcohol = beer[1];

            pq.add(like);
            sumLike += like;

            // N개를 유지하기 위해 가장 작은 선호도 제거
            if (pq.size() > N) {
                sumLike -= pq.poll();
            }

            // N개의 맥주를 선택했고, 선호도 합이 M 이상이면 정답 후보
            if (pq.size() == N && sumLike >= M) {
                minAlcohol = alcohol;
                break; // 첫 번째 가능한 도수 레벨이 최소 도수 레벨이므로 종료
            }
        }

        return minAlcohol;
    }
}
