import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {
    public static int[] nums;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        visit = new boolean[N];

        makeNumber(N, M, 0);
    }
    public static void makeNumber(int N, int M, int depth){
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int num : nums) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                nums[depth] = i+1;
                makeNumber(N, M, depth + 1);
                visit[i] = false;
            }
        }

    }
}
