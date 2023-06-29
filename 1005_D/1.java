import java.util.*;

public class CodeForces1005D{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String ss = input.next();
		int sum = 0;
		int ans = 0;
		int t = 0;
		for(int i = 0;i<ss.length();i++)
		{
			if((sum+ss.charAt(i))%3==0||ss.charAt(i)%3==0||t==2)
			{
				ans++;
				t=0;
				sum=0;
			}
			else
			{
				t++;
				sum+=ss.charAt(i);
			}
		}	
		System.out.println(ans);
	}
}