import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		List <Integer> list;
		int testCase = Integer.parseInt(input.readLine());
		String buf = input.readLine();
		for (int i = 0; i < testCase; i++){
			int index = Integer.parseInt(input.readLine()) -1 ;
			list = new ArrayList<>();
			while((buf = input.readLine()) != null)
				if (buf.isEmpty())
					break;
			else
				list.add(Integer.parseInt(buf));
			list.sort(Comparator.naturalOrder());
			int min, min2, max1, max2, time = 0, tmp1, tmp2;
			while(index >= 3)
			{
				min =list.get(0);
				min2 = list.get(1);
				max1 = list.get(index--);
				max2 = list.get(index--);
				tmp1 = min + max1 + min + max2;
				tmp2 = min2 + min + min2  + max1;
				time += (tmp1 > tmp2)? tmp2: tmp1;
			}
			if (index == 2)
			{
				min = list.get(0);
				max1= list.get(1);
				max2= list.get(2);
				time += min + max1 + max2;
			}
			else if (index == 1)
				time += list.get(1);
			else
				time += list.get(0);
			
			System.out.println(time);
			System.out.println();
		}
	}
}