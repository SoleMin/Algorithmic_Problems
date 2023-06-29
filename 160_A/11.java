
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class a implements Comparable<a>{
    
    int x, y, id;
    
    //static BufferedReader in;
    //static StringTokenizer st;
    
    public a(int x1, int y1, int id1){
        this.x = x1; this.y = y1; this.id = id1;
    }
    
    public int compareTo(a o) {
        return x - o.x;
    }
    
    static int n;
    static int arr[];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //in = new BufferedReader(new InputStreamReader(System.in));
        //st = new StringTokenizer(""," ");
        int n = in.nextInt();
        arr = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
            sum +=arr[i];
        }
        Arrays.sort(arr);
        int sum2= 0;
        int ans = 0;
        for (int i=n-1; i>=0; i--){
            sum2+=arr[i];
            //System.out.println(sum2 + " " + sum);
            if (sum2>sum-sum2){
                ans = n - i;
                break;
            }
        }
        System.out.println(ans);
    }
}

