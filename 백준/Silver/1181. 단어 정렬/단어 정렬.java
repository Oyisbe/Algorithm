import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int numbers;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 짧은 문자열부터 출력하되, 길이가 같으면 사전 순으로. ( 단 중복은 존재할 수 없다. )

    public static void main(String[] args) throws IOException {

        HashSet<String> inputs = new HashSet<String>();
        //Map<Integer, String> orderBySize = new HashMap<Integer, String>();

        numbers = Integer.parseInt(br.readLine());

        for(int i=0;i<numbers;i++){
            String temp = br.readLine();
            inputs.add(temp); // Hashset 을 통한 중복 방지
        }

        ArrayList<String> orderBySize = new ArrayList<>(inputs);

        // 길이 순으로 정렬 (key-value 형태의 자료구조를 사용한다면 같은 길이 처리 불가능)
        // 이후 알파벳 오름차순으로 정렬

        Collections.sort(orderBySize, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이 비교 ( 음수 / 양수 / 0 )
                int lengthResult = Integer.compare(o1.length(), o2.length());

                // 길이가 다르다면 그대로 return
                if(lengthResult!=0)
                    return lengthResult;

                // 길이가 같은 경우 : 이제 여기서 알파벳 순으로 정렬
                return o1.compareTo(o2);
            }
        });

        for(int i=0;i<orderBySize.size();i++){
            System.out.println(orderBySize.get(i));
        }
    }
}