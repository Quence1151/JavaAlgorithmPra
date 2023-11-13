import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int price = Integer.parseInt(st.nextToken()); //구매 물품 가격
        int result = calcChanges(price);
        System.out.println(result);
    }
    static int calcChanges(int price){
        int[] coins = {500,100,50,10,5,1};
        int count = 0;
        int changes = 1000 - price;
        for (int coin : coins) {
            int temp = 0;
            temp = changes / coin;
            changes -= (temp * coin);
            count += temp;
        }
        return count;
    }
}
