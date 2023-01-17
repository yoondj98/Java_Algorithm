package BOJ_10_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean [] arr = new boolean [2000001];
        for(int i=1; i<=n; i++){
            arr[Integer.parseInt(br.readLine())+1000000] = true;
        }
        for(int i=0; i<2000001; i++)
            if(arr[i])
                sb.append(i-1000000+"\n");
        System.out.println(sb);
    }
}
