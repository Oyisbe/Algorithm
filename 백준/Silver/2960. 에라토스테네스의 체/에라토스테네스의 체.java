import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] arr;
    static int arrSize;
    static int target;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        arrSize = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new boolean[arrSize+1];

        int count = 0;

        for(int i=2; i<arrSize+1; i++){
            // 2 부터 주어진 범위까지 전부 볼건데

            // 해당하는 idx 의 값이 false 라면
            if(!arr[i]){
                // 조건문을 통해 해당 idx 의 배수를 전부 true 로 처리
                for(int j=i; j<arrSize+1; j+=i){

                    if(!arr[j]){
                        arr[j] = true;
                        count++;

                        if (count == target) {
                            System.out.println(j); 
                            return; // 프로그램 종료
                        }
                    }
                }
            }
        }

    }
}