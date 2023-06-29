import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Main {
		static List<Integer> list;
	
	
	static void kmp(String t, String p)
	{
		int cnt = 0;
		int[] arr = makeArr(p);
		for(int i = 0; i < t.length(); i++)
		{
			while(cnt > 0 && t.charAt(i) != p.charAt(cnt))
			{
				cnt = arr[cnt - 1];
			}


			if(t.charAt(i) == p.charAt(cnt))
			{
				if(cnt + 1 == p.length())
				{					
					list.add(i - p.length() + 2);
					cnt = arr[cnt];
				}
				else
					cnt++;
			}
		}
	}

	static int[] makeArr(String text)
	{
		int cnt = 0;
		
		int[] arr = new int[text.length()];
		
		for(int i = 1; i < text.length(); i++)
		{
			while(cnt > 0  && text.charAt(i) != text.charAt(cnt))
			{
				cnt = arr[cnt - 1];
			}
			
			if(text.charAt(i) == text.charAt(cnt))
				arr[i] = ++cnt;
		}
		
		return arr;
		
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String t = sc.nextLine();
		String p = sc.nextLine();
	
		list = new ArrayList<Integer>();		
		
		kmp(t, p);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
			

		sc.close();
	}

}