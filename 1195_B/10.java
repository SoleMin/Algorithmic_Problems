import java.util.*;
import java.io.*;
public class cf5722{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long k=Long.parseLong(st.nextToken());
		
		long ans=((-3-(long)Math.sqrt(9+4*(1*2*(n+k))))/2);
		long ans1=((-3+(long)Math.sqrt(9+4*(1*2*(n+k))))/2);
		if(ans>0)
			System.out.println(n-ans);
		else{
			System.out.println(n-ans1);
		}


	}
}