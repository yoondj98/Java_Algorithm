package BOJ_10_Sort;
import java.io.*;

public class BOJ_10_2750 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int [] arr = new int [num];

        for(int i=0; i<num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int key,i,j;
        for(j=1; j<=num-1;j++){
            key = arr[j];
            i = j-1;

            while(i>=0 && arr[i]>key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
        for(int a: arr){
            System.out.println(a);
        }
    }
}
