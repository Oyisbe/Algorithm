import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    static int K; // 이미 가지고 있는 수 (1<K<10_000)
    static int N; // 필요한 랜선의 수 (1<K<1_000_000)

    // 항상 K >= N

    static Integer[] got;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        K= Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        got = new Integer[K];

        int maxLen = 0; // 가장 긴 랜선의 길이

        for(int i=0;i<K;i++){
            got[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, got[i]); // 최댓값 계산
        }

        System.out.println(binarySearch(maxLen));
    }

    // 이진 탐색으로 최대 길이를 구하는 메서드
    public static long binarySearch(int maxLen) {
        long left = 1; // 최소 길이
        long right = maxLen; // 최대 길이
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 중간값 계산
            long count = 0;

            // mid 길이로 자를 수 있는 랜선의 개수 계산
            for (int length : got) {
                count += length / mid;
            }

            if (count >= N) {
                // 충분히 랜선을 만들 수 있다면 길이를 늘린다
                answer = mid; // 현재 길이 저장
                left = mid + 1;
            } else {
                // 랜선이 부족하다면 길이를 줄인다
                right = mid - 1;
            }
        }

        return answer;
    }
}
