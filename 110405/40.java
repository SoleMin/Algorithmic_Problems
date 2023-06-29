import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int ts = scan.nextInt();
		
		
		for(int i = 0; i < ts; i++)
		{
			Map<Integer, Float> map = new HashMap<Integer, Float>();
			int work = scan.nextInt();
			float[] t = new float[work];
			float[] s = new float[work];
			for(int m=0; m<work; m++) {
				t[m] = scan.nextFloat();
				s[m] = scan.nextFloat();
			}
			scan.nextLine();
			for(int z = 0; z<work; z++) map.put(z+1, t[z]/s[z]);
			LinkedList<Map.Entry<Integer, Float>> entryList = new LinkedList<>(map.entrySet());
			entryList.sort(Map.Entry.comparingByValue());
			
			// for(int j=0; j<work-1; j++)
			// {
			// 	System.out.println(s[j]/t[j]);
			// 	System.out.println(s[j+1]/t[j+1]);
			// 	int idx1 = result[j];
			// 	int idx2 = result[j+1];
			// 	if((s[idx1] / t[idx1]) < (s[idx2] / t[idx2]))
			// 	{
			// 		temp = result[j];
			// 		result[j] = result[j+1];
			// 		result[j+1] = temp;
			// 	}
			// }
			int k;
			for(k=0; k<work-1; k++)
				System.out.print(entryList.get(k).getKey() + " ");
			System.out.println(entryList.get(k).getKey());
			System.out.println();
		}
	}
}