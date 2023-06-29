
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		
		for(int i = 0; i < count; i++) {
			int d1 = input.nextInt();
			int d2 = input.nextInt();
			int d3 = input.nextInt();
			int d4 = input.nextInt();
			Data st = new Data(d1, d2, d3, d4, 0);
			
			int d5 = input.nextInt();
			int d6 = input.nextInt();
			int d7 = input.nextInt();
			int d8 = input.nextInt();
			Data end = new Data(d5, d6, d7, d8, 0);
			
			int[] arr = new int[10000];

			int n = input.nextInt();
			for(int j = 0; j < n; j++) {
				int d9 = input.nextInt();
				int d10 = input.nextInt();
				int d11 = input.nextInt();
				int d12 = input.nextInt();
				arr[new Data(d9, d10, d11, d12, 0).realnum()] = 2;
			}
			
			LinkedList<Data> list = new LinkedList<>();
			list.add(st);
			
			arr[st.realnum()] = 1;
			int[] idxs = new int[] {-1, 1};
			int step = -1;
			while(list.isEmpty() == false) {
				Data d = list.removeFirst();//current data
				if(d.realnum() == end.realnum()) {
					step = d.move;
					break;
				} 
				else if(d.realnum() != end.realnum()) {
					for(int z = 0; z < 4; z++) 
						for(int idx : idxs) {
						Data next = new Data(d);
						next.array[z] += idx;
						next.array[z] = Math.floorMod(next.array[z], 10);
						next.move++;
						if(arr[next.realnum()] == 0) {
							arr[next.realnum()] = 1;
							list.addLast(next);
							
						}
					}
				}
			}
			System.out.println(step);
		}
	}
	static class Data {
		int[] array;
		int move;
		public Data(int d1, int d2, int d3, int d4, int move) {
			this.array = new int[] {d1, d2, d3, d4};
			this.move = move; 
		}
		public Data(Data d) {
			this.array = Arrays.copyOf(d.array, d.array.length);
			this.move = d.move;
		}
		public int realnum() {
			return array[0]*1000 + array[1]*100 + array[2]*10 + array[3];
		}

	}

}
