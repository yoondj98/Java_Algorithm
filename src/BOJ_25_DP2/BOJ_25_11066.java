package BOJ_25_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[][] arr = new int[K + 1][K + 1];
            for (int j = 1; j <= K; j++) arr[j][j] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K - 1; j++) {
                for (int k = 1; k <= K - j; k++) {
                    arr[k][k + j] = Integer.MAX_VALUE;
                    for (int l = k; l < k + j; l++) {

                        arr[k][k + j] = Math.min(arr[k][l] + arr[l + 1][k + j], arr[k][k + j]);
                    }
                    if (j != K - 1)
                        for (int p = k; p <= k + j; p++) {
                            arr[k][k + j] += arr[p][p];
                        }
                }
            }
            System.out.println(arr[1][K]);
        }
    }
}
