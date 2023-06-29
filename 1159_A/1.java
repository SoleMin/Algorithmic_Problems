import java.util.Scanner;

public class _0310Apileofstones {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String input =sc.nextLine();
		boolean flag=false;
		int count=0;
		for(int i=0;i<n;i++) {
			if(input.charAt(i)=='+') {
				flag=true;
				count++;
			}
			if(flag) {
				if(input.charAt(i)=='-') {
					if(count!=0) {
					count--;
					}
				}
			}
		}
		System.out.println(count);
	}

}
