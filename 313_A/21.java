import java.util.*;

public class Bank{
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int in = reader.nextInt();
		int sign = (int)Math.signum(in);
		
		String str = Math.abs(in)+"";
		if(str.length() == 1){
			if(in < 0)
				System.out.println(0);
			else
				System.out.println(in);
			return;
		}
		
		int max = in;
		max = Math.max(max, sign * Integer.parseInt(str.substring(0,str.length()-1)));
		max = Math.max(max, sign * Integer.parseInt(str.substring(0,str.length()-2) + str.charAt(str.length()-1)));
		System.out.println(max);
	}
}
