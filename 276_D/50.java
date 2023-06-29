import java.util.*;



public class Code {
	public Code(){}
	public static void main(String args[]){
		Scanner QQQ=new Scanner(System.in);
		long l=QQQ.nextLong();
		long r=QQQ.nextLong();
		long ans=l^r;
		int a[]=new int [70];
		int b[]=new int [70];
		int n=0,m=0;
		while (l!=0){
			a[m]=(int)(l%2);
			l/=2;
			m++;
		}
		while (r!=0){
			b[n]=(int)(r%2);
			r/=2;
			n++;
		}
		m--;n--;
		long deg[]=new long [70];
		deg[0]=1;
		for (int i=1;i<=62;i++) deg[i]=deg[i-1]*2;
		for (int i=n;i>=0;i--) 
			if (b[i]==1&&a[i]==0){
				System.out.println(deg[i+1]-1);
				return;
			}
		System.out.println(ans);
	}
}