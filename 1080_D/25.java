import java.util.*;
import java.io.*;

public class code {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		long[] d = new long[30];
		d[0] = 1;
		for(int i=1;i<30;i++) d[i] = d[i-1]*4;
		for(int z=0;z<q;z++){
		    long r = 0;
		    long n = sc.nextLong();
		    long k = sc.nextLong();
		    long c = 1;
		    while(k>0&&n>=1){
		        if(k<=r) {
		            k=0;
		            break;
		        }
		        n--;
		        k-=c;
		        if(k<=0) break;
		        
		        
		        if(n>30) {
		            k=0;
		            break;
		        }
		        for(int i=0;i<(int)n;i++){
		            r += d[i]*(c*2-1);
		            if(k<=r) {
		                k=0;
		                break;
		            }
		        }
		        if(k<=r) {
		            k=0;
		            break;
		        }
		        c*=2;
		        c++;
		    }
		    if(k==0) System.out.println("YES "+n);
		    else System.out.println("NO");
		}
	}
}


/*
NO
YES 0
YES 0
NO
NO
YES 999999942
YES 59
YES 63
YES 2
NO
YES 1
YES 1
NO
NO
YES 0
YES 0*/