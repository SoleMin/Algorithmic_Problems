
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String [] str = new String[n];
		for(int i=0; i<n; i++) {
			str[i] = sc.nextLine();
		}
		boolean flag1, flag2;
		for(int i=0; i<n; i++) {
			flag2 = true;
			for(int j=0; j<m; j++) {
				if(str[i].charAt(j)=='1') {
					flag1 = false;
					for(int k=0; k<n; k++) {
						if(str[k].charAt(j)=='1' && k!=i) {
							flag1 = true;
							break;
						}
					}
					if(!flag1) flag2 = false;
					
				}
			}
			if(flag2) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		return;
	}
	
}

				  	  						 			  	  	  		 	