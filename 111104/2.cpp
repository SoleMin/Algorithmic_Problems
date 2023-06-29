#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct tu {
	int num;
	int we;
	int he;
}tu;

bool cmp(const tu& a, const tu& b)
{
	if (a.he < b.he) return true;
	return false;
}

void tu_in(vector<tu>& v, int** val, int n) {
	int min, temp, temp2;
	for(int i=0;i<n;i++){
		for(int j=0;j<=i;j++){
			if(i==0&&j==0)
				val[i][j] = v[i].we;
			else if(j==0){
				if(v[i].we <= v[i].he){
					if(val[i-1][j] != -1)
						val[i][j] = (v[i].we < val[i-1][j]) ? v[i].we : val[i-1][j];
					else
						val[i][j] = v[i].we;
				}
				else{
					val[i][j] = -1;
				}
			}
			else{
				if(val[i-1][j-1] + v[i].we <= v[i].he){
					if(val[i-1][j-1] != -1 && val[i-1][j] != -1){
						val[i][j] = (val[i-1][j-1] + v[i].we < val[i-1][j]) ? val[i-1][j-1] + v[i].we : val[i-1][j];
					}
					else{
						if(val[i-1][j-1] == -1 && val[i-1][j] == -1)
							val[i][j] = -1;
						else if(val[i-1][j-1] != -1)
							val[i][j] = val[i-1][j-1] + v[i].we;
						else
							val[i][j] = val[i-1][j];
					}
				}
				else{
					val[i][j] = val[i-1][j];
				}
			}
		}
	}
}

int main() {
	int w, q, n = 0;
	int ans = 0, tep = 0, max = 0, next;
	int** val;
	vector<tu> v;
	tu temp;
	for (int i = 0; cin >> w >> q; i++) {
		temp.num = i + 1;
		temp.we = w;
		temp.he = q;
		v.push_back(temp);
		n++;
	}
	sort(v.begin(), v.end(), cmp);
	val = new int*[n];
	for(int i=0;i<n;i++)
		val[i] = new int[n];
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			val[i][j] = -1;
		}
	}
	tu_in(v, val, n);
	
	/*
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			cout << val[i][j] << " ";
		}
		cout << endl;
	}
	*/
	
	for(int i=0;i<n;i++){
		if(val[n-1][i] != -1){
			ans = i+1;
		}
	}
	cout << ans << endl;
	
	for(int i=0;i<n;i++)
		delete[] val[i];
	delete[] val;
	return 0;
}