import java.io.*;

import java.util.Scanner;

class Main {
	
	static void mergeSort(int start, int end, int[] array, int size) {
		int[] newArray = new int[size];
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid, array, size);
			mergeSort(mid+1, end, array, size);
			
			int p = start;
			int q = mid + 1;
			int idx = p;
			
			while(p <= mid || q <= end) {
				if(q > end || (p <= mid && array[p] < array[q])) {
					newArray[idx++] = array[p++];
				}
				else {
					newArray[idx++] = array[q++];
				}
			}
			for(int i = start; i <= end; i++) {
				array[i] = newArray[i];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String[] white = new String[5];
		String[] black = new String[5];
		
		int[] whiteNumber = new int[5];
		int[] whiteShape = new int [5];
		
		int[] blackNumber = new int[5];
		int[] blackShape = new int[5];
		
		int whiteAnswer = 0;
		int blackAnswer = 0;
		
		int[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int[] shape = {100, 200, 300, 400};
		
		String answer = null;
		
		while(input.hasNext()) {
			int[] whitePare = new int[14];
			int[] blackPare = new int[14];
			
			int whitePareCheck = 0;
			int blackPareCheck = 0;
			
			int[] whiteFlush = new int[5];
			int[] blackFlush = new int[5];
			
			int whiteFour = 0;
			int blackFour = 0;
			
			int whiteSgt = 0;
			int blackSgt = 0;
			
			int whiteFT = 0;
			int blackFT = 0;
			
			for(int i = 0; i < 5; i++){
				white[i] = input.next();
			}
			for(int i = 0; i < 5; i++){
				black[i] = input.next();
			}
			for(int i = 0; i < 5; i++){
				if(white[i].charAt(0) == '1') {
					whiteNumber[i] = 1;
				}
				else if(white[i].charAt(0) == '2'){
					whiteNumber[i] = 2;
				}
				else if(white[i].charAt(0) == '3') {
					whiteNumber[i] = 3;
				}
				else if(white[i].charAt(0) == '4') {
					whiteNumber[i] = 4;
				}
				else if(white[i].charAt(0) == '5') {
					whiteNumber[i] = 5;
				}
				else if(white[i].charAt(0) == '6') {
					whiteNumber[i] = 6;
				}
				else if(white[i].charAt(0) == '7') {
					whiteNumber[i] = 7;
				}
				else if(white[i].charAt(0) == '8') {
					whiteNumber[i] = 8;
				}
				else if(white[i].charAt(0) == '9') {
					whiteNumber[i] = 9;
				}
				else if(white[i].charAt(0) == 'T'){
					whiteNumber[i] = 10;
				}
				else if(white[i].charAt(0) == 'J'){
					whiteNumber[i] = 11;
				}
				else if(white[i].charAt(0) == 'Q') {
					whiteNumber[i] = 12;
				}
				else if(white[i].charAt(0) == 'K') {
					whiteNumber[i] = 13;
				} 
				else if(white[i].charAt(0) == 'A') {
					whiteNumber[i] = 14;
				}
 			}
			
			for(int i = 0; i < 5; i++) {
				if(black[i].charAt(0) == '1') {
					blackNumber[i] = 1;
				}
				else if(black[i].charAt(0) == '2') {
					blackNumber[i] = 2;
				}
				else if(black[i].charAt(0) == '3') {
					blackNumber[i] = 3;
				}
				else if(black[i].charAt(0) == '4') {
					blackNumber[i] = 4;
				}
				else if(black[i].charAt(0) == '5') {
					blackNumber[i] = 5;
				}
				else if(black[i].charAt(0) == '6') {
					blackNumber[i] = 6;
				}
				else if(black[i].charAt(0) == '7') {
					blackNumber[i] = 7;
				}
				else if(black[i].charAt(0) == '8') {
					blackNumber[i] = 8;
				}
				else if(black[i].charAt(0) == '9') {
					blackNumber[i] = 9;
				}
				else if(black[i].charAt(0) == 'T') {
					blackNumber[i] = 10;
				}
				else if(black[i].charAt(0) == 'J') {
					blackNumber[i] = 11;
				}
				else if(black[i].charAt(0) == 'Q') {
					blackNumber[i] = 12;
				}
				else if(black[i].charAt(0) == 'K') {
					blackNumber[i] = 13;
				}
				else if(black[i].charAt(0) == 'A') {
					blackNumber[i] = 14;
				}
			}
			
			for(int i = 0; i < 5; i++) {
				if(white[i].charAt(1) == 'H') {
					whiteShape[i] = 100;
				}
				else if(white[i].charAt(1) == 'S') {
					whiteShape[i] = 200;
				}
				else if(white[i].charAt(1) == 'C') {
					whiteShape[i] = 300;
				}
				else if(white[i].charAt(1) == 'D') {
					whiteShape[i] = 400;
				}
			}
			
			for(int i = 0; i < 5; i++) {
				if(black[i].charAt(1) == 'S') {
					blackShape[i] = 100;
				}
				else if(black[i].charAt(1) == 'D') {
					blackShape[i] = 200;
				}
				else if(black[i].charAt(1) == 'H') {
					blackShape[i] = 300;
				}
				else if(black[i].charAt(1) == 'C') {
					blackShape[i] = 400;
				}
			}
			
			mergeSort(0,4,whiteNumber, 5);
			mergeSort(0,4,blackNumber,5);
			
			whiteAnswer = 11;
			blackAnswer = 11;
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 14; j++) {
					if(whiteNumber[i] == number[j]) {
						whitePare[j]++;
					}
				}
			}
			
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 14; j++) {
					if(blackNumber[i] == number[j]) {
						blackPare[j]++;
					}
				}
			}
			
			for(int i = 0; i < 14; i++) {
				if(whitePare[i] == 2) {
					whitePareCheck++;
				}
				else if(whitePare[i] == 3) {
					whiteAnswer = 14;
					whiteFT = i;
				}
				else if(whitePare[i] == 4) {
					whiteFour = 1;
				}
				else if(whitePare[i] == 5) {
					whiteSgt = 1;
				}
			}
			
			if(whitePareCheck == 1 && whiteAnswer != 14) {
				whiteAnswer = 12;
			}
			if(whitePareCheck == 1 && whiteAnswer == 14) {
				whiteAnswer = 17;
			}
			if(whitePareCheck == 2) {
				whiteAnswer = 13;
			}
			if(whiteFour == 1) {
				whiteAnswer = 18;
			}
			
			for(int i = 0; i < 14; i++) {
				if(blackPare[i] == 2) {
					blackPareCheck++;
				}
				else if(blackPare[i] == 3) {
					blackAnswer = 14;
					blackFT = i;
				}
				else if(blackPare[i] == 4) {
					blackFour = 1;
				}
				else if(blackPare[i] == 5) {
					blackSgt = 1;
				}
			}
			
			if(blackPareCheck == 1 && blackAnswer != 14) {
				blackAnswer = 12;
			}
			if(blackPareCheck == 1 && blackAnswer == 14) {
				blackAnswer = 17;
			}
			if(blackPareCheck == 2) {
				blackAnswer = 13;
			}
			if(blackFour == 1) {
				blackAnswer = 18;
			}
			
			if(whiteNumber[4] - whiteNumber[3] == 1
				&& whiteNumber[3] - whiteNumber[2] == 1
				&& whiteNumber[2] - whiteNumber[1] == 1
				&& whiteNumber[1] - whiteNumber[0] == 1) {
				whiteAnswer = 15;
			}
			
			if(blackNumber[4] - blackNumber[3] == 1
				&& blackNumber[3] - blackNumber[2] == 1
				&& blackNumber[2] - blackNumber[1] == 1
				&& blackNumber[1] - blackNumber[0] == 1){
				blackAnswer = 15;
			}
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 4; j++) {
					if(whiteShape[i] == shape[j]) {
						whiteFlush[j]++;
					}
				}
			}
			
			for(int i = 0; i < 5; i++) {
				if(whiteFlush[i] == 5) {
					whiteAnswer = 16;
				}
			}
			if(whiteAnswer == 16 && whiteSgt == 1) {
				whiteAnswer = 19;
			}
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 4; j++) {
					if(blackShape[i] == shape[j]) {
						blackFlush[j]++;
					}
				}
			}
			for(int i = 0; i < 5; i++){
				if(blackFlush[i] == 5) {
					blackAnswer = 16;
				}
			}
			if(blackAnswer == 16 && blackSgt == 1) {
				blackAnswer = 19;
			}
			
			if(whiteAnswer > blackAnswer) {
				answer = "Black wins.";
			}
			else if(whiteAnswer < blackAnswer) {
				answer = "White wins.";
			}
			else if(whiteAnswer == blackAnswer) {
				if(whiteNumber[4] > blackNumber[4]) {
					answer = "Black wins.";
				}
				else if(whiteNumber[4] < blackNumber[4]) {
					answer = "White wins.";
				}
				else {
					if(whiteNumber[3] > blackNumber[3]) {
						answer = "Black wins.";
					}
					else if(whiteNumber[3] < blackNumber[3]) {
						answer = "White wins.";
					}
					else {
						if(whiteNumber[2] > blackNumber[2]) {
							answer = "Black wins.";
						}
						else if(whiteNumber[2] < blackNumber[2]) {
							answer = "White wins.";
						}
						else {
							if(whiteNumber[1] > blackNumber[1]) {
								answer = "Black wins.";
							}
							else if(whiteNumber[1] < blackNumber[1]) {
								answer = "White wins.";
							}
							else {
								if(whiteNumber[0] > blackNumber[0]) {
									answer = "Black wins,";
								}
								else if(whiteNumber[0] < blackNumber[0]) {
									answer = "White wins.";
								}
								else {
									answer = "Tie.";
								}
							}
						}
					}
				}
			}
			
			if(blackAnswer == 17 && whiteAnswer == 17) {
				if(whiteNumber[whiteFT] > blackNumber[blackFT]) {
					answer = "Black wins.";
				}
				else if(whiteNumber[whiteFT] < blackNumber[blackFT]) {
					answer = "White wins.";
				}
			}
			System.out.println(answer);
		}
	}
}