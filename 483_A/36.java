import java.util.*;
import java.math.*;
public class fuck {
	public static int[] a;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long r = input.nextLong();
		long l = input.nextLong();
		if((l - r + 1) < 3){
			System.out.println(-1);
		}
		else
		{
			if(r % 2 == 0)
				System.out.println(r + " " + (r +1)+ " " + (r+2) );
			else{
				if(l -r + 1 >3){
					++r;
					System.out.println(r + " " + (r +1)+ " " + (r+2) );
					}
				else
					System.out.println(-1);
			 }
			}
	}
}
