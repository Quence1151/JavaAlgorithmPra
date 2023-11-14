import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 단어의 수
        int result = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            result += countGoodWord(word,N);
        }
        System.out.println(result);
    }
    static int countGoodWord(String word, int N){
        if (word.length() % 2 == 1) {
            return 0;
        }
            Stack<Character> stack = new Stack<>();
            stack.push(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (stack.size() > 0 && stack.peek() == word.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(word.charAt(i));
                }
            }
            if (stack.isEmpty()){
                return 1;
            }
            return 0;
    }
}
