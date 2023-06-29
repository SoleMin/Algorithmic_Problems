import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[101];
        int[] nums = new int[n+1];
        int colors = 0;
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
            arr[nums[i]] = true;
        }
        Arrays.parallelSort(nums);
        for(int i = 1; i <= n; i++) {
            boolean newColor = false;
            if(!arr[nums[i]]) {
                continue;
            }
            for(int j = nums[i]; j <= 100; j += nums[i]) {
                if(arr[j]) {
                    arr[j] = false;
                    newColor = true;
                }
            }
            if(newColor) {
                colors++;
            }
        }
        
        bw.write(String.valueOf(colors));
        br.close();
        bw.close();
    }
}
