#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct EL{
	int num;
	int we;
	int iq;
	int value;
	int parent;
}el;

bool cmp(const el & a, const el & b)
{
	if (a.we < b.we) return true;
	else if (a.we == b.we){
		if (a.iq < b.iq) return true;
		else if (a.iq == b.iq){
			if (a.num < b.num) return true;
		}
	}
	return false;
}
int fool_el(vector<el> & v, int idx, int n){
	int max = 0;
	int max_idx = -1;
	int temp;
	if(v[idx].value != -1){
		return v[idx].value;
	}else{
		for(int i= idx+1 ; i<n;i++){
			if(v[i].iq < v[idx].iq){
				temp = fool_el(v, i, n);
				if(temp>=max){
					if(temp == max){
						if(v[i].num<v[max_idx].num){
							max = temp;
							max_idx = i;	
						}
					}else{
						max = temp;
						max_idx = i;
					}
					//cout << i << endl;
				}
			}
		}
		
		v[idx].value = max+1;
		v[idx].parent = max_idx;
		return max+1;
	}
}

int main() {
	int w, q, n=0;
	int ans = 0, tep=0, max = 0, next;
	vector<el> v;
	el temp;
	for(int i=0;cin>>w>>q;i++){
		temp.num = i+1;
		temp.we = w;
		temp.iq = q;
		temp.value = -1;
		temp.parent = -1;
		v.push_back(temp);
		n++;
	}
	sort(v.begin(), v.end(), cmp);
	for(int i=0;i<n;i++){
		tep=fool_el(v, i, n);
		if(max<tep){
			max = tep;
			ans = i;
		}
	}
	cout << max << endl;
	
	for(;v[ans].num != -1;){	
		next = v[ans].num;
		cout << next << endl;
		ans = v[ans].parent;
	}
	
	return 0;
}