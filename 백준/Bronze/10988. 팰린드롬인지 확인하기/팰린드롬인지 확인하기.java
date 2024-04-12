import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 
    static String word; 
    static int flag = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        word = br.readLine();
        
        for (int i = 0; i <= (word.length()-1)/ 2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                flag = 0;
                break;
            }
        }
        System.out.println(flag);
    }
}