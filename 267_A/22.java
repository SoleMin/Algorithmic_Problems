import java.util.Scanner;


public class Subtractions {
	
	
	
	
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
			long a=sc.nextLong();
			long b=sc.nextLong();
			long count=0;
			long cnt=0;
			while(a>0&&b>0){
				count=0;
				//System.out.println(a+" "+b);
			if(a>b){
			count+=(a-b)/b;
			if(count!=0){
			cnt+=count;
			a-=b*count;}
			else {
				cnt++;
				a-=b;
			}
			}
			else{ 
				count+=(b-a)/a;
				if(count!=0){
				cnt+=count;
			b-=a*count;}
				else {
					cnt++;
					b-=a;
				}
			}
			}
		System.out.println(cnt);
		}
		
		
		
	}

}
