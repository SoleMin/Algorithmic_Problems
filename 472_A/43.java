import java.util.Scanner;


public class A470 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int n=sc.nextInt();
	
	int start=4;
	
	
	while(true){
		
		if((start%2==0||start%3==0)&&((n-start)%2==0||(n-start)%3==0))
		{
			System.out.println(start+" "+(n-start));
			return;
		}
		else 
		start++;
		
		
		
	}
	
	
		
		
	}
}
