import java.util.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n;
		n = cin.nextInt();
		String s = cin.next();
		int ans = n;
		int cntH = 0,cntT = 0;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='H')cntH++;
		}
		cntT = n - cntH;
		for(int i=0;i+cntH<n;i++)
		{
			int tmp = 0;
			for(int j=i;j<i+cntH;j++)
				if(s.charAt(j)=='T')tmp++;
			if(ans>tmp)ans = tmp;
		}
		for(int i=0;i+cntT<n;i++)
		{
			int tmp = 0;
			for(int j=i;j<i+cntT;j++)
				if(s.charAt(j)=='H')tmp++;
			if(ans>tmp)ans = tmp;
		}
		System.out.println(ans);
	}

}
