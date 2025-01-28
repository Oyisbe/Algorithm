import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);

        for(int i=0;i<M;i++){
            int input = Integer.parseInt(st.nextToken());
            sb.append(process(arr, input)).append('\n');
        }
        System.out.println(sb);
    }

    public static int process(int[] arr, int M){
        
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==M){
                return 1;
            }
            else if(arr[mid]<M){
                low = mid+1;
            }
            else if(arr[mid]>M){
                high = mid-1;
            }
        }
        return 0;
    }
}
