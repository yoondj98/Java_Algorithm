package BOJ_16_Backtracking;


import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16_15651 {
    public static int M;
    public static int N;
    public static int [] results;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        results = new int[M];

        backTracking(0);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void backTracking(int depth){
        /*출력할 길이만큼 찼을 경우*/
        if(depth==M){
            for(int result:results) sb.append(result+" ");
            sb.append('\n'); //sb를 한 줄마다 sout 하는 것이 시간초과를 불러올 수 있다. sb를 털고 가지말고 전역으로 StringBuilder를 선언하고 여기에 모아서 마지막에 털자.
        }
        /*출력 깊이가 M보다 작을 경우*/
        else {
            for (int i = 1; i <= N; i++) { //값에 대한 중복 여부를 확인 안해도 되고, 오름차순도 고려하지 않아도 되기에 visit, start 처리 안해주어도 됨.
                results[depth] = i;
                backTracking(depth + 1);
            }
        }
    }
}
