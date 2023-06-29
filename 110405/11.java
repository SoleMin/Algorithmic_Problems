import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int c=input.nextInt();
		for(int i=0; i<c; i++){
			int n=input.nextInt();
			Map<Integer,Double> m = new HashMap<Integer, Double>();
			for(int j=0; j<n; j++){
				int t=input.nextInt();
				int s=input.nextInt();
				m.put(j+1, (double)s/(double)t);
			}
			
			List<Entry<Integer,Double>> list=new ArrayList<>(m.entrySet());
			list.sort(Collections.reverseOrder(Entry.comparingByValue()));
			for(Entry<Integer,Double> x : list){
				System.out.print(x.getKey()+" ");
			}
			System.out.println("\n");
		}
		input.close();
	}
}