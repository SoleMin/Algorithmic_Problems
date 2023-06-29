import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
	
	static int compa;
	static ArrayList[] Graph;
	static boolean[] cam;
	static int[] visit;
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = 1;
		while(true) {
			int cityNum = scan.nextInt();
			if(cityNum == 0) {
				break;
			}
			String[] cityList = new String[cityNum];
			scan.nextLine();
			for (int i = 0; i < cityNum; i++) {
				cityList[i] = scan.nextLine();
			}
			int E = scan.nextInt();
			scan.nextLine();
		
			Graph = new ArrayList[cityNum+1];
			for (int i=1; i<= cityNum; i++) {
				Graph[i] = new ArrayList<Integer>();
			}
			ArrayList<String> ci = new ArrayList<>(Arrays.asList(cityList));
			String city;
			for (int i = 0; i < E; i++) {
				city = scan.nextLine();
				String[] city1 = city.split(" ");
				int A = ci.indexOf(city1[0])+1;
				int B = ci.indexOf(city1[1])+1;
				Graph[A].add(B);
				Graph[B].add(A);
			}
			visit = new int [cityNum+1];
			cam = new boolean [cityNum+1];
			
			compa = 1;
			for (int i=1; i<=cityNum; i++) {
				if (visit[i] == 0) {
					dfs(i, true, 0);
				}
			}
			int ans = 0;
			ArrayList<Integer> cnt = new  ArrayList<>();
			ArrayList<String> cpycityList = new  ArrayList<>();
			for (int i=1; i<=cityNum; i++) {
				if (cam[i]) {
					ans++;
					cnt.add(i);
				}
			}
			System.out.println("City map #"+ casenum + ": "+ ans + " camera(s) found");
			for(int i = 0 ; i < cnt.size(); i++) {
				cpycityList.add(cityList[cnt.get(i)-1]);
			}
			Collections.sort(cpycityList);
			for(int i = 0 ; i < cnt.size(); i++) {
				System.out.println(cpycityList.get(i));
			}
			System.out.println();
			casenum++;
		}
	}
	
	static int dfs(int num, boolean root, int parent) {
		visit[num] = compa;
		compa++;
		int line = visit[num];
		int child = 0;
		int len = Graph[num].size();
		for (int i = 0; i<len; i++) {
			int pre = (int) Graph[num].get(i);
			
			if (pre == parent) {
				continue;
			}
			if (visit[pre]==0) {
				child++;
				int low = dfs(pre, false, num);
				if (!root && low >= visit[num]) {
					cam[num] = true;
				}
				line = Math.min(line, low);
			}
			else {
				line = Math.min(line, visit[pre]);
			}
		}
		if (root && child>=2) {
			cam[num] = true;
		}
		return line;
	}
}