#include <iostream>
#include <map>
#include <vector>
#include <stack>
#include <cstring>

using namespace std;

int compa(string A, string B){
	int i, len, dif = 0;
	char Ach[20];
	char Bch[20];
	if(A.length() != B.length())
		return 0;
	len = A.length();
	strcpy(Ach,A.c_str());
	strcpy(Bch,B.c_str());
	for(i=0;i<len;i++){
		if(Ach[i] != Bch[i])
			dif++;
	}
	return dif;
}

void seeeenap(map<string,vector<string>> &word_map){
	int check = 0;
	string A, B;
	for(auto it=word_map.begin();it!=word_map.end();it++){
		A = it->first;
		for(auto wo=word_map.begin();wo!=word_map.end();wo++){
			B = wo->first;
			check = compa(A, B);
			if(check == 1){
				it->second.push_back(B);
			}
			check = 0;
		}
		
	}
}

void ans_mp(string A, string B, map<string,vector<string>> di, map<string,int> &se_num, int num){
	int i = 0;
	if(se_num.find(A) == se_num.end()){
		se_num.insert(make_pair(A, num));
		i=0;
		for(auto as = (di.find(A)->second.begin());as!=(di.find(A)->second.end());i++, as++){
			ans_mp(di.find(A)->second[i], B, di, se_num, num+1);
		}
		return;
	}
	else{
		if(num < (se_num.find(A)->second)){
			se_num.find(A)->second = num;
			i=0;
			for(auto as = (di.find(A)->second.begin());as!=(di.find(A)->second.end());i++, as++){
				ans_mp(di.find(A)->second[i], B, di, se_num, num+1);
			}
		}
		return;
	}
}

int main() {
	int i, min_num, j, k;
	map<string, vector<string>> di;
	map<string, int> se_num;
	stack<string> po;
	string tmp, st, ed, min_string, tmp_string;
	char input[100];
	for(i=0;cin.getline(input, 100);i++){
		tmp = input;
		di.insert(make_pair(tmp, vector<string>{}));
		if(input[0] == '\0')
			break;
	}
	seeeenap(di);
	
	for(;cin >> st >> ed;){
		if(st.length() != ed.length())
			cout << "No solution." << endl;
		else{
			ans_mp(st, ed, di, se_num, 0);
			if(se_num.find(ed) == se_num.end()){
			cout << "No solution." << endl;
			}
			else{
				po.push(ed);
				min_string = ed;
				tmp_string = ed;
				min_num = se_num.find(ed)->second;
				min_num--;
				for(;min_num >= 0;){
					j=0;
					for(auto kk = (di.find(tmp_string)->second.begin()); kk <(di.find(tmp_string)->second.end()); kk++, j++){
						if(se_num.find(di.find(tmp_string)->second[j]) != se_num.end() && (min_num == (se_num.find(di.find(tmp_string)->second[j])->second))){
							min_string = di.find(tmp_string)->second[j];
						}
					}
					min_num--;
					po.push(min_string);
					tmp_string = min_string;
				}
			}
		}
	/* MAP에 뭐 들어있는지 확인용
	for(auto it=di.begin();it!=di.end();it++){
		cout << it->first << " :";
		k=0;
			for(auto kk= it->second.begin();kk !=(it->second.end());k++, kk++){
				cout << it->second[k] << ", ";
			}
		cout << endl;
	}
	for(auto it=se_num.begin();it!=se_num.end();it++){
		cout << it->first << " :" << it->second << endl;
	}
*/
	for(;!po.empty();){
		cout << po.top() << endl;
		po.pop();
	}

	cout << endl;
	//스택 초기화, se_num 초기화
	se_num.clear();
	}
	return 0;
}