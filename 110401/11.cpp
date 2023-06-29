#include<iostream>
#include<cmath>

using namespace std;

int main()
{
	int test_case;
	
	cin>>test_case;
	
	for(int i=0;i<test_case;i++)
	{
		int home_num, home_position[500]={0}, sum_distance=0, num, vito_home;
		
		cin>>home_num;
		
		for(int j=0;j<home_num;j++)
		{
			cin>>home_position[j];
		}
		num=home_num/2;
		vito_home=home_position[num];
		
		for(int j=0;j<home_num;j++)
		{
			sum_distance+=abs(vito_home-home_position[j]);
		}
		
		cout<<sum_distance<<endl;
	}

	return 0;
}