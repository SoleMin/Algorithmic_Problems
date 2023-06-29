

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String str[] = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0){
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0){
                    a[j] = 0;
                }
            }
            k++;
        }
        System.out.println(k);
    }
}
