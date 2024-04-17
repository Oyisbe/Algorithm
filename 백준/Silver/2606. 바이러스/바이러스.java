import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int vertex;
    static int edge;
    static int[][] adj;
    static int startNode = 1;
    static boolean[] visited;
    static int current;
    static ArrayList<Integer> track = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        adj = new int[vertex+1][vertex+1];
        //인접 행렬부터 먼저 만들기
        visited = new boolean[vertex+1];

        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start][end] = 1;
            adj[end][start] = 1;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(startNode);
        // 스택에 스타팅 노드를 적어준다.

        while(!stack.isEmpty()){
            current = stack.removeLast();
            //  pop 연산의 리턴값을 Current에 저장한다. (후입 선출 )
            if(!visited[current]){
                visited[current] = true;
                track.add(current);
                // visited에 존재하지 않는다면, 방문처리.
            }

            for(int i=1;i<vertex+1;i++){
                // 이후에 전에 만든 인접행렬들을 돌면서
                if(!visited[i]&&adj[current][i]==1){
                    // 아직 방문하지 않고 and 인접행렬에서도 연결된 것을 확인할 수 있다면
                    stack.addLast(i);
                    // 해당 노드를 스택에 추가한다.
                }
            }
        }
        // 시작 노드는 1로 고정하였기에, DFS의 결과에서 하나를 빼면 된다. 
        // ( 스타팅 노드를 제외한 결과 출력 )
        System.out.println(track.size()-1);
    }
}
