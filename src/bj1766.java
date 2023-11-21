import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다시 풀어보기
/*
a) N개의 문제를 모두 풀어야 한다.  → 그래프 완전 탐색
b) 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다. → 우선순위 큐
c) 가능하면 쉬운 문제부터 풀어야 한다.  → 위상 정렬
* */
public class bj1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //문제의 수
        int M = Integer.parseInt(st.nextToken()); //정보의 수
        List<List<Integer>> qList = new ArrayList<>();
        int[] priority = new int[N+1];
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N+1; i++) {
            qList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            qList.get(prev).add(next);
            priority[next]++;
        }

        for (int i = 1; i < N+1; i++) {
            if(priority[i] == 0){
                priorityQueue.offer(i);
            }
        }

        while(!priorityQueue.isEmpty()){
            int now = priorityQueue.poll();
            sb.append(now + " ");
            for (int next:qList.get(now)) {
                priority[next]--;
                if(priority[next] == 0){
                    priorityQueue.offer(next);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
