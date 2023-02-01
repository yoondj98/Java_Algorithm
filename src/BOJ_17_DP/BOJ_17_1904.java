package BOJ_17_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17_1904 {
    static int [] caseArr;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        caseArr= new int [N+1];
        for(int i=0; i<=N; i++) caseArr[i] = -1;
        caseArr[1] = 1;
        if(N>1) caseArr[2] = 2; //아무리 기초공사 값이 작아도 입력받는 값이 더 작을 수도 있다. 주의하자.
        System.out.println(value(N));
    }
    static int value(int a){
        if(caseArr[a]!=-1) return caseArr[a];
        return caseArr[a] = (value(a-1)+value(a-2))%15746; //항상 작은 수부터 규칙을 찾는 방향으로 접근해보자.
    }
}
