
import java.util.*;
import java.util.Scanner;

public class Def {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-->0) {
			
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = s.nextInt();
			}

//			int deep = 0;
//			System.out.println(n+"     n");
			List<Integer> al = new ArrayList<>();
			al.add(1);
			System.out.println(1);
			for(int i=1; i<n;i++) {
				int len = al.size();
//				for (int d =0; d<len; d++) {
//					System.out.print(al.get(d)+" ");
//				}
//				System.out.println();
				if (arr[i] == 1) {
					for(int j=0; j<len; j++) {
						System.out.print(al.get(j)+".");
					}
					System.out.println(1);
					al.add(1);
				}else if (arr[i] == arr[i-1] && arr[i]==1) {
					
					for(int j=0; j<len; j++) {
						System.out.print(al.get(j)+".");
					}
					System.out.println(1);
					al.add(1);
				}else {
					for (int j=len-1; j>-1; j--) {
						if (al.get(j)+1 == arr[i]) {
							for(int k=0; k<j; k++) {
								System.out.print(al.get(k)+".");
							}
							System.out.println(arr[i]);
							al.set(j, al.get(j)+1);
							al.subList(j+1, len).clear();
							break;
						}
					}
				}
			}
			
		}
		s.close();
		

	}

}
