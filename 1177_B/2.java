import java.util.*;
public class global{
	public static void main(String s[]){
		Scanner sc = new Scanner(System.in);
			long n = sc.nextLong();
			String st = String.valueOf(n);
			if(st.length()==1){
				System.out.println(n);
			}else{
				long val = 1;
				long prev=9;
				long total=9;
				long late=9;
				for(int i=2;i<=12;i++){
					val*=10;
					
					total+=i*(val*9);
					if(n<=total){
						long diff = n-late;
						long div = diff/i;
						long mod = diff%i;
						
						if(mod==0){
							prev+=div;
							System.out.println((prev)%10);
							break;
						}else{
							prev+=div+1;
							String fg = String.valueOf(prev);
							System.out.println(fg.charAt((int)mod-1));
							break;
						}
					}
					prev+=(9*val);
					late=total;
				}
				
			}			
		
		}
	}
