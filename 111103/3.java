import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Elephant> elephants = new ArrayList<Elephant>();
		int count = 0;
		while(input.hasNextLine()) {
			String[] split = input.nextLine().split("\\s+");
			if(split[0].equals(""))
				break;
			elephants.add(new Elephant(Integer.parseInt(split[0]), Integer.parseInt(split[1]), ++count));
		}

		Collections.sort(elephants, new Comparator<Elephant>() {
			@Override
			public int compare(Elephant o1, Elephant o2) {
				int c = Integer.compare(o1.weight, o2.weight);
				if(c == 0)
					c = Integer.compare(o1.iq, o2.iq);
				return c;
			}
		});

		int[][] matrix = new int[count][count+1];
		int[][] route = new int[count][count+1];
		Elephant[] e = elephants.toArray(new Elephant[elephants.size()]);
		for(int[] a : matrix)
			Arrays.fill(a, 10001);
		matrix[count-1][1] = e[count-1].iq;

		for(int i=count-2; i>=0; i--) {
			for(int j=1; j<count+1; j++) {
				if(j == 1) {
					matrix[i][j] = e[i].iq;
				}
				else if(e[i].iq > matrix[i+1][j-1]) {
					int min = -1;
					for(int k=i+1; k<count; k++) {
						if(e[i].iq > matrix[k][j-1] && e[i].weight != e[route[k][j-1]].weight && (min==-1 || e[min].order > e[k].order))
							min = k;
					}
					if(min != -1) {
						matrix[i][j] = e[i].iq;
						route[i][j] = min;
					}
				}

				if(matrix[i][j] > matrix[i+1][j] || (route[i+1][j] != 0 && route[i][j] > route[i+1][j])) {
					matrix[i][j] = matrix[i+1][j];
					route[i][j] = route[i+1][j];
				}
			}
		}

		int maxLength = 0;
		for(int i=count; i>=0; i--)
			if(matrix[0][i] != 10001) {
				maxLength = i;
				break;
			}
		System.out.println(maxLength);

		for(int i=1; i<count; i++) {
			if(route[i][maxLength] != route[i-1][maxLength]) {
				System.out.println(e[i-1].order);
				break;
			}
		}
		int nextElephant = route[0][maxLength];
		while(maxLength != 1) {
			System.out.println(e[nextElephant].order);
			nextElephant = route[nextElephant][--maxLength];
		}
		input.close();
	}

	public static class Elephant {
		int weight, iq, order;
		Elephant(int weight, int iq, int order) {
			this.weight = weight;
			this.iq = iq;
			this.order = order;
		}
	}
}