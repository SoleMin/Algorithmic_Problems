import java.util.Scanner;


public class P23A {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int max = 0;
		for(int i = 0; i < s.length(); i++)
			for(int k = s.length(); k > max + i; k--)
				if(s.substring(i + 1).contains(s.substring(i,k)))
					max = k - i; 
		System.out.println(max);
	}

}
