/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong();
		long y=sc.nextLong();
		long ye=sc.nextLong();
		long g=sc.nextLong();
		long b=sc.nextLong();
		long cy=2*ye+g;
		long cb=g+3*b;
		long ans=0;
		if(cy>x)
		ans+=cy-x;
		if(cb>y)
		ans+=cb-y;
		System.out.println(ans);
		
	}
}
