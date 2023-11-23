import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            bw.write(map.get(st.nextToken())+"\n");
        }
        bw.close();
    }
}
