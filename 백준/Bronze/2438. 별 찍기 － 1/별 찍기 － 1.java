import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int trial;
        Scanner scan = new Scanner(System.in);
        trial = scan.nextInt();
        for(int i=0;i<trial;i++) 
            {
                for(int j=-1;j<i;j++)
                {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
}
               