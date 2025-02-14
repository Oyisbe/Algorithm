import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // N 까지
    static int M; // M 개 고르기

    static int[] arr = new int[8];

    public static void main(String[] args) throws IOException {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         backTracking(0,1);
    }
    static void backTracking(int k, int position){

        if(k==M){
            // M 개를 골랐다면
            for(int i=0;i<M;i++){
                System.out.printf(arr[i]+" ");
            }
            System.out.println();
        }

        for(int i=position;i<=N;i++){
            arr[k] = i;
            backTracking(k+1,i+1);
        }
    }
}
