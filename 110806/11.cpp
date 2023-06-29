#include<iostream>
#include<string>

using namespace std;

static int identifier, cell_num;
static char cell_shape[33], automata[8], before[32];
static bool check=false;

void backtrack(int a)
{
	if(a==cell_num-1)
	{
		if(automata[before[a-1]*4 + before[a]*2 + before[0]] == cell_shape[a] && automata[before[a]*4 + before[0]*2 + before[1]] == cell_shape[0])
		{
			check=true;
		}
		return;
	}
	
	for(int i=before[a-1]*4+before[a]*2;i<=before[a-1]*4+before[a]*2+1;i++)
	{
		if(automata[i]==cell_shape[a])
		{
			before[a+1]=i%2;
			backtrack(a+1);
			if(check==true)
				break;
		}
	}
}

int main()
{
	while(cin>>identifier>>cell_num>>cell_shape)
	{
		for(int i=0;i<cell_num;i++)
		{
			cell_shape[i]-='0';
		}
		for(int i=0;i<8;i++)
		{
			automata[i]=identifier%2;
			identifier/=2;
		}
		
		check=false;
		for(int i=0;i<8;i++)
		{
			if(automata[i]==cell_shape[1])
			{
				before[0]=(i/4)%2;
				before[1]=(i/2)%2;
				before[2]=i%2;
				backtrack(2);
				if(check==true)
					break;
			}
		}
		
		if(check==true)
			cout<<"REACHABLE"<<endl;
		else
			cout<<"GARDEN OF EDEN"<<endl;
		
	}
	
	return 0;
}