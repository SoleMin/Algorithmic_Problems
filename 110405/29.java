import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		while(casenum-- > 0){
			scan.nextLine();
			int range = scan.nextInt();
			scan.nextLine();
			
			int t[] = new int[range];
			int s[] = new int[range];
			int r[] = new int[range];
			
			for(int i=0; i<range; i++){
				t[i] = scan.nextInt();
				s[i] = scan.nextInt();
				r[i] = i;
			}
			int temp;
			for(int i = 0; i < range; i++){
				for(int j=0; j < range -1; j++){
					if(t[r[j]] * s[r[j+1]] > t[r[j+1]] * s[r[j]]){
						temp = r[j];
						r[j] = r[j+1];
						r[j+1] = temp;
					}
				}
			}
			for(int i=0; i<range; i++){
				if(i < range - 1){
					System.out.print(r[i] + 1 + " ");
				}
				else{
					System.out.println(r[i] + 1);
					System.out.println();
				}
			}
		}
	}
}