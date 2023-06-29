
import java.util.Scanner;


public class Flatwile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] c = new int[n];
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            c[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }
        sort(c, a);
        int res = 1;
        double prev = Integer.MIN_VALUE;
        for(int i=0; i<c.length; i++){
            if (c[i]-a[i]/2d - prev >=t){
                res++;
            }
            if (i!=c.length-1 && c[i+1]-a[i+1]/2d-(c[i]+a[i]/2d)>t ){
                res++;
            }
            prev = c[i] +a[i]/2d;
        }
        System.out.println(res);
    }

    private static void sort(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if (a[i]>a[j]){
                    swap(a, i, j);
                    swap(b, i, j);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
