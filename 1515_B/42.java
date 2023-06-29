import java.util.Scanner;

public class B_14 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int test = 0; test < t; test++){
			int n = input.nextInt();
			if(n % 2 == 0){
				if(Math.sqrt(n / 2) == (int)(Math.sqrt(n / 2))){
					System.out.println("YES");
				}else if(n % 4 == 0 && Math.sqrt(n / 4) == (int)(Math.sqrt(n / 4))){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}else{
				System.out.println("NO");
			}
		}
	}
		
}
