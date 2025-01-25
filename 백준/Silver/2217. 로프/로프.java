import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] ropes;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        ropes = new int[N];

        for(int i = 0; i<=N-1;i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(process(ropes));
    }

    public static int process(int[] ropes){
        int max = 0;
        Arrays.sort(ropes); // 오름 차순 정렬 -> 가장 작은 무게부터

        for(int i=0;i<N;i++){
            int current = ropes[i]*(N-i);
            max = Math.max(max,current);
        }
        return max;
    }
}