import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			long a = sc.nextInt();
			long b = sc.nextInt();
			long tmp = 0;
			System.out.printf("%d %d ", a, b);
			
			if(a>b){
				tmp = a;
				a = b;
				b = tmp;
			}
			long cnt;
			long cntMax = 0;
			
			for(long i = a ; i <= b ; i++){
				long j = i;
				cnt = 1;
				while(j != 1){
					if((j & 1) == 1){
						j = 3 * j + 1;
						cnt++;
					}
					while((j & 1) != 1){
						j >>= 1;
						cnt++;
					}
					
				}
				
				
				if(cntMax < cnt){
					cntMax = cnt;
				}
			}
			System.out.printf("%d\n", cntMax);
		}
	}
}