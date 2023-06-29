import java.util.*;
 public  class  AA{
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
		    int t=0;
		    if(sc.hasNextInt()) {
		    	t=sc.nextInt();
		    }
		    while(t>0) {
		    	t--;
				 int n=sc.nextInt();
				 String ans="NO";
				 if(n%2==0) {
					 int p=n/2;
					 if(Math.ceil(Math.sqrt((double)p)) == Math.floor(Math.sqrt((double)p))){
						 ans="YES";
					 }
					 else {
						 if(n%4==0) {
							 p=n/4;
							 if(Math.ceil(Math.sqrt((double)p)) == Math.floor(Math.sqrt((double)p))){
								 ans="YES";
							 }
						 }
					 }
				 }
				 System.out.println(ans);
		    }
		}
  }