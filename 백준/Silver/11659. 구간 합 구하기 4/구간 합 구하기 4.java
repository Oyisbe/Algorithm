import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int trial;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] before;
    static int[] after;

    static int startIdx;
    static int endIdx;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        trial = Integer.parseInt(st.nextToken());
        before = new int[N]; // 원본 배열
        after = new int[N]; // 합 배열

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            before[i] = Integer.parseInt(st.nextToken());
        }

        after[0] = before[0]; // 우선 합 배열의 처음 값은 그대로 넣어주고

        for(int i=1;i<N;i++){
            after[i] = after[i-1]+before[i]; // 합 배열의 전 idx 에서 원래 원본 배열의 값을 더한다.
        }

        for(int i=0;i<trial;i++){
            st = new StringTokenizer(br.readLine());
            startIdx = Integer.parseInt(st.nextToken());
            endIdx = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum(startIdx, endIdx));
        }
    }
    static int prefixSum(int startIdx, int endIdx){
        if (startIdx == 1) {
            // 구간이 주어질 때 ( i 와 j ) : idx 는 1 부터 세기로 되어있다. 
            // 즉 1 부터 endIdx 까지 구갑합을 구한다 라고 한다면
            return after[endIdx - 1];
        }
        return after[endIdx-1]-after[startIdx-2];
    }
}