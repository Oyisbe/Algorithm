import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {

    static int N; // 주어진 카드의 수
    static int K; // 선택할 카드의 수
    static String[] cards; // 주어진 카드들
    static boolean[] chk;
    static HashSet<String> combinations = new HashSet<>();

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new String[N+1]; // 1 부터 N 까지 인덱스 컨트롤을 하기 위함
        chk = new boolean[N+1]; // 각 카드의 방문 여부 판단

        for(int i=1;i<N+1;i++){
            cards[i] = br.readLine();
        }
        backTracking(0,"");
        System.out.println(combinations.size());
    }

    public static void backTracking(int depth, String combination){

        if(depth==K){
            // K 개 만큼 뽑았다면 재귀 종료
            combinations.add(combination); // 중복을 허용하지 않으니까 굳이 contains 로 판별 필요 없음
        }
        for(int i=1;i<N+1;i++){
            // 방문하지 않은 카드만을 대상으로 함 ( false )
            if(!chk[i]){
                chk[i]=true;
                backTracking(depth+1,combination+cards[i]);
                // 이후 호출될 하위 레벨의 재귀 함수들이 전부 실행 이후 종료되었다면
                // 이후 방문했던 노드의 값을 다시금 false 로 설정
                chk[i]=false;
            }
        }
    }
}
