import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextLine())
		{
			String s1 = scan.nextLine();
			String s2 = scan.nextLine();
			int len1 = s1.length();
			int len2 = s2.length();
			List<Character> result = new ArrayList<Character>();
			
			// 공통 문자 찾기.
			boolean[] check = new boolean[len2];
			for(int i = 0; i < len1; i++)
			{
				for(int j = 0; j < len2; j++)
				{
					if(!check[j])
					{
						if(s1.charAt(i) == s2.charAt(j)) {
							result.add(s1.charAt(i));
							check[j] = true;
							break;
						}
					}
				}
			}
			
			// 정렬
			for(int i=0; i < result.size()-1; i++)
			{
				int max = i;
				for(int j=i + 1; j < result.size(); j++)
				{
					if(result.get(max) <= result.get(j)) max = j;
				}
				Collections.swap(result, i, max);
			}
			
			for(int i=result.size()-1; i >= 0; i--)
				System.out.print(result.get(i));
			
			System.out.println();
		}
	}
}