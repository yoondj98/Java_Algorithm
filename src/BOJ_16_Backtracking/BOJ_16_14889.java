package BOJ_16_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16_14889 {
    static int [][] stat;
    static int N;
    static boolean[] visit;
    static int Min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stat = new int [N+1][N+1]; //stat: 각 팀원 간의 시너지
        visit = new boolean[N+1];
        for(int i=1; i <=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=N; j++){
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(1,0);
        System.out.println(Min);
    }
    /*visit값을 true로 변경하면서 편 가르기를 진행 후 딱 절반을 모집했을 때 최소값을 계산, dfs로 탐색을 함.*/
    static void combination(int num, int count){
        if(count == N/2){
            calculate();
            return;
        }

        for(int i=num; i<N+1; i++){
            if(!visit[i]){
                visit[i]=true;
                combination(i+1, count+1);
                visit[i] = false;
            }
        }
    }
    /*visit배열로 TF가 나뉘어짐. 이걸 기반으로 팀별 능력치 계산을 해서 차이의 최소값을 업데이트함.*/
    static void calculate(){
        int start = 0;
        int link = 0;
        for(int i=1; i<N; i++){
            for(int j=i+1; j<N+1; j++){
                if(visit[i] && visit[j]){
                    start += stat[i][j];
                    start += stat[j][i];
                }

                else if(!visit[i] && !visit[j]){
                    link += stat[i][j];
                    link += stat[j][i];
                }
            }
        }

        int result = Math.abs(start - link);

        if(result == 0){
            System.out.println(result);
            System.exit(0);
        }
        Min = Math.min(Min, result);
    }
}
