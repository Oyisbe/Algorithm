import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(process(arr));
    }

    static int process(int[] arr){
        int result = 0;
        int time = 0;
        Arrays.sort(arr);
        // 오름 차순으로 정렬하고

        for(int i=0;i<N;i++){
            time += arr[i];
            // time = 기다린 시간 + 사용 시간
            result += time;
            // 모든 사람들의 누적 합
        }

        return result;
    }
}