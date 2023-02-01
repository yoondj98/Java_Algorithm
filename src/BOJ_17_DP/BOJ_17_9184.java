package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17_9184 {
    static int[][][] arr = new int [21][21][21];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1) break;
            sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)).append("\n");

        }
        System.out.print(sb);
    }

    static int w(int i, int j, int k){ //문제 조건과 순서를 맞춰줘야 조건이 겹쳐질 때 정확한 값을 만들 수 있음.
        if(in(i,j,k)&&arr[i][j][k]!=0) return arr[i][j][k];
        if(i<=0||j<=0||k<=0) return 1;
        if(i>20||j>20||k>20) return arr[20][20][20]=w(20,20,20);
        if(i<j&&j<k) return arr[i][j][k] = w(i,j,k-1) + w(i, j-1, k-1) - w(i, j-1, k);
        else return arr[i][j][k] = w(i-1, j ,k) + w(i-1, j-1, k)+ w(i-1, j, k-1) - w(i-1, j-1, k-1);
    }

    static boolean in(int i , int j, int k){
        if((0<=i&&i<=20)&&(0<=j&&j<=20)&&(0<=k&&k<=20)) return true;
        return false;
    }
}
