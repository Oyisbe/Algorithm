import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 문자열의 개수
    static int M; // 검사해야할 문자열의 수
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // N 과 M 을 입력받고

        // 먼저 집합에 들어갈 문자열들을 입력받고
        HashMap<Integer, String> set = new HashMap<Integer, String>();

        int count = 0;

        for(int i=0;i<N;i++){
            String input = br.readLine();
            set.put(i, input);
        }

        // 이후 검사해야할 문자열을 입력받고
        for(int i=0;i<M;i++){
            String input = br.readLine();
            // value 가 있는지 판단하여 count 증가
            if(set.containsValue(input))
                count++;
        }
        System.out.println(count);
    }
}