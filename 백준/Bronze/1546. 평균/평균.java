import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int M;
    static double maxPoint = 0;
    static double[] scoreArray;
    static double result = 0;

    public static void main(String[] args) throws IOException {

        M = Integer.parseInt(br.readLine()); // 먼저 과목 수를 입력받고
        scoreArray = new double[M];

        StringTokenizer st = new StringTokenizer(br.readLine()); // 이후 점수들 입력

        for(int i= 0; i<M;i++){
            scoreArray[i] = Integer.parseInt(st.nextToken());
            if(scoreArray[i]>maxPoint)
                maxPoint = scoreArray[i];
        }

        for(int i=0;i<M;i++){
            scoreArray[i]= scoreArray[i]/maxPoint*100;
            result +=scoreArray[i];
        }
        System.out.println(result/M);
    }
}

// 문제점 1 : 최댓값 또한 점수를 바꿔줘야됨 ( 문제 잘못 이해함 )
// 문제점 2 : 배열 내 점수 변환 -> 계속 0 으로 바뀜 ( int -> 1 이하의 수는 계속 0 으로 변환되어서 )
