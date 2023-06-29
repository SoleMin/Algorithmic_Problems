import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int caseN = sc.nextInt();	// 케이스 개수
		int sum;	// 걸린 시간
		for (int c = 0; c < caseN; c++) {
			sc.nextLine();
			sum = 0;
			int n = sc.nextInt();	// 사람 수
			int [] speed = new int [n];	// 각 사람들의 속도
			for (int i = 0; i < n; i++) {
				speed[i] = sc.nextInt();
			}
			Arrays.sort(speed);
			List<Integer> bf = new ArrayList<>();
			List<Integer> af = new ArrayList<>();
			
			for (int i = 0 ; i < n; i ++) {
				bf.add(speed[i]);
			}
/*			
			int tmp = 0;
			for (int i = 0; i < 2; i++){
				tmp = bf.remove(0);
				if (i ==1)sum += tmp;
				af.add(tmp);
			}
			Collections.sort(af);
			
			tmp = af.remove(0);
			sum += tmp;
			bf.add(tmp);
			Collections.sort(bf);
	*/		
			while (bf.isEmpty() == false) {
				int tmp = 0;
				if (bf.size() == 2) {
					sum += bf.get(1);
					break;
				} else if (bf.size() == 1){
					sum += bf.get(0);
					break;
				}
				if (bf.get(0) + bf.get(1)+ bf.get(1) + bf.get(bf.size() -1) <
					 bf.get(0) + bf.get(bf.size() -1) + bf.get(0) + bf.get(bf.size() -2)) {
					// 건너기, 속도가 빠른 사람 두 명
					for (int i = 0; i < 2; i ++) {
						tmp = bf.remove(0);
						if (i == 1) sum += tmp;
						af.add(tmp);
					}
					Collections.sort(af);
					if (bf.isEmpty() == true) break;
					// 다리를 건넌 사람 중 가장 속도가 빠른 사람이 돌아온다.
					tmp = af.remove(0);
					sum += tmp;
					bf.add(tmp);
					Collections.sort(bf);
					// 건너기, 속도가 느린 사람 두 명
					for (int i = 0; i< 2; i ++) {
						tmp = bf.remove(bf.size()-1);
						if (i == 0) sum += tmp;
						af.add(tmp);
					}	
					Collections.sort(af);
					
					if (bf.isEmpty() == true) break;
					
					// 다리를 건넌 사람 중 가장 속도가 빠른 사람이 돌아온다.
					tmp = af.remove(0);
					sum += tmp;
					bf.add(tmp);
					Collections.sort(bf);
				}
				else {
					for (int i = 0 ; i< 2; i ++) {
						// 제일 빠른 사람과 제일 느린 사람
						tmp = bf.remove(0);
						af.add(tmp);
						tmp = bf.remove(bf.size()-1);
						sum += tmp;
						af.add(tmp);
						
						Collections.sort(af);
						
						if (bf.isEmpty() == true) break;
						
						// 다리를 건넌 제일 빠른 사람이 돌아온다.
						
						tmp = af.remove(0);
						sum += tmp;
						bf.add(tmp);
						Collections.sort(bf);
					}
				}
			}
			System.out.println(sum);
			System.out.println();
		}
	}
}