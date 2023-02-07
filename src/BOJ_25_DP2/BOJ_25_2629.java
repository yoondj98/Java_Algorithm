package BOJ_25_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25_2629 {
    static int N;
    static boolean [][] dp;
    static int [] chu;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new boolean [31][150001];
        chu = new int [N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N;i++) {
            chu[i] = Integer.parseInt(st.nextToken());
        }
        check(0, 0);
        int T = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0; i<T; i++) {
            if(dp[N][Integer.parseInt(st.nextToken())]){
                sb.append("Y ");
            }
            else sb.append("N ");
        }
        System.out.println(sb);
    }
    static void check(int index, int weight){
        if(dp[index][weight]) return; //미리 컷하는 습관! 이게 DP다.
        dp[index][weight] = true;
        if(index==N) return;
        else{
            check(index+1, weight+chu[index+1]);
            check(index+1, weight);
            check(index+1, Math.abs(weight-chu[index+1]));
        }
    }
}
