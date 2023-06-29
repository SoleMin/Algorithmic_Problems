#include <iostream>
#include <algorithm>
using namespace std;

int a_casef(int peo[1000], int lp) {
	int cou = 0, i;
	for (i = 1; i < lp; i++) {
		cou = cou + peo[0] + peo[i];
	}
	return cou;
}
int b_casef(int peo[1000], int lp) {
	int cou = 0, i;
	int check[2] = { 1, 1 };
	cou = peo[1];
	if (lp % 2 == 0) {
		for (i = (lp - 1); i > 2;) {
			if (check[0] == 1 && check[1] == 1) {
				cou = cou + peo[0];
				check[0] = 0;
			}
			else if (check[0] == 0 && check[1] == 1) {
				cou = cou + peo[1];
				check[1] = 0;
			}
			if (check[0] == 0 && check[1] == 0) {
				cou = cou + peo[1];
				check[0] = 1;
				check[1] = 1;
				continue;
			}
			cou = cou + peo[i];
			i = i - 2;
		}
		if ((check[0] == 0) && (check[1] == 1)) {
			cou = cou + peo[1] + peo[1];
		}
	}
	else {
		for (i = (lp - 1); i > 1;) {
			if (check[0] == 1 && check[1] == 1) {
				cou = cou + peo[0];
				check[0] = 0;
			}
			else if (check[0] == 0 && check[1] == 1) {
				cou = cou + peo[1];
				check[1] = 0;
			}
			if (check[0] == 0 && check[1] == 0) {
				cou = cou + peo[1];
				check[0] = 1;
				check[1] = 1;
				continue;
			}
			cou = cou + peo[i];
			i = i - 2;
		}
		//cou = cou + peo[1] + peo[1] + peo[0] + peo[2];
	}
	
	return cou;
}

int main() {
	int input;
	int i, lp, a_case, b_case, j, sum=0, idx, ab_case, a, b;
	int peo[1000];
	int peoch[2] = {0, 0};
	cin >> input;
	for (i = 0; i < input; i++) {
		cin >> lp;
		for (j = 0; j < lp; j++)
			cin >> peo[j];
		sort(peo, peo + lp);
		sum=peo[1];
		//if (lp == 0) ab_case = 0;
		for(idx=lp-1;idx>1;idx-=2){
				if(idx == 2){
					sum = sum + peo[0] + peo[2];
				}
			else{
//				if (peoch[0] == 0 && peoch[1] == 0) {
//					sum = sum + peo[1];
//					peoch[0] = 1;
//					peoch[1] = 1;
//				}
					a = peo[0]+peo[idx]+peo[0]+peo[idx-1];
					b = peo[0]+peo[idx]+peo[1]+peo[1];
					if(a<b){
						sum = sum + a;
					}
					else{
						sum = sum + b;
					}
			}
		}
		if (lp < 4) {
			if (lp == 1)
				sum = peo[0];
			else if (lp == 2)
				sum = peo[1];
			else if (lp == 3)
				sum = peo[0] + peo[1] + peo[2];
		}
		
		cout << sum << endl;
		cout << endl;
		for (j = 0; j < 1000; j++)
			peo[j] = NULL;
	}
	return 0;
}