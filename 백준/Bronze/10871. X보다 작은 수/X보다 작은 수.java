import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    // 문자열을 입력받기 위한 BufferedReader
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 문자열을 출력하기 위한 BufferedWriter

    String[] Conditions = bf.readLine().split(" ");
    // Item의 수, 최대값 입력
    
    int size = Integer.parseInt(Conditions[0]);
    int limit = Integer.parseInt(Conditions[1]);

    String correctCheck = bf.readLine();
    String[] answer = correctCheck.split(" ");

    for(int i = 0; i<answer.length;i++){ 
      if(Integer.parseInt(answer[i])<limit)
        bw.write(answer[i]+" ");
    }
    
    bw.flush();
    bw.close();
    bf.close();
 }
}