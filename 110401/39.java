import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//친척 수, 번지수, 중간 인덱스 1, 2, 거리 총합 1, 2
		int r, family[], median, plus, distance1, distance2;
		int tc = sc.nextInt();
		
		for(int t=0; t<tc; t++) {
			r = sc.nextInt();
			family = new int[r];
			for(int i=0; i<r; i++)
				family[i] = sc.nextInt();
			Arrays.sort(family);
			
			if(r>=2) {
				median = r/2 - 1; plus = median+1;
			} else {
				median = 0; plus = 0;
			}
			distance1 = 0; distance2 = 0;
			for(int i=0; i<r; i++) {
				distance1 += Math.abs(family[i] - family[median]);
				distance2 += Math.abs(family[i] - family[plus]);
			}
			
			if(distance1 < distance2)
				System.out.println(distance1);
			else
				System.out.println(distance2);
		}
		
		sc.close();
	}
}