import java.io.*;
import java.util.Scanner;
import java.util.HashSet;
	

/**조심 할 것 수열 하나로 되어있어도 유쾌
스트림도 써도 되고 hashset도 써도 됨**/

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String[] s = input.nextLine().split(" ");
			int num = Integer.parseInt(s[0]);
			int[] s2 = new int[num+1];
			
			for(int i = 0; i<num+1; i++) {
				s2[i] = Integer.parseInt(s[i]);
			}
			
			
			HashSet<Integer> cnt = new HashSet<>();
			if(num==1) {
				System.out.println("Jolly");
			}
			else{
				for(int i =1; i<num; i++) {
					int n = s2[i]-s2[i+1];

					if(n<0) {
						n = -n;
					}

					if(!cnt.contains(n) && (n !=0 && n<=s2[0])) {
							cnt.add(n);
					}
					else {
						System.out.println("Not jolly");
						break;
					}	


					if(i==num-1) {
						for(int j =1; j<num; j++) {
							if(!cnt.contains(j)) {
								System.out.println("Not jolly");
								break;
							}
							else if(j==num-1) {
								System.out.println("Jolly");
							}
						}
					}
				}
			}
			
			
		}
	}
}