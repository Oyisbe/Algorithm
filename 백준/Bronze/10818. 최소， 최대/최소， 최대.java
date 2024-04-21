import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = -1_000_000;
    static int min = 1_000_000;
    static int trial;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        trial = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<trial;i++){
            int compare = Integer.parseInt(st.nextToken());

            if(compare>max)
                max = compare;
            if(compare<min)
                min = compare;
        }
        System.out.printf("%d %d",min,max);
    }
}