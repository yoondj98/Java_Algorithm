package BOJ_16_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16_15650 {
    public static int n;
    public static int m;
    public static int[] results;
    public static int start = 1; //start라는 값을 갱신하면서 사용가능한 범위를 제한을 둔다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        results = new int[m];
        backTracking(0);
    }

    public static void backTracking(int depth) {
        /*출력할 길이만큼 찼을 경우*/
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int result : results) {
                sb.append(result+" ");
            }
            System.out.println(sb);
        }
        /*출력 깊이가 M보다 작을 경우*/
        else {
            for (int i = start; i <= n; i++) {
                start = i + 1; //그 다음 depth에선 접근 가능한 값의 범위는 현재 depth에서의 값보다 큰 수부터이다.
                results[depth] = i;
                backTracking(depth + 1);
            }
        }
    }
}
