import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    // 문자열을 입력받기 위한 BufferedReader
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 문자열을 출력하기 위한 BufferedWriter

    String userInput = bf.readLine();
    int conditionNum = Integer.parseInt(userInput);
    int count = 0;

    String[] numbers = bf.readLine().split(" ");

    if(numbers.length==conditionNum){
      String targetNum = bf.readLine();
  
      for(int i = 0; i<numbers.length;i++){
        if(numbers[i].equals(targetNum))
          count+=1;
      }
    }
    bw.write(Integer.toString(count));
    bw.flush();
    bw.close();
    bf.close();
 }
}