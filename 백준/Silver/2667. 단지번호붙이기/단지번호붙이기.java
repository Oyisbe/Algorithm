import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int [][] arr;

    static ArrayDeque<int[]> stack; // DFS
    static int []dr = {-1,0,1,0};
    static int []dc = {0,1,0,-1}; // 탐색은 상 우 하 좌 로 선언해주자

    static ArrayList<Integer> answers; // 단지 수를 오름 차순으로 출력

    static int search_dfs(int r, int c){
        int cnt = 1;
        arr[r][c] = 0;
        stack = new ArrayDeque<>();
        stack.addLast(new int[] {r,c});

        while (!stack.isEmpty()) {
            int[] current = stack.removeLast();
            int cur_r = current[0];
            int cur_c = current[1];

            // 4방 탐색 수행하기
            for (int i = 0; i < 4; i++) {
                int nr = cur_r + dr[i]; // delta row
                int nc = cur_c + dc[i]; // delta column

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                if (arr[nr][nc] == 0) {
                    continue;
                }

                stack.addLast(new int[] {nr, nc});
                arr[nr][nc] = 0; // 0 으로 만들자 ( 방문 처리 )
                cnt++; // 집 추가
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answers = new ArrayList<>();

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                // 입력 값들을 그대로 탐색 대상이 될 Arr 에 할당에 주자
            }
        }

        // 행 우선 순회 + 마을이 남아있는 그룹을 발견한다면(1)
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){ // 2차원 배열을 순회하며
                if(arr[i][j] == 1 ){
                    int cnt = search_dfs(i,j); // 해당 위치에서 DFS 수행하기
                    answers.add(cnt);
                }
            }
        }

        Collections.sort(answers); // 오름차순 정렬 이후

        System.out.println(answers.size());
        
        for(int cnt:answers){
            System.out.println(cnt); // 출력 해주자
        }
    }
}
