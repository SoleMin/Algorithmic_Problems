#include <stdio.h>
#include <iostream>
#include <queue>
#include <map>
#include <algorithm>

using namespace std;
map<string, string> R;

string left1(string v) {
    static char t1, t2;
    string tn;
    tn = v;
    t1 = tn[11], t2 = tn[10];
    tn[11] = tn[9], tn[10] = tn[8], tn[9] = tn[7];
    tn[8] = tn[6], tn[7] = tn[5], tn[6] = tn[4];
    tn[5] = tn[3], tn[4] = tn[2], tn[3] = tn[1];
    tn[2] = tn[0], tn[1] = t1, tn[0] = t2;
    return tn;
}
string right2(string v) {
    static char t1, t2;
    string tn;
    tn = v;
    t1 = tn[9], t2 = tn[10];
    tn[9] = tn[11], tn[10] = tn[12], tn[11] = tn[13];
    tn[12] = tn[14], tn[13] = tn[15], tn[14] = tn[16];
    tn[15] = tn[17], tn[16] = tn[18], tn[17] = tn[19];
    tn[18] = tn[20], tn[19] = t1, tn[20] = t2;
    return tn;
}
string left3(string v) {
    static char t1, t2;
    string tn;
    tn = v;
    t1 = tn[9], t2 = tn[10];
    tn[9] = tn[11], tn[10] = tn[0], tn[11] = tn[1];
    tn[0] = tn[2], tn[1] = tn[3], tn[2] = tn[4];
    tn[3] = tn[5], tn[4] = tn[6], tn[5] = tn[7];
    tn[6] = tn[8], tn[7] = t1, tn[8] = t2;
    return tn;
}
string right4(string v) {
    static char t1, t2;
    string tn;
    tn = v;
    t1 = tn[11], t2 = tn[10];
    tn[11] = tn[9], tn[10] = tn[20], tn[9] = tn[19];
    tn[20] = tn[18], tn[19] = tn[17], tn[18] = tn[16];
    tn[17] = tn[15], tn[16] = tn[14], tn[15] = tn[13];
    tn[14] = tn[12], tn[13] = t1, tn[12] = t2;
    return tn;
}
void init() {
    R["034305650121078709T90"] = "";
    queue<string> Q;
    string tn, next;
    Q.push("034305650121078709T90");
    while(!Q.empty()) {
        tn = Q.front(), Q.pop();
        string &step = R[tn];
        if(step.length() >= 8)
            continue;
       
        next = left3(tn);
        string &o1 = R[next];
        if(o1 == "")    o1 = "1" + step, Q.push(next);
       
        next = right4(tn);
        string &o2 = R[next];
        if(o2 == "")    o2 = "2" + step, Q.push(next);
       
        next = left1(tn);
        string &o3 = R[next];
        if(o3 == "")    o3 = "3" + step, Q.push(next);
        
        next = right2(tn);
        string &o4 = R[next];
        if(o4 == "")    o4 = "4" + step, Q.push(next);
    }
}
void solution(string tn) {
		map<string, string> rR;
		map<string, string>::iterator it;
		string next;
		queue<string> Q;
		rR[tn] = "";
		Q.push(tn);
	
		while(!Q.empty()) {
			
				tn = Q.front(), Q.pop();
				string &step = rR[tn];
				it = R.find(tn);
			
				if(it != R.end()) {
						cout << step << it->second << endl;
						return;
				}
			
				if(step.length() >= 8)
						continue;
			
				next = left1(tn);
				string &o1 = rR[next];
			
				if(o1 == "")    o1 = step+"1", Q.push(next);

				next = right2(tn);
				string &o2 = rR[next];
			
				if(o2 == "")    o2 = step+"2", Q.push(next);

				next = left3(tn);
				string &o3 = rR[next];
			
				if(o3 == "")    o3 = step+"3", Q.push(next);
				
				next = right4(tn);
				string &o4 = rR[next];
			
				if(o4 == "")    o4 = step+"4", Q.push(next);
		}
	
		cout<<"NO SOLUTION WAS FOUND IN 16 STEPS\n";
	
}


int main() {
		init();
		int n;
		cin>>n;
	
	
		for(int ii=0; ii<n; ii++){
				int i, x;
				string s = "";
				for(i = 0; i < 24; i++) {
						cin>>x;
					
						if(i < 21) {
								if(x == 10)
										s += 'T';
								else
										s += (char)(x + '0');
						}
					
				}
			
				if(s == "034305650121078709T90")
						cout<<"PUZZLE ALREADY SOLVED\n";
				else
						solution(s);
			
		}
		return 0;
}