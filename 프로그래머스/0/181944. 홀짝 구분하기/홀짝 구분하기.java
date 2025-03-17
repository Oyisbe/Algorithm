import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Solution {
    
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder(String.valueOf(N));
        
        if(N%2==0){
            sb.append(" is even");
        }else{
            sb.append(" is odd");
        }
        System.out.println(sb);
    }
}