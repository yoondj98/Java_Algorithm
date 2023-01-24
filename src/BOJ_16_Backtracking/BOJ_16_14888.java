package BOJ_16_Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16_14888 {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;

    public static int [] number;
    public static int [] operator = new int[4];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        number = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0], 1);
        sb.append(MAX+"\n"+MIN);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void dfs(int num, int index){
        /*depth를 모두 탐색했으면 MAX, MIN 업데이트*/
        if(index == N){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);

            return;
        }
        /*해당 num에 대해서 쓸 연산자를 for문으로 돌림 -> 따로 연산자 배치순서를 정해줄 필요X*/
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--; //i번째 연산자를 하나 사용

                /*--한 연산자를 계산에 적용하고 그 다음 depth로 들어감*/
                switch(i){ //switch문을 이용해서 필요한 case에 맞는 역할을 진행하도록 해준다.
                    case 0: dfs(num + number[index], index + 1);break;  //switch문에서 break이 없으면 다음 case로 넘어가서 다음 case마저 수행하게 된다.
                    case 1: dfs(num - number[index], index + 1);break;
                    case 2: dfs(num * number[index], index + 1);break;
                    case 3: dfs(num / number[index], index + 1);break;
                }
                operator[i]++; //i번째 연산자를 다시 회수
            }
        }

    }
}
