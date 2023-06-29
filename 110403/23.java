import java.io.*;
import java.util.*;

class Main {
	
	final static int N_MAX = 1000;
	

	public static int spendTime(int n, int[] arr){
		int total = 0;
		int worker1 = arr[0];
		int worker2 = arr[1]; // 제일 작은 두 값을 왔다갔다 할 떄 사용함.
		if(worker1 + arr[n-2] < 2 * worker2){		//두 방식 중에 하나 결정.
			// 제일 작은 값이 그 외 값과 왔다 갔다함.
			if(n==1)
				total = worker1;
			else if(n==2)
				total = worker2;
			else if(n==3)
				total = worker2 + worker1 + arr[n-1];
			else
				total = worker1 * 2 + arr[n-1] + arr[n-2] + spendTime(n-2, arr);
			return total;
		}
		else{
			// 두 일꾼을 보내고, worker1이 돌아온후, 큰 값 두개 건너기, 그후 worker2가 건너와 다시 worker1과 건넘.
			if(n==1)
				total = worker1;
			else if(n==2)
				total = worker2;
			else if(n==3)
				total = worker2 + worker1 + arr[n-1];
			else
				total = worker2 + worker1 + arr[n-1] + worker2 + spendTime(n-2, arr);
			return total;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] spend = new int[N_MAX];
		int test = input.nextInt();
		int way1, way2;
		for(int i = 0; i < test; i++){
			
			for(int j = 0; j < N_MAX; j++)
				spend[j] = 101;
			
			int n = input.nextInt();
			for(int j = 0; j < n; j++)
				spend[j] = input.nextInt();
			Arrays.sort(spend);
			if (i>0)
				System.out.println();
			System.out.println(spendTime(n,spend));
		}
		input.close();
	}
}