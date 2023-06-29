#include <iostream>
#define get_num(x) (x) / 10
#define get_shape(x) (x) % 10
using namespace std;

int sorted[5];
enum { 하이카드=1, 원페어, 투페어, 쓰리카드, 스트레이트, 플러시, 풀하우스, 포카드, 스트레이트플러시 };

int info_card(char* card) {
	int value;
	
	switch(*card) {
		case 'T': value = 100; break;
		case 'J': value = 110; break;
		case 'Q': value = 120; break;
		case 'K': value = 130; break;
		case 'A': value = 140; break;
		default : value = (*card - '0') * 10; break;
	}
	switch(*(card+1)) {
		case 'C': value += 1; break;
		case 'D': value += 2; break;
		case 'H': value += 3; break;
		case 'S': value += 4; break;
	}
	return value;
}

void merge(int* mycard, int s, int middle, int e) {
	int i = s, j = middle + 1, k = s;
	while (i <= middle && j <= e) {
		if (mycard[i] <= mycard[j]) {
			sorted[k] = mycard[i];
			i++;
		}
		else {
			sorted[k] = mycard[j];
			j++;
		}
		k++;
	}
	
	if (i > middle) {
		for (int t = j; t <= e; t++) {
			sorted[k] = mycard[t];
			k++;
		}
	}
	else {
		for (int t = i; t <= middle; t++) {
			sorted[k] = mycard[t];
			k++;
		}
	}
	for (int t = s; t <= e; t++) {
		mycard[t] = sorted[t];
	}
}

void mergeSort(int* mycard, int s, int e) {
	if (s < e) {
		int middle = (s + e) / 2;
		mergeSort(mycard, s, middle);
		mergeSort(mycard, middle + 1, e);
		merge(mycard, s, middle, e);
	}
}

long get_rank(int* mycard) {
	int i, num[5], shape[5];
	// 오름차순 카드 정렬
	mergeSort(mycard, 0, 4);
	// 카드 값, 카드 무늬
	for (i = 0; i < 5; i++) {
		num[i] = get_num(mycard[i]);
		shape[i] = get_shape(mycard[i]);
	}
	// rank
	if (num[0]+1 == num[1] && num[1]+1 == num[2] && num[2]+1 == num[3] && num[3]+1 == num[4]) {
		if (shape[0] == shape[1] && shape[0] == shape[2] && shape[0] == shape[3] && shape[0] == shape[4])
			return (스트레이트플러시 << 20) | num[4];	// 숫자가 연속이고 무늬가 모두 같으면
		else return (스트레이트 << 20) | num[4];	// 숫자가 연속이기만 하면
	}
	// 숫자가 연속이 아님
	if (shape[0] == shape[1] && shape[0] == shape[2] && shape[0] == shape[3] && shape[0] == shape[4])
		return (플러시 << 20) | (num[4] << 16) | (num[3] << 12) | (num[2] << 8) | (num[1] << 4) | num[0];	// 무늬가 모두 같으면
	// 모양이 모두 같지는 않음
	if (num[0] == num[3] || num[1] == num[4])
		return (포카드 << 20) | num[2];	// 같은 숫자가 4개이면
	// 같은 숫자 카드가 4개 미만
	if ( (num[0] == num[2] && num[3] == num[4]) || (num[0] == num[1] && num[2] == num[4]) )
		return (풀하우스 << 20) | num[2];	// 같은 숫자가 각각 3개, 2개이면
	if (num[0] == num[2] || num[1] == num[3] || num[2] == num[4])
		return (쓰리카드 << 20) | num[2];	// 같은 숫자가 3개이면
	// 같은 숫자 카드가 3개 미만
	if (num[0] == num[1] && num[2] == num[3])	// 페어가 2개이면
		return (투페어 << 20) | (num[3] << 8) | (num[1] << 4) | num[4];
	else if (num[0] == num[1] && num[3] == num[4])
		return (투페어 << 20) | (num[4] << 8) | (num[1] << 4) | num[2];
	else if (num[1] == num[2] && num[3] == num[4])
		return (투페어 << 20) | (num[4] << 8) | (num[2] << 4) | num[0];
	// 페어가 2개 미만
	if (num[0] == num[1])	// 페어가 1개이면
		return (원페어 << 20) | (num[1] << 12) | (num[4] << 8) | (num[3] << 4) | num[2];
	else if (num[1] == num[2])
		return (원페어 << 20) | (num[2] << 12) | (num[4] << 8) | (num[3] << 4) | num[0];
	else if (num[2] == num[3])
		return (원페어 << 20) | (num[3] << 12) | (num[4] << 8) | (num[1] << 4) | num[0];
	else if (num[3] == num[4])
		return (원페어 <<  20) | (num[4] << 12) | (num[2] << 8) | (num[1] << 4) | num[0];
	// 위 조건 모두 불만족
	return (하이카드 << 20) | (num[4] << 16) | (num[3] << 12) | (num[2] << 8) | (num[1] << 4) | num[0];
}

int main(void) {
	char buf[31];
	int i, b[5], w[5];
	long bw, ww;
	
	while (cin.getline(buf, 31)) {
		bw = ww = 0;
		// 카드 정보 저장
		for (i = 0; i < 5; i++) {	// black
			b[i] = info_card(buf + 3*i);
		}
		for (; i < 10; i++) {
			w[i-5] = info_card(buf + 3*i);
		}
		
		bw = get_rank(b);
		ww = get_rank(w);
		
		if (bw > ww)
			cout << "Black wins." << '\n';
		else if (bw < ww)
			cout << "White wins." << '\n';
		else
			cout << "Tie." << '\n';
	}
	return 0;
}