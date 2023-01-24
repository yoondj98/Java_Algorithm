package BOJ_16_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16_15649 {
    public static int n;
    public static int m;
    public static int[] results;
    public static boolean [] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        results = new int[m];
        visit = new boolean [n+1]; //주어진 숫자 n까지의 숫자 방문 여부
        for(int i=0; i<n; i++){
            visit[i] = false;
        }
        backTracking(0);
    }

    public static void backTracking(int depth) {
        /*출력할 길이만큼 찼을 경우*/
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int result : results) {
                sb.append(result + " ");
            }
            System.out.println(sb);
        }
        /*출력 깊이가 M보다 작을 경우*/
        else {
            for (int i = 1; i <= n; i++) { //for문으로 돌면서
                if (visit[i] == true) //방문한 경우엔 skip
                    continue;
                else { //방문하지 않은 경우엔
                    visit[i] = true; //visit true화
                    results[depth] = i; //값을 넣어주고
                    backTracking(depth + 1); //그 다음 깊이로 백트래킹
                    visit[i] = false; //돌아와서 다시 visit false로 초기화
                }
            }
        }
    }
}
