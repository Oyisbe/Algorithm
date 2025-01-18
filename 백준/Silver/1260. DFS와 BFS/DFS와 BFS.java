import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // Node
    static int M; // Edge
    static int V; // Starting

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        // 우선 노드, 간선, 스타팅 위치를 입력받은 뒤

        // 배열의 index 마다 ArrayList 초기화
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i=0;i<N+1;i++)
            adj[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            // 각 줄에 입력받는 연결 정보 할당
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }

        dfs(V);
        visited = new boolean[N+1]; // 재초기화 필요
        System.out.println();
        bfs(V);
    }

    static void print(ArrayList<Integer> tracks){
        for (int i = 0; i < tracks.size(); i++) {
            System.out.print(tracks.get(i));
            if (i < tracks.size() - 1) {
                System.out.print(" ");
            }
        }
    }
    static void dfs(int startingNode){

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> tracks = new ArrayList<>();
        stack.addLast(startingNode);

        while(!stack.isEmpty()){
            int current = stack.removeLast();
            if(!visited[current]){
                //방문하지 않았다면
                visited[current] = true; // 방문처리 하고
                tracks.add(current); // 경로에 추가해주기
            }

            List<Integer> connected = adj[current]; // 현재 노드와 연결된 노드들을
            Collections.sort(connected); // 오름 차순으로 정렬해주고 ( 문제에서 작은 번호 노드부터 방문하라고 제시됨 )

            // 주의 ! 후입 선출이니까 큰 거 부터 넣어야한다 !
            for (int i = connected.size() - 1; i >= 0; i--) {
                Integer destination = connected.get(i);
                if (!visited[destination]) {
                    stack.addLast(destination);
                }
            }
        }
        print(tracks);
    }

    static void bfs(int startingNode){
        ArrayDeque<Integer> Queue = new ArrayDeque<>();
        ArrayList<Integer> tracks = new ArrayList<>();

        Queue.addLast(startingNode);

        while(!Queue.isEmpty()){
            int current = Queue.removeFirst(); // 큐는 후입 선출
            if(!visited[current]){
                visited[current] = true; // 방문처리
                tracks.add(current);
            }

            List<Integer> connected = adj[current];
            Collections.sort(connected); // 오름차순 정렬

            for(Integer destination : connected){
                // 현 노드에서, destination 노드들이 방문되지 않았다면
                if(!visited[destination]){
                    Queue.addLast(destination);
                }
            }
        }
        print(tracks);
    }
}