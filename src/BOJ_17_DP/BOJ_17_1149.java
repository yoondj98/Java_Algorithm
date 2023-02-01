package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17_1149 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][] cost = new int [N+1][4];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
            cost[i][3] = Integer.parseInt(st.nextToken());
        }
        int include_cost [][] = new int [N+1][4];
        include_cost[1][1] = cost[1][1];
        include_cost[1][2] = cost[1][2];
        include_cost[1][3] = cost[1][3];
        for(int i=2; i<=N; i++){ //메모이제이션 방법 채택
            include_cost[i][1] = Math.min(include_cost[i-1][2], include_cost[i-1][3]) + cost[i][1];
            include_cost[i][2] = Math.min(include_cost[i-1][1], include_cost[i-1][3]) + cost[i][2];
            include_cost[i][3] = Math.min(include_cost[i-1][1], include_cost[i-1][2]) + cost[i][3];
        }
        System.out.println(Math.min(Math.min(include_cost[N][1], include_cost[N][2]), include_cost[N][3]));
    }
}
