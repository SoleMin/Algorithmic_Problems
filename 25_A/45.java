import java.util.*;

public class a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) a[i] = in.nextInt()%2;
		
		int z = 0;
		for(int i=0;i<n;i++) z+=(a[i] == 0)?1:0;
		if (z == 1) z = 0;
		else z = 1;
		
		for(int i=0;i<n;i++)
			if (a[i] == z){
				System.out.println(i+1);
				break;
			}
	}

}
