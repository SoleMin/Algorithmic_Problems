/*
ID: andrew42
LANG: JAVA
TASK: 
PROG: 
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class curling {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int numD = input.nextInt();
		double rad = input.nextInt();
		int[] xC = new int[numD];
		for (int i = 0; i < numD; i++){
			xC[i] = input.nextInt();
		}
		double[] maxY = new double[1001];
		for (int i = 0; i < numD; i++){
			double h = rad;
			for (int j = Math.max(1, xC[i]-(int)(2*rad)); j <= Math.min(1000, xC[i]+2*rad); j++){
				if (maxY[j] > 0){
					h = Math.max(h, Math.sqrt(4*rad*rad-(j-xC[i])*(j-xC[i]))+maxY[j]);
				}
			}
			System.out.print(h + " ");
			maxY[xC[i]] = h;
		}
	}
}
