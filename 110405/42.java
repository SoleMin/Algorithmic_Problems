import java.util.*;

public class Main{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0 ; i < tc ; i++){
			sc.nextLine();
			
			int shoesNum = sc.nextInt();
			sc.nextLine();
			
			int[] ti = new int[shoesNum];
			int[] pi = new int[shoesNum];
			
		//버블 정렬 후에 arr에 넣음. arr는 최종 출력용. 신발 개수 만큼이니까 shoesNum의 길이만큼의 배열
			int[] arr = new int[shoesNum];
			
			//여기 입력값들 저장.
			for(int j = 0 ; j < shoesNum ; j++){
				ti[j] = sc.nextInt();
				pi[j] = sc.nextInt();
			}
			for(int j = 0 ; j < shoesNum ; j++){
				arr[j] = j;
			}
			
			bubbleSort(shoesNum, arr, ti, pi);
			
			for(int j = 0 ; j < shoesNum ; j++){
				System.out.print((arr[j] + 1) + " ");
			}
			System.out.println();
			System.out.println();
			
		
	}
		
	}
		
	public static void bubbleSort(int shoesNum, int[] arr, int[] ti, int[] pi){
			for(int y = 1 ; y < shoesNum ; y++){
				for(int x = 0 ; x < shoesNum - y ; x++){
					//ti * pi끼리의 크기 비교. (크로스로 곱했을 때)
					if(ti[arr[x]] * pi[arr[x+1]] > ti[arr[x+1]] * pi[arr[x]]){
						//tmp를 이용하여 arr를 sorting
						int tmp = arr[x];
						arr[x] = arr[x+1];
						arr[x+1] = tmp;
					}
				}
			}
		}
}