import java.util.*;
public class maximus {
	static long GCD(long a,long b){
	if(b==0)return a;
	return GCD(b,a%b);	
	}
public static void main(String [] args){
  Scanner in=new Scanner(System.in);
  long n=in.nextInt();
  if(n<=2){
  System.out.print(n);
  return;	
  }
  if(n%2==1){
  System.out.print((n*(n-1)*(n-2)));
  return;
  }
  if(n%2==0 && n<=6){
  System.out.print(n*(n-1)*(n-2)/2);
  return;	
  }
  long temp=(n*(n-1)*(n-3))/GCD(n,n-3);
  System.out.print(Math.max((n-1)*(n-2)*(n-3),temp));
  }
}