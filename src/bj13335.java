import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //트럭의 수
        int W = Integer.parseInt(st.nextToken()); //다리의 길이
        int L = Integer.parseInt(st.nextToken()); //다리의 최대 하중
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        int time = W;

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }
        while (truck.size() != 0){
            bridgeWeight-=bridge.poll();
            if(bridgeWeight + truck.peek() > L){
                bridge.offer(0);
            }else{
                bridgeWeight += truck.peek();
                bridge.offer(truck.poll());
            }
            time++;
        }
        System.out.println(time);
    }
}
