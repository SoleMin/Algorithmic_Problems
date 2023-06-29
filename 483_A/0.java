import java.util.*;
public class UserInput {

	

	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()) {
    long r = sc.nextLong();
   long l = sc.nextLong();
   if(l-r <=1) {
	   System.out.println(-1);
   }
   else {
	   if(l-r == 2) {
		   if(r%2 !=0) {
			   System.out.println(-1);
		   }
		   else {
			   System.out.println(r +" "+ (r+1) +" "+l);
		   }
			   
	   }
	   else {
		   if(r%2 == 0) {
			   System.out.println(r+" "+(r+1) +" "+(r+2));
		   }
		   else {
			   System.out.println((r+1)+" "+(r+2)+" "+(r+3));
		   }
	   }
   }

	}
	}     
       
}