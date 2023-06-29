import java.util.*;
public class Ex{
	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);       
       int n=sc.nextInt();
       int k=n;
       int r=k;
       int c=0;
       while(n>0){
       	 int rem=n%10;
       	 if(rem==4 || rem==7){
       	 	c++;
       	 	n/=10;
       	 }
       	 else{
       	 	break;
       	 }
       }
       int co=0;
       while(k>0){
       	k/=10;
       	co++;
       }
       if(c==co){
       	System.out.println("YES");
       }
       else if(r%4==0 || r%7==0 || r%47==0 || r%74==0 || r%477==0 || r%774==0 || r%747==0 || r%447==0 || r%474==0 || r%744==0){
       	System.out.println("YES");
       }
       else{
       	System.out.println("NO");
       }
	}
}