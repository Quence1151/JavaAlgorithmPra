import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            Deque<Character> word = new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                char temp = st.nextToken().charAt(0);
                if(word.isEmpty()){
                    word.add(temp);
                }else {
                    if(temp <= word.peekFirst()){
                        word.offerFirst(temp);
                    }else{
                        word.offerLast(temp);
                    }
                }
            }
            while(!word.isEmpty()){
                sb.append(word.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
