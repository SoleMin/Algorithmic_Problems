import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int bit[];
    static int array[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bit = new int[1505];
        array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= n;i++)
            array[i] = Integer.parseInt(st.nextToken());
        long ans = 0;
        for(int i = n;i >= 1;i--){
            ans += read(array[i]);
            update(array[i]);
        }
        long val = (ans & 1) + 1000_000;
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= m;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long temp = (r - l + 1);
            temp = temp*(temp - 1) / 2;
            if((temp & 1) == 1)--val;
            if((val & 1) == 1)sb.append("odd");
            else sb.append("even");
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static int update(int idx){
        int sum = 0;
        while(idx < 1501){
            bit[idx] += 1;
            idx += idx & (-idx);
        }
        return sum;
    }
    static int read(int idx){
        int sum = 0;
        while(idx > 0){
            sum += bit[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }
}