import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt != 0){
			
			int days = Integer.parseInt(br.readLine());
			int party = Integer.parseInt(br.readLine());
			int h[] = new int[party];
			for(int i = 0; i<h.length; i++)
				h[i] = Integer.parseInt(br.readLine());
			
			int hartals = 0;
			
			ArrayList<Integer> ha = new ArrayList<Integer> ();
			for(int i = 0; i<=days; i++){
				if((i+1)%7==0 || i%7 ==0)
					continue;
				for(int j=0; j<h.length; j++){
					if(i%h[j] == 0){
						if(ha.contains(i) == true)
							continue;
						ha.add(i);
						hartals++;
					}
				}
			}
			cnt--;
			System.out.println(hartals);
		}
	}
}