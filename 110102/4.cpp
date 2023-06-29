#include <iostream>
#include <cstring>
using namespace std;

int main() {
	int x,y=0;
	char n;
	int temp,num = 0;
	while (cin >> x >> y){
		if(x==0 && y==0)
			break;
		char** table=new char * [y];
		for(int i =0; i<y; ++i)
			table[i] = new char[x];
		int** table_int= new int * [y];
		for(int i =0; i<y; ++i)
			table_int[i] = new int[x];
		temp =y;
		y=x;
		x =temp;
		for(int j = 0;j <y; j++)
			for(int i=0; i <x; i++){
				cin>>table[i][j];
				table_int[i][j]=0;
			}
		for(int j=0; j<y; j++){
			for(int i = 0; i<x; i++){
				if(table[i][j] =='*'){
					table_int[i][j] = -1;
					if(i-1>=0 && j-1>=0)
						if(table_int[i-1][j-1] !=-1)
							table_int[i-1][j-1]++;
					if(j-1>=0)
						if(table_int[i][j-1]!=-1)
							table_int[i][j-1]++;
					if(j-1>=0 && i+1<x)
						if(table_int[i+1][j-1]!=-1)
							table_int[i+1][j-1]++;
					if(i-1>=0)
						if(table_int[i-1][j]!=-1)
							table_int[i-1][j]++;
					if(i+1<x)
						if(table_int[i+1][j]!=-1)
							table_int[i+1][j]++;
					if(i-1 >= 0 && j+1<y)
						if(table_int[i-1][j+1]!=-1)
							table_int[i-1][j+1]++;
					if(j+1<y)
						if(table_int[i][j+1]!=-1)
							table_int[i][j+1]++;
					if(i+1<x && j+1<y)
						if(table_int[i+1][j+1]!=-1)
							table_int[i+1][j+1]++;		
				}
			}
		}
		cout<<"Field #"<<++num<<":" <<endl;
		for (int j=0;j<y; j++){
			for(int i=0; i<x; i++){
				if(table_int[i][j] == -1){
					cout<<'*';
				}
				else 
					cout<<table_int[i][j];
			}
			cout<<"\n";
		}
		cout<<endl;
	}
}