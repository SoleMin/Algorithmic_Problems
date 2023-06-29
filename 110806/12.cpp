#include<iostream>
using namespace std;
string ss;
int q,n,b;
int a[32];
int p[32];

int cass(int q, int l, int m, int r)
{
	int w = q & (1<<((l << 2)|(m << 1)|r));
	if(w)
		return 1;
	return 0;
}

void find(int k)
{
	if(b)
		return;
	if(k==n){
		if(cass(q,p[n-2],p[n-1],p[0])!=a[n-1])
			return;
		if(cass(q,p[n-1],p[0],p[1])!=a[0])
			return;
		b++;
	}
	for(int i=0;i<2;i++){
		p[k]=i;
		if(k>=2&&cass(q,p[k-2],p[k-1],p[k])!=a[k-1])
			continue;
		find(k+1);
	}
}

bool no()
{
	b = 0;
	find(0);
	if(b)
		return true;
	else 
		return false;
}

int main()
{
	while(cin>>q>>n>>ss){
		int aa = ss.size();
		for(int i=0;i<aa;i++)
			a[i]=ss[i]-'0';
		if(no())
			cout<<"REACHABLE"<<endl;
		else 
			cout<<"GARDEN OF EDEN"<<endl;
	}
	return 0;
}