package BOJ_16_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16_15652 {
    public static StringBuilder sb = new StringBuilder();
    public static int M;
    public static int N;
    public static int [] results;
    public static int start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        results = new int[M];
        backTracking(0);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void backTracking(int depth){
        /*출력할 길이만큼 찼을 경우*/
        if(depth==M){
            for(int result : results) sb.append(result+" ");
            sb.append('\n');
            return; //if-else 문이 아닌 이런 식으로 if문만 쓰는 경우 좀 더 간결해질 수 있다. 이때 return을 해줘야 if문 수행 후 else로 수행될 부분이 실행되지 않는다.
        }
        /*출력 깊이가 M보다 작을 경우*/
        for(int i=start; i<=N; i++){
            start = i;
            results[depth] = i;
            backTracking(depth+1);
        }
    }
}
