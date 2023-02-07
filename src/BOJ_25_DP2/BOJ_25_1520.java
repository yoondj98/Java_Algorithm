package BOJ_25_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25_1520 {
    public static int X, Y;
    public static int[][] map, height, value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[Y + 1][X + 1];
        height = new int[Y + 1][X + 1];
        value = new int[Y+1][X+1];
        for (int i = 1; i <= Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= X; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = -1;
                value[i][j] = -1;
            }
        }
        value[1][1] = 1;
        System.out.println(dp(X,Y));
    }

    static long dp(int a, int b) {
        int sum = 0;
        if (value[b][a]!=-1) return value[b][a];
        if (a + 1 <= X && map[b][a+1] == -1 && height[b][a+1] > height[b][a]) {
            map[b][a + 1] = 0;
            sum += dp(a + 1, b);
            map[b][a + 1] = -1;
        }
        if (a - 1 >= 0 && map[b][a-1] == -1 && height[b][a-1] > height[b][a]) {
            map[b][a-1] = 0;
            sum += dp(a - 1, b);
            map[b][a-1] = -1;
        }
        if (b + 1 <= Y && map[b+1][a] == -1 && height[b+1][a] > height[b][a]) {
            map[b+1][a] = 0;
            sum += dp(a, b+1);
            map[b+1][a] = -1;
        }
        if (b-1 >= 0 && map[b-1][a] == -1 && height[b-1][a] > height[b][a]) {
            map[b-1][a] = 0;
            sum += dp(a, b-1);
            map[b-1][a] = -1;
        }
        return value[b][a] = sum;
    }
}
