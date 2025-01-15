import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 점의 수
    static int M; // 선분의 수

    static int[] dots;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 우선 점의 수와 선분의 수를 입력받고

        dots = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            dots[i] = Integer.parseInt(st.nextToken()); // 점들의 수를 입력받는다.
        }

        Arrays.sort(dots);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken()); // 각 선분의 시작점과 끝점을 입력받고

            // 범위 내 점의 개수를 이진 탐색으로 계산
            int lowerIndex = lowerBound(dots, low);
            int upperIndex = upperBound(dots, high);
            int result = upperIndex - lowerIndex;

            stringBuilder.append(result).append("\n");
        }
        System.out.print(stringBuilder);
    }
    // lowerBound: low 이상인 첫 번째 값의 인덱스를 반환
    public static int lowerBound(int[] array, int target) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // upperBound: high 초과인 첫 번째 값의 인덱스를 반환
    public static int upperBound(int[] array, int target) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
