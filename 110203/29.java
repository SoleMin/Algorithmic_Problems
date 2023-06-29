import java.util.Scanner;
class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();  //테스트케이스
		
		for(int i = 0; i < test; i++){
			int day = scanner.nextInt(); //날짜
			int n = scanner.nextInt();	//정당수
			int p[] = new int[n]; 	//동맹휴업지수
			
			for(int j = 0; j < n; j++)
				p[j] = scanner.nextInt();
			
			int count = 0;
			
			for(int j = 1; j <= day; j++){
				if((j-1) % 7 < 5)
					for(int k =0; k < n; k++)
						if(j % p[k] == 0){	//나누어 떨어지면 count 1씩증가
							count++;
							break;
						}
			}
			System.out.println(count);
		}
		
	}
}