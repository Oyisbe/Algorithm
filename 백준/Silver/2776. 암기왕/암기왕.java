import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int tests;
    static int[] note1;
    static int[] note2;

    static int N; // note 1의 숫자 수
    static int M; // note 2의 숫자 수

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        tests = Integer.parseInt(br.readLine()); // 테스트 케이스가 주어지고

        for(int i=0;i<tests;i++){
            N = Integer.parseInt(br.readLine());
            note1 = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                note1[j] = Integer.parseInt(st.nextToken());
            }
            // N 입력받고, 배열에 수 할당

            M = Integer.parseInt(br.readLine());
            note2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                note2[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            for (int target : note2) {
                sb.append(binarySearch(note1, target)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] note1, int target){

        int low = 0;
        int high = note1.length -1;

        while(low <= high){
            int mid = low + (high - low) / 2 ;

            if(note1[mid]==target){
                return 1;
            }
            else if(target>note1[mid]){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
}
