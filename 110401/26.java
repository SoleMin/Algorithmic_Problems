import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] s;
		int cases, n, i, home, home_d, dis = 0;
		
		cases = input.nextInt();
		while(cases-- > 0){
			n = input.nextInt();
			s = new int[n];
			
			for(i = 0; i < n; i++)
				s[i] = input.nextInt();
			Arrays.sort(s);
			
			home_d = n/2;
			home = s[home_d];
			for(i = 0; i < home_d; i++)
				dis += Math.abs(home - s[i]);
			for(i = home_d; i < n; i++)
				dis += Math.abs(home - s[i]);
			
			System.out.println(dis);
			dis = 0;
		}
	}
}