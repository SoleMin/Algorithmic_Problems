import java.util.Arrays;
import java.util.Scanner;

public class Substrings_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = in.next();
		}
		int count = 1;
		if (n > 1) {
			for (int h=0;h<n;h++){
				for (int g=h+1;g<n;g++){
					if (str[h].length()>str[g].length()){
						String temp=str[h];
						str[h]=str[g];
						str[g]=temp;
					}
				}
			}
			
			for (int j = 0; j < n-1; j++) {
				for (int k = 0; k < str[j + 1].length(); k++) {
					
					if (str[j].charAt(0) == str[j + 1].charAt(k) ) {
						
						if (str[j + 1].startsWith(str[j], k)) {
							count++;
							break;
						}
					}
				}
			}
		}
		if (count==n){
			System.out.println("YES");
			for (int j=0;j<n;j++)
				System.out.println(str[j]);
		}
		else 
			System.out.println("NO");
		
	}

}