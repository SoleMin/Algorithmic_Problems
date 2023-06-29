#include <iostream>
#include <cstdlib>
#define MAX 1000
using namespace std;
int compare(const void* a,const void* b){
	const int* x =(int*)a;
	const int* y =(int*)b;
	if(*x>*y)
		return 1;
	else if(*x<*y)
		return -1;
	return 0;
}
int main() {
	int cases,people,t,solve,count,temp1,temp2;
	cin>>cases;
	while(cases--){
		int n=0;
		int ptime[MAX]={};
		solve=0;
		temp1=0;
		temp2=0;
		cin>> people;
		count=people;
		while(count--){
			cin>>t;
			ptime[n++]=t;
		}
		qsort(ptime, people,sizeof(int),compare);
		
		while(people>3){
			temp1 =ptime[1];
			temp1 +=ptime[0];
			temp1 +=ptime[people-1];
			temp1 += ptime[1];
			
			temp2 =ptime[people-2];
			temp2 +=ptime[0];
			temp2 +=ptime[people-1];
			temp2 +=ptime[0];
			
			people-=2;
		
		if(temp1>temp2)
			solve+=temp2;
		else
			solve+=temp1;
		}
		if(people==3)
			solve += ptime[0]+ptime[1]+ptime[2];
		else if(people==2)
			solve += ptime[1];
		
		cout<<solve<<"\n"<<endl;
	}
	
	
	return 0;
}