package BOJ_16_Backtracking;

import java.io.*;

public class BOJ_16_9663 {
    public static int num;
    public static int [] n_board;
    public static int count = 0;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        n_board = new int [num]; //이건 웬만하면 depth랑 똑같이 범위를 가져가야 한다. 0~num-1이어야 하고 1~num으로 가면 안된다.

        nqueens(0);
        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();

    }
    /*해당 depth가 가능한지 여부를 확인하는 함수*/
    public static boolean promising(int x){
        for(int i=0; i<x; i++){
            if(n_board[x] == n_board[i] || Math.abs(n_board[x] - n_board[i]) == Math.abs(x - i)) return false;
        }
        return true;
    }
    /*각 행마다의 퀸이 놓일 수 있는 열을 써두는 함수*/
    public static void nqueens(int depth){
        if(depth == num){
            count++;
            return;
        }
        for(int i=0; i<num; i++){
            n_board[depth] = i;
            if(promising(depth)) nqueens(depth+1);
        }
    }
}
