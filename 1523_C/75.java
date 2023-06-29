import java.util.*;
import java.io.*;
 
public class uo{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testcases = Integer.parseInt(st.nextToken());
		for(int lmn=0;lmn<testcases;lmn++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			// int k = Integer.parseInt(st.nextToken());
			// st = new StringTokenizer(br.readLine());
			ArrayList<Integer> a = new ArrayList<>();
			for(int lmn1 = 0;lmn1<n;lmn1++){
				st = new StringTokenizer(br.readLine());
				int a1 = Integer.parseInt(st.nextToken());
				if(a.size()>0 && (a1==1)){
					// a.add(a1);
				}
				else if(a.size()>0){
					if(a.size()==1){
						a.remove(0);
					}
					else{
						int i = a.size()-1;
						while(a.size()>0 && i>=0 && a.get(i)+1 != a1){
							a.remove(i);
							i--;
						}
						a.remove(a.size()-1);
						// System.out.println(a+" "+i);

					}
				}
				// while(a.size()>0 && a.get(a.size()-1)+1<a1){
				// 	a.remove(a.size()-1);
				// }
				if(a.size()==0){
					a.add(a1);
				}
				else{
					a.add(a1);
				}
				if(a.size()==1){
					System.out.println(a.get(0));
				}
				else{
					for(int i=0;i<a.size()-1;i++){
						
						System.out.print(a.get(i)+".");
					}
					System.out.println(a.get(a.size()-1));
				}
				

			}
		}
		
	}
}