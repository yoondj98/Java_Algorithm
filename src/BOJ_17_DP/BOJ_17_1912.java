package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17_1912 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int [] to = new int [N+1];
        for(int i=1; i<=N; i++){
            if(i==1) to[i] = arr[1];
            to[i] = Math.max(arr[i], arr[i]+to[i-1]);
            max = Math.max(to[i], max);
        }
        System.out.println(max);
    }
}
