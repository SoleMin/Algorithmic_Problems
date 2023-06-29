import java.util.*;
public class A {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		long l = sc.nextLong();
		long h = sc.nextLong();
		
		sc.close();
		
		if(h-l<2) {
			System.out.println(-1);
			return ;
		}
		
		if(h-l==2 && l%2==1) {
			System.out.println(-1);
			return ;
		}
		
		if(l%2==1) {
			++l;
		}
		
		System.out.printf("%d %d %d\n",l,l+1L,l+2L);
	}

}
