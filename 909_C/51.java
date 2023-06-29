import java.util.Scanner;

public class Solution {
		
	public static void main(String[] args) {
		// Write your code here
      Scanner s=new Scanner(System.in);
	  int n=s.nextInt();
	  char[] seq=new char[n];
	  for(int i=0;i<n;i++){
		  seq[i]=s.next().charAt(0);  
	  }
	  long mod=(long)Math.pow(10,9)+7;
	  long[][] arr=new long[n][n];
	  arr[0][0]=1;
	  for(int i=1;i<n;i++){
		  if(seq[i-1]=='f'){
			  for(int j=1;j<n;j++){
				  arr[i][j]=arr[i-1][j-1];
			  }
		  }else{
			  long sum=0;
			  for(int j=n-1;j>=0;j--){
				  sum=(sum+arr[i-1][j])%mod;
				  arr[i][j]=sum;
			  }
		  }
	  }
	  long ans=0;
	  for(int i=0;i<n;i++){
		  ans=(ans+arr[n-1][i])%mod;
	  }
	  System.out.println(ans);
	}
}