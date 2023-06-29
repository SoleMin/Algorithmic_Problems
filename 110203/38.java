import java.util.*;
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test_num = sc.nextInt();
		for(int i=0; i<test_num; i++){
			int period = sc.nextInt();
			int party_num = sc.nextInt();
			int buf;
			boolean [] restday = new boolean[period+1];
			int day_count = 0;
			for(int j=0; j<party_num; j++){
				buf = sc.nextInt();
				for(int k=buf; k<=period; k+=buf){
					restday[k] = true;
				}
			}
			for(int j=1; j<=period; j++){
				if(j%7 != 6 && j % 7 != 0){
					if(restday[j]){
						day_count++;
					}
				}
			}
			System.out.println(day_count);
		}
	}
}