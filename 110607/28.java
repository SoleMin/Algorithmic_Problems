import java.util.Scanner;

class Main {
	
	//n번째 인덱스 값 = 숫자 n이 마지막으로 나타난 순서
	static int sidx[] = new int[70000];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int here = 0, n; //마지막 저장 위치
		
		sidx[1] = 1;	sidx[2] = 3;
		sidx[3] = 5;	sidx[4] = 8;
		here = 8;
		
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			
			if(n > here) { setSeq(here, n); }
			
			System.out.println(search(n));
		}
		
		sc.close();
	}
	
	//다음 숫자 위치 치정
	static void setSeq(int here, int n) {
		int i = here;
		int v = search(i);
		while(true) {
			sidx[v+1] = sidx[v] + search(v+1);
			if(i > n) break;
			i = sidx[v+1];
			v++;
		}
	}
	
	//저장된 인덱스를 참고해 인덱스 값 찾기
	static int search(int x) {
		int value = 0;
		for(int i=0; i<sidx.length; i++) {
			if(sidx[i] >= x) {
				value = i;
				break;
			}
		}
		return value;
	}
}