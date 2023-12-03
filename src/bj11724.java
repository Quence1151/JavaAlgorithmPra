import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11724 {
    static List<ArrayList<Integer>> nearList = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            nearList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nearList.get(x).add(y);
            nearList.get(y).add(x);
        }
        int count = 0;
        for(int i=1; i<=N; i++) {

            if(visited[i] == false) {
                BFS(i);
                count ++;
            }

        }

        System.out.println(count);

    }
    static void BFS(int value) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(value);

        while( !que.isEmpty() ) {
            int num = que.poll();

            int size = nearList.get(num).size();

            for(int i=0; i<size; i++) {
                int new_value = nearList.get(num).get(i);

                if(visited[new_value] == false) {
                    que.offer(new_value);
                    visited[new_value] = true;
                }
            }

        }
    }
}
