import java.util.Scanner;


public class BB {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	long a=sc.nextLong();
	long b=sc.nextLong();
	
	if(b-a>(long)2){
		if(a%(long)2==0){
			System.out.print(a+" "+(a+1)+" "+(a+2));
			return;
		}else{
			System.out.print(a+1+" "+(a+2)+" "+(a+3));
			return;
		}
		
	}else{
		if(b-a<=(long)1){
		System.out.println(-1);
		return;
		}
		if(b-a==(long)2){
			if(a%(long)2==0){
				System.out.print(a+" "+(a+1)+" "+(a+2));
				return;
			}else{
				System.out.print(-1);
				return;
			}	
			
			}
	}

}
}
