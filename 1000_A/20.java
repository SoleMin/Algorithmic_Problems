import java.util.*;
public class q1
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] arr1=new int[9];
		int[] arr2=new int[9];
		String ss;
		s.nextLine();
		for(int i=0;i<n;i++)
		{
			ss=s.nextLine();
			if(ss.equals("M"))
				arr1[0]++;
			else if(ss.equals("S"))
				arr1[1]++;
			else if(ss.equals("L"))
				arr1[2]++;
			else if(ss.equals("XS"))
				arr1[3]++;
			else if(ss.equals("XL"))
				arr1[4]++;
			else if(ss.equals("XXS"))
				arr1[5]++;
			else if(ss.equals("XXL"))
				arr1[6]++;
			else if(ss.equals("XXXS"))
				arr1[7]++;
			else if(ss.equals("XXXL"))
				arr1[8]++;
		}	
		for(int i=0;i<n;i++)
		{
			ss=s.nextLine();
			if(ss.equals("M"))
				arr2[0]++;
			else if(ss.equals("S"))
				arr2[1]++;
			else if(ss.equals("L"))
				arr2[2]++;
			else if(ss.equals("XS"))
				arr2[3]++;
			else if(ss.equals("XL"))
				arr2[4]++;
			else if(ss.equals("XXS"))
				arr2[5]++;
			else if(ss.equals("XXL"))
				arr2[6]++;
			else if(ss.equals("XXXS"))
				arr2[7]++;
			else if(ss.equals("XXXL"))
				arr2[8]++;
		}	
		int min;
		for(int i=0;i<9;i++)
		{
			if(arr1[i]<arr2[i])
				min=arr1[i];
			else
				min=arr2[i];
			arr1[i]-=min;
			arr2[i]-=min;
		}
		int sum=0;
		for(int i=0;i<9;i++)
		{
			sum+=arr1[i];
		}
		System.out.println(sum);
		//System.out.println(Arrays.toString(arr2));
	}
}