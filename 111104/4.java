import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Turtle> turtles = new ArrayList<Turtle>();
		while(input.hasNextLine()) {
			String[] split = input.nextLine().split("\\s+");
			if(split[0].equals(""))
				break;
			turtles.add(new Turtle(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}

		Collections.sort(turtles, new Comparator<Turtle>() {
			@Override
			public int compare(Turtle o1, Turtle o2) {
				/**
				int c = Integer.compare(o1.leftStrength, o2.leftStrength);
				if(c == 0)
					c = Integer.compare(o1.weight, o2.weight);
				return c;
				**/
				int c = Integer.compare(o1.leftStrength+o1.weight, o2.leftStrength+o2.weight);
				if(c == 0)
					c = Integer.compare(o1.weight, o2.weight);
				return c;
			}
		});

		Iterator<Turtle> iter = turtles.iterator();
		int length = turtles.size();
		// matrix[체크한 거북이][올린 거북이 수] = 최소 무게
		int[][] matrix = new int[length][length+1];
		for(int a[] : matrix)
			Arrays.fill(a, -1);
		matrix[0][1] = iter.next().weight;
		int i = 1;
		while(iter.hasNext()) {
			Turtle nextTurtle = iter.next();
			for(int j=1; j<length+1; j++) {
				if(matrix[i-1][j]==-1 && matrix[i-1][j-1]==-1)
					continue;
				else if(matrix[i-1][j-1] == -1) {
					matrix[i][j] = Math.min(matrix[i-1][j], nextTurtle.weight);
					continue;
				}
				else if(matrix[i-1][j] == -1) {
					if(matrix[i-1][j-1] <= nextTurtle.leftStrength)
						matrix[i][j] = matrix[i-1][j-1] + nextTurtle.weight;
					continue;
				}
				else {
					if(matrix[i-1][j-1] > nextTurtle.leftStrength)
						matrix[i][j] = matrix[i-1][j];
					else
						matrix[i][j] = Math.min(matrix[i-1][j], matrix[i-1][j-1] + nextTurtle.weight);
				}	
			}
			i++;
		}

		for(int j=length; j>=0; j--) {
			if(matrix[length-1][j] != -1) {
				System.out.println(j);
				break;
			}
		}

	}

	public static class Turtle {
		int weight, leftStrength;
		Turtle(int weight, int strength){
			this.weight = weight;
			leftStrength = strength - weight;
		}

		void print() {
			System.out.println(weight + " " + leftStrength);
		}
	}
}