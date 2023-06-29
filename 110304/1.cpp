#include <iostream>
#include <string.h>

using namespace std;
int main() {
	int i, j, k, test_case, spa_count, no_spa_count, flag, l, cou;
	string buffer;
	char armho[100][100] = {0,};
	char solution[2][100] = {"the quick brown fox jumps over the lazy dog", NULL};
	int temp[256] = {0,};
	int count;
	char a;
	cin >> test_case;
	getchar();
	getchar();
	for(i=0;i<test_case;i++){
		cou = 0;
		flag = 0;
		for(j=0;getline(cin,buffer) && buffer != "\0";j++){
			strcpy(armho[j], buffer.c_str());
			spa_count = 0;
			no_spa_count = 0;
			count = 0;
			for(k=0;k<256;k++)
				temp[k] = 0;
			for(k=0;armho[j][k] != '\0';k++){
				if(armho[j][k] == ' ')
					spa_count++;
				else
					no_spa_count++;
			}
			if(spa_count == 8 && no_spa_count == 35 && armho[j][3] == ' ' && armho[j][9] == ' ' && armho[j][15] == ' ' 
				&& armho[j][19] == ' ' && armho[j][25] == ' ' && armho[j][30] == ' ' && armho[j][34] == ' ' && armho[j][39] == ' ' ){
				for(k=0;armho[j][k] != '\0';k++){
					if(temp[armho[j][k]] == 0){
						temp[armho[j][k]]++;
						count++;
					}
				}
				if(count == 27){
					strcpy(solution[1], armho[j]);
					flag = 1;	
				}
				else{
					flag = 0;
				}
			}
			cou++;
		}
		if(flag != 1){
			cout << "No solution." << endl;
		}
		else if(flag == 1){
			for(j=0;j<cou;j++){
				for(k=0;k<100;k++){
					a = armho[j][k];
					for(l=0;l<100;l++){
						if(armho[j][k] == solution[1][l]){
							a = solution[0][l];
						}
					}
					armho[j][k] = a;
				}
			}
			for(j=0;j<cou;j++){
				cout << armho[j] << endl;
			}
		}
		for(j=0;j<100;j++){
			for(k=0;k<100;k++){
				armho[j][k] = '\0';
				solution[1][k] = '\0';
			}
		}
		if(i<test_case-1)
			cout << endl;
	}
	return 0;
}