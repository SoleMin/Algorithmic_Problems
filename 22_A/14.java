import java.util.Scanner;


public class prob1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n == 1)
		{
//			throw new RuntimeException();
			int m = input.nextInt();
			System.out.println("NO");
//			System.out.println(input.next());
			return;
		}
		int[] num = new int[n];
		boolean flag  = false;
		for(int i = 0; i < n; i++)
		{
			num[i] = input.nextInt();
			if(num[i] != num[0])
				flag = true;
		}
		if(!flag)
		{
			System.out.println("NO");
			return;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			if(num[i] < min)
				min = num[i];
		int min2 = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			if(num[i] <= min2 && num[i] > min)
				min2 = num[i];
		System.out.println(min2);
		
	}
}
