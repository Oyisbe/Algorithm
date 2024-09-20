import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] nums;

    static int result = 0;
    static int count;
    
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<nums.length;i++){
            // 소수 : 1 과 자신만을 약수로 가지는 수.

            if (nums[i] == 1 || nums[i] ==0)
                continue;

            for(int j=1;j<=nums[i];j++) {
                if (nums[i] % j == 0) {
                    count++; // 나누어 떨어지면 카운트
                }
            }

            if(count==2){
                result+=1;
            }
            count = 0;
        }
        System.out.println(result);
    }
}