import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String a, b, temp;
		char aa[], bb[], cc[];
		
		while(sc.hasNextLine()) {
			a = sc.nextLine();
			b = sc.nextLine();
			
			//a에 짧은 단어가 오도록
			if(a.length() > b.length()) {
				temp = b;
				b = a;
				a = temp;
			}
			
			aa = a.toCharArray();
			bb = b.toCharArray();
			Arrays.sort(aa); Arrays.sort(bb);
			
			cc = new char[aa.length];
			int index = 0;
			fa: for(int i=0; i<aa.length; i++) {
				for(int j=0; j<bb.length; j++) {
					if(aa[i] == bb[j] && aa[i]!='*') {
						cc[index] = bb[j];
						aa[i] = '*';
						bb[j] = '*';
						index++;
						continue fa;
					}
				}
			}
			
			for(int i=0; i<index; i++) {
				System.out.print(cc[i]);
			}
			System.out.println();
		}
		
		sc.close();
	}
}