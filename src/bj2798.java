import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //카드 숫자
        int M = Integer.parseInt(st.nextToken()); //목표 합계
        int[] card = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int result = search(card, M);
        System.out.println(result);
    }
    static int search(int[] card, int num){
        int temp;
        int result = 0;
        for (int i = 0; i < card.length-2; i++) {
            for (int j = i+1; j < card.length-1; j++) {
                for (int k = j+1; k < card.length; k++) {
                    temp = card[i]+card[j]+card[k];
                    if(temp == num){
                        System.out.println(card[i]);
                        System.out.println(card[j]);
                        System.out.println(card[k]);
                        return temp;
                    }
                    if(temp < num && (num - temp) < (num - result)){
                        result = temp;
                    }
                }
            }
        }
        return result;
    };
}
