import java.util.Scanner;

public class _0210TheRank {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int thomas=0;int id=1;int sum=0;
		thomas+=sc.nextInt();
		thomas+=sc.nextInt();
		thomas+=sc.nextInt();
		thomas+=sc.nextInt();
		
		for(int i=0;i<n-1;i++) {
			sum+=sc.nextInt();
			sum+=sc.nextInt();
			sum+=sc.nextInt();
			sum+=sc.nextInt();
			if(sum>thomas) {
				id++;
			}
			sum=0;
		}
		System.out.println(id);
		
	}

}
