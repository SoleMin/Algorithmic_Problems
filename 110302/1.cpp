#include <iostream>
#include <ctype.h>

using namespace std;

void print_find(int row, int col, char **greed, char *find){
	int i, j, k, num, find_c, flag = 0;
	for(num=0;find[num] != '\0';num++){}
	find_c = find[0];
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			flag = 0;
			if(greed[i][j] == find_c){
				flag = 1;
				// 오른쪽으로
				for(k=1;find[k] != '\0' && j+k<col;k++){
					if(find[k] == greed[i][j+k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 왼쪽으로
				for(k=1;find[k] != '\0' && j-k>=0;k++){
					if(find[k] == greed[i][j-k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 아래쪽으로
				for(k=1;find[k] != '\0' && i+k<row;k++){
					if(find[k] == greed[i+k][j])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 위쪽으로
				for(k=1;find[k] != '\0' && i-k>=0;k++){
					if(find[k] == greed[i-k][j])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 대각선 오른쪽 아래
				for(k=1;find[k] != '\0' && j+k<col && i+k<row;k++){
					if(find[k] == greed[i+k][j+k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 대각선 오른쪽 위
				for(k=1;find[k] != '\0' && j+k<col && i-k>=0;k++){
					if(find[k] == greed[i-k][j+k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 대각선 왼쪽 아래
				for(k=1;find[k] != '\0' && j-k>=0 && i+k<row;k++){
					if(find[k] == greed[i+k][j-k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
				
				// 대각선 왼쪽 위
				for(k=1;find[k] != '\0' && j-k>=0 && i-k>=0;k++){
					if(find[k] == greed[i-k][j-k])
						flag++;
					else
						break;
				}
				if(flag == num){
					cout << i+1 << " " << j+1 << endl;
					return;
				}
				else
					flag = 1;
			}
			if(flag == num)
				cout << i+1 << " " << j+1 << endl;
		}
	}
}

int main() {
	int row, col, i, j, k_find, tc, tcc;
	cin >> tcc;
	for(tc=0;tc<tcc;tc++){
		cin >> row >> col;
		getchar();
		char **greed = new char*[row];
		for(i=0;i<row;i++)
			greed[i] = new char[col];
		for(i=0;i<row;i++){
			cin.getline(greed[i],col+1);
		}
		for(i=0;i<row;i++){
			for(j=0;j<col;j++){
				if(isupper(greed[i][j])){
					 greed[i][j] = tolower(greed[i][j]);
				}
			}
		}
		cin >> k_find;
		getchar();
		char **find = new char*[k_find];
		for(i=0;i<k_find;i++)
			find[i] = new char[100];
		
		for(i=0;i<k_find;i++){
			cin.getline(find[i], 100);
		}
		for(i=0;i<k_find;i++){
			for(j=0;find[i][j] != '\0';j++){
				if(isupper(find[i][j])){
					 find[i][j] = tolower(find[i][j]);
				}
			}
		}
		for(i=0;i<k_find;i++){
			print_find(row, col, greed, find[i]);
		}
		cout << endl;
		for(i=0;i<row;i++)
			delete [] greed[i];
		delete [] greed;
		for(i=0;i<k_find;i++)
			delete [] find[i];
		delete [] find;
	}
	return 0;
}