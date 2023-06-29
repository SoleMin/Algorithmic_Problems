#include<iostream>

using namespace std;

int main()
{
	int test_case;
	
	cin>>test_case;
	
	for(int i=0;i<test_case;i++)
	{
		int work_num, day[1000]={0}, fine[1000]={0}, work_order[1000]={0};
		
		cin>>work_num;
		
		for(int j=0;j<work_num;j++)
		{
			cin>>day[j]>>fine[j];
		}
		for(int j=0;j<work_num;j++)
		{
			work_order[j]=j+1;
		}
		
		
		int temp_day, temp_fine, temp;
		for(int j=0;j<work_num-1;j++)
		{
			for(int k=j+1;k<work_num;k++)
			{
				if(day[j]*fine[k] > day[k]*fine[j])
				{
					temp_day=day[j];
					temp_fine=fine[j];
					temp=work_order[j];
					day[j]=day[k];
					fine[j]=fine[k];
					work_order[j]=work_order[k];
					day[k]=temp_day;
					fine[k]=temp_fine;
					work_order[k]=temp;
				}
			}
		}
		
		
		for(int j=0;j<work_num;j++)
		{
			cout<<work_order[j]<<" ";
		}
		
		cout<<endl<<endl;
	}
	
	return 0;
}