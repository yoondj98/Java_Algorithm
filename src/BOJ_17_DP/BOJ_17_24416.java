package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17_24416 {
    static int fib_count = 0;
    static int fibonacci_count = 0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(fib_count+" "+fibonacci_count);
    }

    static int fib(int a){
        if(a==1||a==2) {
            fib_count++;
            return 1;
        }
        else return fib(a-1)+fib(a-2);
    }
    static int fibonacci(int b){
        int [] fib_arr = new int [b+1];
        fib_arr[1] = 1;
        fib_arr[2] = 1;
        for(int i=3; i<=b; i++) {
            fib_arr[i] = fib_arr[i-2] + fib_arr[i-1];
            fibonacci_count++;
        }
        return fib_arr[b];
    }
}
