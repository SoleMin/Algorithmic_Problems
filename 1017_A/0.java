import java.util.*;

public class sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		int firstSum=0;
		 for(int i=0;i<4;i++) {
			 firstSum+=sc.nextInt();
		 }
		 int count=0;
		for (int i = 1; i < n; i++) {
			int sum =0;
			for (int j = 0; j < 4; j++) {
				sum += sc.nextInt();
			}
			if(sum>firstSum) count++;
		}
		System.out.println(count + 1);}
    
}
		