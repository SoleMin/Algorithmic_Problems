import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
	
		// 테스트케이스 수/날짜(7~3500)/정당수(1~100)/정당별 동맹휴업지수
		int test = input.nextInt();
		
		for(int i = 0; i<test; i++){
			int day = input.nextInt(); //날짜
			int num = input.nextInt(); //정당수
			int[] rest = new int[num]; //정당별 동맹휴업 지수
			
			TreeSet<Integer> set = new TreeSet<>(); // 중복X 오름차순 정렬
			
			for(int j = 0; j<num; j++){
				rest[j] = input.nextInt();
				
				for(int x = 1; x<=day; x++){
					if((x%rest[j] == 0) && ((x%7 != 0) && (x%7 != 6)))
						set.add(x);
				}
			}
			System.out.println(set.size());
		}
	}
}