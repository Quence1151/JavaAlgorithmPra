import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2583 {
    static int[][] square;
    static int area;
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        square = new int[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++){
                    square[y][x] = 1;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(square[i][j] == 0) {
                    area = 0;
                    dfs(i,j,N,M);
                    result.add(area);
                }
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(result.size()+"\n");
        for(int r : result) {
            sb.append(r+" ");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();

    }
    static void dfs(int x, int y, int n, int m) {
        area++;
        square[x][y] = 1;
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0<=nx && nx<n && 0<=ny && ny < m) {
                if(square[nx][ny] == 0) {
                    dfs(nx,ny, n, m);
                }
            }
        }
    }
}
