import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 술래의 위치
    static int M; // 동생의 위치

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(search(N,M));
    }

    public static int search(int N, int K){


        int second = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>(); // BFS (Queue)
        Set<Integer> visited = new HashSet<>(); // 방문 처리

        // 큐에 시작점 추가하고 방문 처리
        queue.addLast(N);
        visited.add(N);

        // BFS 수행
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨에 있는 노드들의 개수

            for (int i = 0; i < size; i++) {
                int cur = queue.removeFirst(); // 현재 위치를 꺼내고

                // 목적지에 도달했으면 그때까지의 시간을 반환
                if (cur == K) {
                    return second; // 목표 도달 시 시간 반환
                }

                // 현재 노드에서 이동 가능한 3가지 경로를 큐에 추가
                int[] nextPositions = {cur + 1, cur - 1, cur * 2};

                for (int next : nextPositions) {
                    if (!visited.contains(next) && next >= 0 && next <= 100000) {
                        visited.add(next); // 방문 처리
                        queue.addLast(next); // 큐에 추가
                    }
                }
            }

            // 각 레벨을 다 탐색한 후 시간 증가
            second++;
        }

        return -1; // (탐색이 불가능 할 경우 - 존재하긴 하니 ?)
    }
}
