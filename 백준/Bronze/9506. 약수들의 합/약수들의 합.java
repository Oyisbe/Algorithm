import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /*
    입력 : 각 줄 마다 N, 마지막에는 -1 ( 무한 루프 종료 )
    출력 : 완전수라면 약수들의 합으로 표현하고, 아니면 문장으로 출력

    6 = 1 + 2 + 3
    12 is NOT perfect.
    28 = 1 + 2 + 4 + 7 + 14
    -1

    구현 : 시간 제한이 2초, 완전 탐색으로 기본적인 구현이 가능할 듯 보임.
    */

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        boolean flag = true;

        while(flag){
            int input  = Integer.parseInt(br.readLine());
            if(input == -1){
                flag = false;
            }
            else{
                process(input);
            }
        }
    }

    public static void process(int input){

        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for(int i=1;i<=input-1;i++){
            if(input%i==0){
                numbers.add(i);
            }
            // 약수를 구해주고
        }
        for(Integer number : numbers){
            sum += number; // 약수들의 합
        }

        if(sum == input){
            //6 = 1 + 2 + 3

            StringBuilder sb = new StringBuilder();
            sb.append(input).append(" = ");

            for(int i=0;i<numbers.size()-1;i++){
                sb.append(numbers.get(i)).append(" + ");
            }
            sb.append(numbers.get(numbers.size()-1));
            System.out.println(sb);
        }
        else{
            System.out.printf("%d is NOT perfect.\n",input);
        }
    }
}