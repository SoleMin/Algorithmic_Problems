import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CE35D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(sc.readLine());
		String[] t = sc.readLine().split(" ");
		int[] list = new int[n];
		for(int x=0; x<n; x++){
			list[x] = Integer.parseInt(t[x]);
		}
		
		boolean even = true;
		
		int[] indList = new int[n+1];
		
		
		for(int x=0; x<n; x++){
			indList[list[x]] = x;
		}
		
		for(int x=1; x<=n; x++){
			int theIndex = indList[x];
			int other = list[x-1];
			if(theIndex != x-1){
				even = !even;

				list[x-1] = x;
				list[theIndex] = other;
				
				indList[x] = x-1;
				indList[other] = theIndex;
			}
		}
		
		//System.out.println(even);
		
		int numQ = Integer.parseInt(sc.readLine());
		for(int x=0; x<numQ; x++){
			String[] dir = sc.readLine().split(" ");
			int l = Integer.parseInt(dir[0]);
			int r = Integer.parseInt(dir[1]);
			int diff = r - l + 1;
			if(diff%4 > 1){
				even = !even;
			}
			if(even){
				System.out.println("even");
			}
			else{
				System.out.println("odd");
			}
		}
	}
}

/*
int n = Integer.parseInt(sc.nextLine());
String[] t = sc.nextLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++){
	list[x] = Integer.parseInt(t[x]);
}
		
String[] dir = sc.nextLine().split(" ");
int a = Integer.parseInt(dir[0]);
int b = Integer.parseInt(dir[1]);
int c = Integer.parseInt(dir[2]);
int d = Integer.parseInt(dir[3]);
int e = Integer.parseInt(dir[4]);

int n = Integer.parseInt(sc.nextLine());
*/