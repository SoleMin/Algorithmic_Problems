
import java.util.Scanner;

public class D {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		String sa = Long.toBinaryString(a);
		String sb = Long.toBinaryString(b);
		long ans = 0;
		if(sb.length()-sa.length()>0){
			for(int i = 0 ; i < sb.length() ; i++){
				ans += 1l<<i;
			}
			System.out.println(ans);
		}
		else{
			int num = -1 ;
			for(int i = 62 ; i >= 0 ; i--){
				if((b & 1l << i) != 0 && ((~a) & (1l << i)) != 0){
					num = i;
					break;
				}
			}
			ans = 0;
			if(num!=-1) for(int i = 0 ; i <= num ; i ++){
				ans += 1l<<i;
			}
			System.out.println(ans);
	}
	}

}