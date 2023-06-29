import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

/**6,24,35배수 계산 how? 
6이나 7의 배수 계산X -> 삽입할때부터제외
**/

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();
		for(int i =0; i < t; i++) {
			int n = input.nextInt();
			int p = input.nextInt();
			int[] hol = new int[p];
			
			HashSet<Integer> cnt = new HashSet<>();
				
			for(int z =0; z<p; z++) {
				hol[z] = input.nextInt();
				for(int j=hol[z]; j<=n; j+=hol[z]) {
					if(!(j%7 == 0)) {
						cnt.add(j);
					}
				}
				
				for(int h = 6; h<=n; h+=7) {
					if(cnt.contains(h)) {
						cnt.remove(h);
					}
				}
			}	
			
			System.out.println(cnt.size());
		}
		
		/**어떤 자료구조로 구현해야하나 고민 될세...ㅎ**/
		
	}
}