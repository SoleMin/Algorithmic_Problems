import java.io.*;
import java.util.*;

public class practice {

		public static void main(String[] args) throws FileNotFoundException {			
			Scanner scn = new Scanner(new FileReader("input.txt"));
			PrintWriter out = new PrintWriter(new File("output.txt"));
		 int n=scn.nextInt(),m=scn.nextInt(),k=scn.nextInt();
		 int[][] inf=new int[k][2];
		 for(int i=0;i<k;i++){
			 inf[i][0]=scn.nextInt();inf[i][1]=scn.nextInt();
		 }
		 int ans=0,x=1,y=1;
		 for(int i=1;i<=n;i++){
			 for(int j=1;j<=m;j++){
				 int temp=Integer.MAX_VALUE;
				 for(int l=0;l<k;l++){
					temp=Math.min(temp, Math.abs(i-inf[l][0])+Math.abs(j-inf[l][1])); 
				 }
				 if(temp>ans){
					 ans=temp;x=i;y=j;
				 }
			 }
		 }
		 out.print(x+ " " + y);
	   	 out.close();
		}
	}

