package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17_2579 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] weight = new int [n+1]; //계단 가중치 값
        weight[0] = 0;
        for(int i=1; i<=n; i++) weight[i] = Integer.parseInt(br.readLine());
        int [] include_weight = new int [n+1]; //
//        include_weight[0] = 0;
        if(n>=1)include_weight[1] = weight[1];
        if(n>=2)include_weight[2] = weight[1]+weight[2];
        if(n>=3)include_weight[3] = Math.max(weight[1]+weight[3],weight[2]+weight[3]);
        if(n>=4) for(int i=4; i<=n;i++) include_weight[i] = Math.max(include_weight[i-2], weight[i-1]+include_weight[i-3])+weight[i];
        System.out.println(include_weight[n]);
    }
}
