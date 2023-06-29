#include <bits/stdc++.h>
using namespace std;
#define ins 99999999
vector<vector<string>> X;
int dis[10005];
set<string>fr;
string root,to;
int ttt(string str)
{
	int ans=0;
	for (int i=0; i<str.size(); i++)
	{
		ans*=10;
		ans+=str[i]-'0';
	}
	return ans;
}
void BFS()
{
	if(fr.find(root)!=fr.end()||fr.find(to)!=fr.end())
	{
		cout<<"-1"<<endl;
		return;
	}
	if(root.compare(to)==0)
	{
		cout<<"0"<<endl;
		return;
	}
	int k=ttt(root);

	dis[k]=0;
	queue<int>q;
	q.push(k);
	bool ans=0;
	while(!q.empty()&&!ans)
	{
		int top=q.front();
		q.pop();
		for(int i=0; i<X[top].size()&&!ans; i++)
		{
			int h=ttt(X[top][i]);
			if(dis[h]==ins&&fr.find(X[top][i])==fr.end())
			{
				dis[h]=dis[top]+1;
				q.push(h);
				if(to.compare(X[top][i])==0)
				{
					ans=1;
					break;
				}
			}
		}
	}
	int h=ttt(to);

	if(dis[h]<ins)
		cout<<dis[h]<<endl;
	else
		cout<<"-1"<<endl;
}
void set_adj(int node)
{
	char W[6];
	vector<string>Y(8);
	string str1,str2;
	int a,b;int c=0;
	sprintf(W,"%04d",node);
	for(int i=0; i<4; i++)
	{
		str1="",str2="";
		int t=W[i]-'0';
		a=t+1;b=t-1;
		if(a==10)a=0;if(b==-1)b=9;
		char R[5],L[5];
		R[i]=char (a+'0');
		L[i]=char (b+'0');
		for(int j=0; j<4; j++)if(i!=j)R[j]=L[j]=W[j];
		for(int j=0; j<4; j++)str1+=R[j],str2+=L[j];
		Y[c++]=str1;Y[c++]=str2;
	}
	for(int i=0; i<8; i++)
		X[node].push_back(Y[i]);
}
int main()
{
	X.assign(10000,vector<string>());
	for(int i=0; i<=9999; i++)
	{
		int node=i;
		set_adj(node);
	}
	int t,a,b,c,d;
	char W[10];
	cin>>t;
	while(t--)
	{
		for(int i=0; i<=9999; i++)
			dis[i]=ins;
		root=to="";
		cin>>a>>b>>c>>d;
		sprintf(W,"%d%d%d%d",a,b,c,d);
		for(int i=0; i<4; i++)
			root+=W[i];
		cin>>a>>b>>c>>d;
		sprintf(W,"%d%d%d%d",a,b,c,d);
		for(int i=0; i<4; i++)
			to+=W[i];
		int k;
		cin>>k;
		while(k--)
		{
			string L;
			cin>>a>>b>>c>>d;
			sprintf(W,"%d%d%d%d",a,b,c,d);
			for(int i=0; i<4; i++)
				L+=W[i];
			fr.insert(L);
		}
		BFS();
		fr.clear();
	}
	return 0;
}