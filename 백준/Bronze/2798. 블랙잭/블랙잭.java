import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 각 카드에는 양의 정수가 쓰여있다.

    /*
    * N 장 중에 최대한 M 과 가깝에 3장을 고른다.
    * 3장의 합은 M 을 초과할 수 없다.
    * */

    static int N;
    static int M;
    static int[] arr;

    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {

      StringTokenizer st = new StringTokenizer(br.readLine()); // 우선 한 줄을 입력받고

      N = Integer.parseInt(st.nextToken()); // 카드의 수
      M = Integer.parseInt(st.nextToken()); // 블랙잭 타겟

      arr = new int[N];

      st = new StringTokenizer(br.readLine());

      for(int i=0;i<N;i++){
          arr[i] = Integer.parseInt(st.nextToken());
      }

      for(int i=0;i<arr.length;i++){
          // 배열 -> 3장을 고른다. 좌측부터 순회하면서 반복을 통해 다 더해본다.
          for(int j=i+1;j<arr.length;j++){
              for(int k=j+1;k<arr.length;k++){

                  if(arr[i]+arr[j]+arr[k]>max && arr[i]+arr[j]+arr[k]<=M){

                      max = arr[i]+arr[j]+arr[k];
                      // 고른 3장의 카드의 수가 지금까지 순회하며 더한 값보다 크면 값을 갱신해주고
                      sum = arr[i]+arr[j]+arr[k];
                      // 세 장의 합을 기록해나간다
                  }
                  else
                      continue;
              }
          }
      }
        System.out.println(sum);
    }
}