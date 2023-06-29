import java.io.*;
import java.util.*;

public class A {
	
	int n;
	
	void run()throws IOException{
		Scanner sc = new Scanner(new InputStreamReader(System.in));		
		n = sc.nextInt();
		int i,tmp,even,odd,e,o;
		even=odd=e=o=0;
		for(i=1;i<=n;i++){
			tmp = sc.nextInt();
			if(tmp%2==0){
				e++;
				if(even==0) even=i;
			} else{
				o++;
				if(odd==0) odd=i;
			}
		}
		if(e>1) System.out.println(odd);
		else System.out.println(even);
	}
	
	public static void main(String[] args)throws IOException {
		new A().run();
	}
}
