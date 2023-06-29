import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> weight = new ArrayList<>();
	static ArrayList<Integer> IQ = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> RESULT = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] split = line.split(" ");

			if(line.isEmpty()) break;

			weight.add(Integer.valueOf(split[0])); 
			IQ.add(Integer.valueOf(split[1]));

		}
		int[][] weight_a = toarray(weight);	//weight_array
		int[][] IQ_a = toarray(IQ);			//IQ_array


		RESULT = makeResult(weight_a, IQ_a);
		System.out.println();
		for(int i = 0; i < weight_a[0].length; i++) {
			RESULT = makeResult(smallera(weight_a), smallera(IQ_a));
		}
		
		
		int sizemax = 0;
		for(int i = 0; i < RESULT.size(); i++) {
			for(int g = 0; g < RESULT.get(i).size(); g++) {
				if(sizemax < RESULT.get(g).size()) {
					sizemax = RESULT.get(g).size(); 
				}
			}
		}

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		for(int i = 0; i < RESULT.size(); i++) {
				if(sizemax == RESULT.get(i).size()) {
					a.add(RESULT.get(i));

				
			}
		}
		
		int m = Integer.MAX_VALUE;
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < a.get(i).size(); j++) {
				if(count(a.get(i)) < m) {
					m = count(a.get(i));
				}
			}
		}
		int z = 0;
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < a.get(i).size(); j++) {
				if(m == count(a.get(i))) {
					z = i;
				}
			}
		}
				System.out.println(a.get(z).size());

		for(int i = 0; i < a.get(z).size(); i++)
		System.out.println(a.get(z).get(i));

		input.close();
	}

	static int[][] smallera(int[][] array) {
		int max = 0;
		for(int i = 0; i < array[0].length; i++) {
			if(max < array[1][i] && array[2][i] == 0) {
				max = array[1][i];
			}

		}
		for(int i = 0; i < array[0].length; i++) {
			if(array[1][i] == max && array[2][i] == 0) {
				array[2][i] = 1; //제외시키기
			}
		}
	
		return array;
	}

	static ArrayList<ArrayList<Integer>> makeResult(int[][] weight_a, int[][] IQ_a) {
		int j = 0;
		int ball = 0;
		int idx = 0;
		int max = 0;
		for(int k = 0; k < weight_a[0].length; k++) {	

			ArrayList<Integer> result = new ArrayList<>(); 
			for(int i = 0; i < IQ_a[0].length; i++) {
				if(weight_a[1][k] == IQ_a[1][i]) {
					max = i; //첫번째 max
				}
			}
			result.add(weight_a[1][k]);
			for(int i = k; i < weight_a[0].length-1; i++) {
				j = i+1;
				if(weight_a[2][j] == 0) {
					ball = weight_a[1][j];
					for(int z = 0; z < IQ_a[0].length; z++) {
						if(IQ_a[1][z] == ball) 
							idx = z;
					}
					if(max < idx) {
						max = idx;
						result.add(weight_a[1][j]);
					}
				}
			}
			RESULT.add(result);
		}
		return RESULT;
		
		
	}
	static ArrayList<Integer> removeq(ArrayList<Integer> RESULT) {
		ArrayList<Integer> a = new ArrayList<>();
		for(Integer i : RESULT) {
			if(!a.contains(i)) {
				a.add(i);
			}
		}
		return a;
	}

	static ArrayList<ArrayList<Integer>> remove(ArrayList<ArrayList<Integer>> RESULT) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		for(ArrayList<Integer> item : RESULT){
			if(!a.contains(item)) 
				a.add(item);
		}

		return a;	}


	static int count(ArrayList<Integer> list) {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			count += list.get(i);
		}
		return count;
	}

	static class Index {
		private int index;
		private int value;
		public Index(int index, int value) {
			this.index = index;
			this.value = value;
		}
		int getIndex() {
			return this.index;
		}
		int getValue() {
			return this.value;
		}
		void setIndex(int index) {
			this.index = index;
		}
		void setValue(int value) {
			this.value = value;
		}
	}

	static int[][] toarray(List<Integer> list) {
		int n = list.size();
		int[][] array = new int[3][n];
		ArrayList<Index> arr = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			arr.add(new Index(i, list.get(i)));
		}	

		if(list == weight) {
			Collections.sort(arr, Comparator.comparing(Index::getValue));//정렬...
		}
		else if(list == IQ) {
			Collections.sort(arr, Comparator.comparing(Index::getValue).reversed());//정렬...
		}

		for(int i = 0; i < arr.size(); i++) {
			array[0][i] = (i);
		}

		int idx = 0;
		for(Index index : arr) {
			array[1][idx] = index.index+1;
			idx++;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		if(list == weight) {
			temp = weight;
			Collections.sort(temp);
		}
		else {
			temp = IQ;
			Collections.sort(temp);
			Collections.reverse(temp);

		}
		ArrayList<Integer> count = new ArrayList<>();
		int[] c = new int[temp.size()];
		for(int i = 0; i < c.length; i++) {
			c[i] = 1;//초기화
		}
		for(int i = 0; i < temp.size(); i++) { 
			if(!count.contains(temp.get(i))) { 
				count.add(temp.get(i));
				c[i] = 0;
			}
		}
		for(int i = 0; i < c.length; i++) {
			array[2][i] = c[i];
		}

		System.out.println();

		return array;

	}
}