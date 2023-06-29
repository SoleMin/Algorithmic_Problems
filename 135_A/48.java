import java.io.*;
import java.util.*;



public class Replacement {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));	
		String s=r.readLine();
		int n=new Integer(s);
		int[]arr=new int[n];
		String[]sp=r.readLine().split("[ ]+");
		for (int i = 0; i < sp.length; i++) {
			arr[i]=new Integer(sp[i]);
		}
		Arrays.sort(arr);
		if(arr[arr.length-1]==1){
			arr[arr.length-1]=2;
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				if(i==n-1){
					System.out.println(arr[i]);
				}else
				System.out.print(arr[i]+" ");
			}
			return;
		}
		arr[arr.length-1]=1;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if(i==n-1){
				System.out.println(arr[i]);
			}else
			System.out.print(arr[i]+" ");
		}
	}
}
