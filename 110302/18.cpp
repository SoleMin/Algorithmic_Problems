#include <iostream>
#include <string>

using namespace std;
int main() {
	string line;
	char zoo[50];
	char q[50][50];
	bool l1 = false, l2=false, l3 = false, l4 =false;
	int casenum, space=0,m,n,s=0,k,len=0,kcount=0;
	int right =0, rd=0,un=0,ld=0,left=0,up=0,ul=0,ur=0;
	int row[100] = {0,};
	int column[100]={0,};
	
	while(getline(cin,line)){
		if(l1==false){
			casenum = stoi(line);
			l1=true;
		}
		else{
			if(l2==false) l2 = true;
			else{
				if(l3==false){
					for(int i=0;i<line.length();i++){
						if(line[i]==' ') break;
						space++;
					}
					m=stoi(line.substr(0,space));
					space++;
					n=stoi(line.substr(space,line.length()));
					l3=true;
				}
				else{
					if((s+1)<=m){
						for(int i=0;i<line.length();i++){
							q[s][i] = tolower(line[i]);
						}
						s++;
					}
					else{
						if(l4==false){
							k=stoi(line);
							l4=true;
						}
						else{
							if(kcount<k){
								for(int i=0;i<line.length();i++){
									zoo[i]=tolower(line[i]);
									len++;
								}
								for(int i=0;i<m;i++){
									for(int j=0;j<n;j++){
										for(int o=0;o<len;o++){
											if(q[i][j+o]==zoo[o])right++;
											if(q[i+o][j+o]==zoo[o]) rd++;
											if(q[i+o][j]==zoo[o]) un++;
											if(q[i+o][j-o]==zoo[o]) ld++;
											if(q[i][j-o]==zoo[o])left++;
											if(q[i-o][j]==zoo[o])up++;
											if(q[i-o][j-o]==zoo[o])ul++;
											if(q[i-o][j+o]==zoo[o])ur++;
										}
										if(right==len||rd==len||un==len||ld==len||left==len||up==len||ul==len||ur==len){
											row[kcount]=j+1;
											column[kcount]=i+1;
											kcount++;
										}
										right=0;
										rd=0;
										un=0;
										ld=0;
										left=0;
										up=0;
										ul=0;
										ur=0;
									}
								}
								len=0;
							}
						}
					}
				}
			}
		}
	}
	for(int i=0;i<kcount;i++){
		cout<<column[i]<<" "<<row[i]<<endl;
	}
	return 0;
}