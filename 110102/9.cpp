#include <iostream>
#include <string>


using namespace std;
int main() {
	string line;
	
	int col[100] = {0, };
	int row[100] = {0, };
	char matrix[100][100][100] = {0, };
	int mine[100][100][100] = {0, };
	int loop = 0;
	int maxloop = 0;
	int n = 0;
	
	while(getline(cin,line)){
		int m = 0;
		if(line =="0 0") {
			maxloop=loop;
			break;
		}
		for(int i =0; i<line.length();i++){
			if(line[i]==' '){
				string a =line.substr(0,i);
				i+=1;
				string b = line.substr(i,line.length());
				loop++;
				col[loop] = stoi(a);
				row[loop] = stoi(b);
				n = -1;
			}
			else{
				if(line[i]=='.'){
					m++;
				}
				if(line[i]=='*'){
					if(n==0){
						++mine[loop][n+1][m];
						if(m==0){
							++mine[loop][n][m+1];
							++mine[loop][n+1][m+1];
						}
						else if (m==row[loop]){
							++mine[loop][n][m-1];
							++mine[loop][n+1][m-1];
						}
						else{
							++mine[loop][n][m+1];
							++mine[loop][n+1][m+1];
							++mine[loop][n][m-1];
							++mine[loop][n+1][m-1];
						}
					}
					else if(n==col[loop]){
						++mine[loop][n-1][m];
						if(m==0){
							++mine[loop][n][m+1];
							++mine[loop][n-1][m+1];
						}
						else if(m==row[loop]){
							++mine[loop][n][m-1];
							++mine[loop][n-1][m-1];
						}
						else{
							++mine[loop][n][m+1];
							++mine[loop][n-1][m+1];
							++mine[loop][n][m-1];
							++mine[loop][n-1][m-1];
						}
					}
					else{
						++mine[loop][n+1][m];
						++mine[loop][n-1][m];
						if(m==0){
							++mine[loop][n][m+1];
							++mine[loop][n+1][m+1];
							++mine[loop][n-1][m+1];
						}
						else if(m==row[loop]){
							++mine[loop][n][m-1];
							++mine[loop][n+1][m-1];
							++mine[loop][n-1][m-1];
						}
						else{
							++mine[loop][n][m+1];
							++mine[loop][n+1][m+1];
							++mine[loop][n-1][m+1];
							++mine[loop][n][m-1];
							++mine[loop][n+1][m-1];
							++mine[loop][n-1][m-1];
						}
					}
					matrix[loop][n][m]='*';
					m++;
				}
			}
		}
		n++;
	}
	for(loop=1;loop<=maxloop;loop++){
		cout<<"Field #"<<loop<<":"<<endl;
		for(int t = 0;t<col[loop];t++){
			for(int y=0; y<row[loop];y++){
				if(matrix[loop][t][y]!='*'){
					matrix[loop][t][y] = mine[loop][t][y]+48;
				}
				cout<<matrix[loop][t][y];
			}
			cout<<endl;
		}
		cout<<endl;
	}
	return 0;
}