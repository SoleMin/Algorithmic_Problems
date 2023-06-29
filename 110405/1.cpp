#include <iostream>
using namespace std;

void bubble_sort(int data[1000][3], int num){
	int i, j, k, l, tmp;
	for(j=1;j<num;j++){
		for(i=0;i<(num-j);i++){
			if(data[data[i][0]][1]*data[data[i+1][0]][2] > data[data[i+1][0]][1]*data[data[i][0]][2]){
				tmp = data[i][0];
				data[i][0] = data[i+1][0];
				data[i+1][0] = tmp;
			}
		}
	}
}

int main() {
	int input, input2;
	int data[1000][3];
	cin >> input;
	for(int i=0;i<input;i++){
		cin >> input2;
		for(int j=0;j<input2;j++){
			data[j][0] = j;
			cin >> data[j][1] >> data[j][2];
		}
		bubble_sort(data, input2);
		for(int j=0;j<input2;j++){
			cout << data[j][0]+1 << " ";
		}
		cout << endl << endl;
	}
	return 0;
}