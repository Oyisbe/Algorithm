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

    String trial = bf.readLine();

    try{
      for(int i=0;i<Integer.parseInt(trial);i++){
        String[] answer = bf.readLine().split(" ");
        int a = Integer.parseInt(answer[0]);
        int b = Integer.parseInt(answer[1]);

        bw.write(Integer.toString(a + b));
        bw.newLine();
      }
   } catch(ArrayIndexOutOfBoundsException e){
  } 
    bw.flush();
    bw.close();
    bf.close();
 }
}