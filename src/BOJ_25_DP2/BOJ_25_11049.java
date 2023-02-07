package BOJ_25_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N + 1][2];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N-1; i++) {
            for (int j = i + 1; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= N - i; j++) {
                for (int k = j; k <= j + i - 1; k++) {
                    dp[j][j + i] = Math.min(dp[j][k] + dp[k + 1][j + i] + matrix[j][0] * matrix[k][1] * matrix[j + i][1], dp[j][j + i]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}
