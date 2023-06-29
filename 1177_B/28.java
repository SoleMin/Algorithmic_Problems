import java.io.*;
import java.util.*;
 
public class digits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long temp = 9 * (int)Math.pow(10,0);
        int count = 0;
        long initial = 0;
        while(k > temp) {
            count++;
            initial = temp;
            temp += 9 * (long)Math.pow(10,count)*(count+1);
        }
        long index = (k-initial-1)%(count+1);
        long num = (long)Math.pow(10,count) + (k-initial-1)/(count+1);
        System.out.println((num+"").charAt((int)index));
    }
}