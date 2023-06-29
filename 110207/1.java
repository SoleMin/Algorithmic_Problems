import java.io.*;

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int testcaseNumber = input.nextInt();
		String trash = input.nextLine();
		
		int stop = 0;
		while(true) {
			if(stop == testcaseNumber) {
				break;
			}
			int[] team = new int[100];
			int[] problem = new int[100];
			int[] time = new int[100];
			String[] pt = new String[100];
			int[] answerProblem = new int[100];
			int[] answerTime = new int[100];
			int[] numberLine = new int[100];
			
			class set{
				int ap;
				int at;
				String ty;
				int id;
				int pn;
				
				public set(int a, int b, String c, int d, int e){
					this.ap = a;
					this.at = b;
					this.ty = c;
					this.id = d;
					this.pn = e;
				}
			}
			
			String a = "";
			String[] number = new String[1000];
			int m = 0;
			while(input.hasNextLine()){
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0){
					break;
				}
				number[m] = a;
				m++;
			}
			String train = "";
			int size = 0;
			
			if(stop == 0){
				for(int i = 1; i < m; i++){
					train += number[i].concat(" ");
				}
				size = m-1;
			}
			
			else{
				for(int i = 0; i < m; i++){
					train += number[i].concat(" ");
				}
				size = m;
			}
			
			String[] split = train.split(" ");
			
			int o = 0;
			int v = 0;
			int e = 0;
			int r = 0;
			for(int i = 0; i < split.length; i++){
				if(i % 4 == 0){
					team[o] = Integer.parseInt(split[i]);
					o++;
				}
				else if(i % 4 == 1){
					problem[v] = Integer.parseInt(split[i]);
					v++;
				}
				else if(i % 4 == 2){
					time[e] = Integer.parseInt(split[i]);
					e++;
				}
				else if(i % 4 == 3) {
					pt[r] = split[i];
					r++;
				}
			}
			
			set answer[] = new set[size];
			set temp = new set(0,0,"",0,0);
			
			for(int i = 0; i < size; i++){
				answer[i] = new set(0, time[i], pt[i], team[i], problem[i]);
			}
			
			int[] cIdex = new int[size];
			for(int i = 0; i < size; i++){
				if(answer[i].ty.equals("C")){
					cIdex[i] = 1;
					for(int j = 0; j < size; j++){
						if(answer[j].id == answer[i].id && answer[j].pn == answer[i].pn && i != j) {
							cIdex[j] = 1;
						}
					}
				}
			}
			
			for(int i = 0; i < size; i++){
				if(answer[i].ty.equals("C")) {
					answer[i].ap = 1;
				}
				else if(answer[i].ty.equals("I")){
					if(cIdex[i] == 1){
						answer[i].at = 20;
					}
					else{
						answer[i].at = 0;
					}
				}
				else {
					answer[i].at = 0;
					answer[i].ap = 0;
				}
			}
			
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(answer[i].id == answer[j].id && i != j) {
						answer[i].ap += answer[j].ap;
						answer[i].at += answer[j].at;
					}
				}
			}
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(answer[i].id == answer[j].id && i != j){
						answer[j] = new set(0,0,"",0,0);
					}
				}
			}
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(answer[i].ap < answer[j].ap && i != j){
						temp = answer[j];
						answer[j] = answer[i];
						answer[i] = temp;
					}
					else if(answer[i].ap == answer[j].ap){
						if(answer[i].at > answer[j].at){
							temp = answer[j];
							answer[j] = answer[i];
							answer[i] = temp;
						}
						else if(answer[i].at == answer[j].at){
							if(answer[i].id > answer[j].id){
								temp = answer[j];
								answer[j] = answer[i];
								answer[i] = temp;
							}
						}
					}
				}
			}
			for(int i = size-1; i > -1; i--){
				if(answer[i].id != 0 ){
						System.out.println(answer[i].id + " " + answer[i].ap + " " + answer[i].at);
				}
			}
			System.out.println("");
			stop++;
				
		}
		

	}
}