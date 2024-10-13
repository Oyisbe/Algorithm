import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int numberOfNum;
    static int numberOfSearch;

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> targets = new ArrayList<>();
        numberOfNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<numberOfNum;i++) {
                targets.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(targets); // 이진 탐색을 위한 정렬

        numberOfSearch = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<numberOfSearch;i++) {
            int temp = Integer.parseInt(st.nextToken());
            binarySearch(temp,targets);
        }
    }

    static void binarySearch(int target, ArrayList<Integer> list ) {
        int startIdx = 0;
        int endIdx = list.size()-1;

        // [midIdx] 의 값과 비교 -> 좌측 / 우측으로 탐색 범위 한정짓고 계속 반복하기
        // 최악의 경우 -> startIdx = endIdx 즉 하나 남을때까지 탐색하기에 (<=)
        while(startIdx<=endIdx){
            int midIdx = (startIdx+endIdx)/2;

            if(target == list.get(midIdx)) {
                System.out.println(1);
                return;
            }
            else if(target > list.get(midIdx)) {
                startIdx = midIdx+1;
            }
            else{
                endIdx = midIdx-1;
            }
        }

        System.out.println("0");
    }
}
