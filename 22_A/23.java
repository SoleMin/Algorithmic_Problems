import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    int[] a = new int[n];
	    for(int i=0;i<n;i++)
	        a[i] = s.nextInt();
	    Arrays.sort(a);
	    int min = a[0];
	    if (a[0] == a[n-1]){
	        System.out.println("NO");
	    }else{
	        for(int i=1;;i++){
	            if (a[i] > min) {
	                System.out.println(a[i]);
	                break;
	            }
	        }
	    }
	}

}
