import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		
		int[] a = new int[n+1];		
		int[] d = new int[100001];
		
		int tk = 0;
		int l = 1;
		int r = -1;
		boolean find = false;
		for (int i = 1; i <= n; i++){
			a[i] = scr.nextInt();
			if (d[a[i]] == 0){
				d[a[i]] = 1;
				tk++;
				if ((!find) && (tk == k)){
					find = true;
					r = i;
				} // if 
			} // if
		} // for
		
		
		if (r > 0) {
			int[] cd = new int[100001];
			tk = 0;
			find = false;
			for (int j = r; j >= l; j--){
				if(cd[a[j]] == 0){
					cd[a[j]] = 1;
					tk++;
					if ((!find) && (tk == k)){
						find = true;
						l = j;
						break;
					} // if
				} // if
			} // for
			System.out.println(l + " " + r);
		} // if
		else {
			System.out.println("-1 -1");
		}			

	}

}
