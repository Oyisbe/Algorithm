import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static int N;
    static String input;

    static ArrayDeque<Integer> stack;

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        stack = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
          input = br.readLine();

          if(input.contains("push")){
              String[] temp = input.split(" ");
              // 공백으로 나눴을 때 temp[1]은 스택에 추가할 수가 됨.
              stack.addLast(Integer.parseInt(temp[1]));
          }

          else if(input.equals("pop")){
              if(stack.isEmpty())
                  System.out.println("-1");
              else{
                  System.out.println(stack.getLast());
                  stack.removeLast();
              }
          }

          else if(input.equals("size"))
              System.out.println(stack.size());

          else if(input.equals("empty")){
              if(stack.isEmpty())
                  System.out.println("1");
              else
                  System.out.println("0");
          }

          else{
              //top
              if(stack.isEmpty())
                  System.out.println(-1);
              else
                  System.out.println(stack.getLast());
          }
        }
    }
}