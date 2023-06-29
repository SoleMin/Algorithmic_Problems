import java.util.Scanner;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int family, place, distance;
		int[] address;
		int[] min = new int[testCase];
		
		for (int i=0; i<testCase; i++) {
			family = sc.nextInt();	//친척집 개수
			if (family >= 500 || family <= 0) {
				break;
			}
			address = new int[family];	//친척집의 주소
			
			//친척집의 주소 입력받음
			for (int k=0; k<family; k++) {
				address[k] = sc.nextInt();
				if (address[k]>=30000 || address[k]<0) {
					break;
				}
			}
			
			min[i] = Integer.MAX_VALUE;
			for (int k=0; k<family; k++) {
				place = address[k];
				distance = 0;
				for (int h=0; h<family; h++) {
					//두 개의 주소값을 비교해 distance변수에 저장
					distance += Math.abs(place-address[h]);
				}
				//distance가 min보다 작으면 min[testCase 번호]에 저장
				if (min[i] > distance) {
					min[i] = distance;
				}
			}			
		}
		
		for (int i=0; i<testCase; i++) {
			System.out.println(min[i]);
		}
				
		
		sc.close();
	}
}