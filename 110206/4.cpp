#include <iostream>
#include <string>
#include <map>
using namespace std;
map<string, int> erdosnum;

int main() {
	string names[50][100], paper, name[100];
	int sinario, p, n, papernum, i, j, k, max;
	bool change;
	cin >> sinario;
	for (int t = 0; t < sinario; t++){
		erdosnum.clear();
		erdosnum.insert({"Erdos, P.", 0});
		int p, n; //p = 논문갯수, n = 이름갯수
		max = 0;
		cin >> p;
		cin >> n;
		getline(cin, paper);
		// 논문 p개 받기
		for (int i = 0; i < p; i++){
			papernum = 0;
			getline(cin, paper);
			paper = paper.substr(0, paper.find(":"));
			
			for (j = 0; paper.find(".,") != -1; j++) {
				names[i][j] = paper.substr(0, paper.find(".,") + 1);
				papernum = paper.find(".,") + 3;
				paper = paper.substr(papernum, paper.length());
			}
			names[i][j] = paper.substr(0, paper.length());
			
			if (max < j)
				max = j + 1;
			
			for (k = 0; k < j + 1; k++)
				if(erdosnum.insert({names[i][k], -1}).second)
					erdosnum.insert({names[i][k], -1});
		}
		// map에서 value값 정리
		for (int m = 0; m < erdosnum.size(); m++){
			for (i = 0; i < p; i++) {
				change = false;
				map<string, int>::iterator iter;
				for (j = 0; j < max; j++){
					iter = erdosnum.find(names[i][j]);
					if (iter->second == m && iter->first != "")
						change = true;
				}
				if (change)
					for (k = 0; k < max; k++){
						iter = erdosnum.find(names[i][k]);
						if (iter->second == -1){
							erdosnum[names[i][k]] = m + 1;
						}
					}
			}
		}
		
		// 학자이름 n개 받음
		for (i = 0; i < n; i++)
			getline(cin, name[i]);
		// 결과 출력
		cout << "Scenario " << t + 1 << endl;
		for (i = 0; i < n; i++) {
			map<string, int>::iterator iter = erdosnum.find(name[i]);
			cout << iter->first << " ";
			if (iter->second == -1)
				cout << "infinity" << endl;
			else
				cout << iter->second << endl;

		}
	}
}