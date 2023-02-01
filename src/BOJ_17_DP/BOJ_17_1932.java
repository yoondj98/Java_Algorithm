package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [][] tree = new int [n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int include_cost [][] = new int [n+1][n+1];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++) {
                if (j == 1) include_cost[i][j] = include_cost[i - 1][j] + tree[i][j];
                else if(j == i) include_cost[i][j] = include_cost[i - 1][j - 1] + tree[i][j];
                else {
                    include_cost[i][j] = Math.max(include_cost[i - 1][j - 1], include_cost[i - 1][j]) + tree[i][j];
                }
            }
        }
        for(int i=1; i<=n; i++) max = Math.max(max, include_cost[n][i]);
        System.out.println(max);
    }
}
