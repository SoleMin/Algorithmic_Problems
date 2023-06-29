import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int a = kb.nextInt();
        int b = kb.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        Arrays.sort(array);
        int k = 0;
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < b; i++) {
            t1= array[i];
            if(i<n-1){
                t2=array[i+1];
                k=t2-t1;
            }
            else k=0;
        }
        System.out.println(k);

    }
}