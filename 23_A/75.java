import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		String str;
		int i,j,k;
		int cnt = 0;
		char [] strArray;
		
		str = cin.next();
		strArray = str.toCharArray();
		
		for(i = 0; i < strArray.length; i ++)
			for(j = i + 1; j < strArray.length; j ++)
			{
				for(k = 0; (((i + k) < strArray.length && (j + k) < strArray.length) && (strArray[i + k] == strArray[j + k])); k ++)
					if(k + 1> cnt) cnt = k + 1;
			}
		
		System.out.println(cnt);
	}
}
			 		 	 	 	  	  	 	 		 	