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

    
    ArrayList<String> stdNums = new ArrayList<String>();
    //1~30 까지 학번이 정해져있는 배열 (생활기록부)
    ArrayList<String> submitted = new ArrayList<String>();
    //사용자 입력을 통해서 받을 제출한 학생의 학번 기록

    for(int i=1;i<=30;i++){
      if(i<29){
        String userInput = bf.readLine();
        submitted.add(userInput);
      }

      stdNums.add(Integer.toString(i)); 
    }

    for(int i=0; i<submitted.size();i++){
      String compare = submitted.get(i);
      // 제출 명단에서 하나씩 가져와서, 생활기록부와 비교 

      for(int j=0;j<stdNums.size();j++){
        if(compare.equals(stdNums.get(j))){
          stdNums.remove(j);
        }
      }
    }

    for(int i=0;i<stdNums.size();i++){
      bw.write(stdNums.get(i));
      bw.newLine();
    }
  
    bw.flush();
    bw.close();
    bf.close();
  }
}