package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17_9461 {
    static long [] P; //long타입으로 했어야 하다니...!! 타입 범위 예상해내는 천재가 되어야 하나...!!!
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T; i++){
            P = new long [101];
            int N = Integer.parseInt(br.readLine());
            P[1] = 1;
            P[2] = 1;
            P[3] = 1;
            System.out.println(result(N));
        }
    }

    static long result(int a) {
        if(P[a]!=0) return P[a];
        return P[a] = result(a-2) + result(a-3);
    }
}
