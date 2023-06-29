//package mainover;

import java.util.*;
public class codeforce {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		List<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			arr.add(scan.nextInt());
		}
		Collections.sort(arr);
		System.out.println(arr.get(arr.size()-a)-arr.get(arr.size()-a-1));
		scan.close();
	}

}
