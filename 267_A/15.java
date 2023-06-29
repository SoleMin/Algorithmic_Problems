import java.util.Scanner;

public class Subtractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t--!=0){
			int a=s.nextInt();
			int b=s.nextInt();
			int min=Math.min(a, b);
			int max=Math.max(a, b);
			int ops=0;
			while(true){
				int quo=max/min;
				ops+=quo;
				int rem=max%min;
				max=Math.max(rem, min);
				min=Math.min(min, rem);
				if(rem==0) break;
			}
			System.out.println(ops);
		}
	}

}
