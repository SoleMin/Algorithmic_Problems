import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		long max=0;
		long i=0, j=0; 
		long iOrg=0, jOrg=0;//원본
		int m=0, n=0;
		long i2=0;
		while(input.hasNextLine()){
			max=0;
			String s = input.nextLine();
			for(m=0;m<s.length();m++){
				if(s.charAt(m)==' '){
					i=Long.parseLong(s.substring(0,m));
					j=Long.parseLong(s.substring(m+1));
					iOrg=i;
					jOrg=j;
					if(i>j){
						Long temp=i;
						i=j;
						j=temp;
					}
					break;
				}
			}
			for(i2=i;i2<=j;i2++){
				long j2=i2;
				long k=1;
				while(j2 != 1){
					if(j2 % 2 == 1){
						j2 = 3*j2 + 1;
						k++;
					}
					while(j2 % 2 == 0){
						j2 = j2 / 2;
						k++;
					}
				}
				if(k>max)
					max=k;
			}
			System.out.println(iOrg+" "+jOrg+" "+max);
		}
	}
}