import	java.util.*;
public	class	Main{
	public	static	void	main(String[]args){
		Scanner	cin=new	Scanner(System.in);
		long	z=cin.nextLong()-1<<1,n=cin.nextInt(),l=-1,r=1+n,m;
		while(l<(m=l+r>>1))	if(z>(m+n-1)*(n-m))	r=m;else	l=m;
		if(0<l)	l=n-l;
		System.out.print(l);
	}
}
