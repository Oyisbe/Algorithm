import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    FastReader fr = new FastReader();
  
    int[] examples = new int[9];
    int max = 0;
    int max_index = 0;

    // int 입력 9개,최댓값은 max
    for (int i = 0; i < 9; i++){
      int a = fr.nextInt();
      examples[i] =a;
      // 값 입력 받기
      
      if (max < a){
        max = a;
        // 최대 값 저장하기
      }
      
      if(examples[i]==max)
        max_index = i; // 루프 돌면서 최대값이라면 index 갱신
    }
    System.out.println(max);
    System.out.println(max_index+1);
  }

  public static class FastReader {
      BufferedReader br;
      StringTokenizer st;
      public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
      public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try { st = new StringTokenizer(br.readLine()); }
              catch (IOException e) { e.printStackTrace(); }
          }
          return st.nextToken();
      }
      int nextInt() { return Integer.parseInt(next()); }
      long nextLong() { return Long.parseLong(next()); }
      double nextDouble() { return Double.parseDouble(next()); }
      String nextLine() {
          String str = "";
          try { str = br.readLine(); }
          catch (IOException e) { e.printStackTrace(); }
          return str;
      }
  }
}