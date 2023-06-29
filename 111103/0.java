import java.util.Scanner;
import java.util.Stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int count_ok = 0;
	static int[] array_id = new int[1001];
	static int[] array_puzzle = new int[1001];
	static int countt = 0;
	static int[][] next = new int[1001][1001];
	
	static void select(int index){
		countt++;
		if(countt == count_ok + 1){
			return;
		}
		else{
			next[index][index] += 10;
		}
		System.out.println(array_id[index]);
		
		select(array_puzzle[index]);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 1;
		
		// 코끼리 생성자
		class El{
		int w;
		int iq;
		int id;
						
			El(int w, int iq, int id){
				this.w = w;
				this.iq = iq;
				this.id = id;
			}
		}
		
		// 생성자 배열 생성 및 초기화
		El[] e = new El[1000];
		for(int i = 0; i < 1000; i++) {
			e[i] = new El(0,0,0);
		}
		
		while(input.hasNextLine()) {
			
			// 입력받기
			String in = input.nextLine() + " ";
			String[] split = in.split(" ");
			e[count].w = Integer.parseInt(split[0]);
			e[count].iq = Integer.parseInt(split[1]);
			e[count].id = count;
			count++;
			
		}
		
		// 눈물나는 정렬
		int min = 0;
		int temp_1 = 0;
		int temp_2 = 0;
		int temp_3 = 0;
		for(int i = 1; i < count-1; i++) {
			min = i;
			for(int j = i+1; j < count; j++) {
				if(e[min].w < e[j].w) {
					min = j;
				}
				else if(e[min].w == e[j].w) {
					if(e[min].iq < e[j].iq) {
						min = j;
					}
				} 
			}
			temp_1 = e[min].iq;
			e[min].iq = e[i].iq;
			e[i].iq = temp_1;
			
			temp_2 = e[min].w;
			e[min].w = e[i].w;
			e[i].w = temp_2;
			
			temp_3 = e[min].id;
			e[min].id = e[i].id;
			e[i].id = temp_3;
		}

		// 시퀀시 정렬
		int[] smallP = new int[1001];
		int[] puzzle = new int[1001];
		int first = 0;
		int secound = 0;
		smallP[0] = 0;
		for(int i = 1; i < count; i++) {
			smallP[i] = 1;
			puzzle[i] = i;
			if(first == 0){
				secound /= 10;
			}
			else{
				secound *= 10;
			}
			for(int j = 1; j < i; j++) {
				if (e[i].iq > e[j].iq &&
					smallP[i] < smallP[j] + 1 &&
					e[i].w < e[j].w) {
					smallP[i] = smallP[j] + 1;
					puzzle[i] = j;
				}
			}
		}
		
		int answer = -1;
		int index = 0;
		for(int i = 1; i < count; i++) {
			for(int j = 0; j < count; j++){
				if(first == 1 && secound == 0){
					first = first + secound;
				}
			}
			if(answer < smallP[i]) {
				index = i;
				answer = smallP[i];
			}
		}
		
		for(int i = 0; i < count; i++){
			array_id[i] = e[i].id;
			array_puzzle[i] = puzzle[i];
		}
		
		count_ok = answer;
		
		System.out.println(answer);
		
		select(index);
	}

}

