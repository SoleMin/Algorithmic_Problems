#include <stdio.h>
#include<stdlib.h>
#define Maxn 1000
#define MaxM 10000

int Compare(const void*Ar1, const void*Ar2)
{
	int A1, A2;
	A1 = *(int*)Ar1;
	A2 = *(int*)Ar2;
	return (A2-A1);
}

int M_used[1000];
int M_Essential[1000];

int main(){
	while(1)
	{
			int a,n;
			int all_m =0;
			int per_m;
			int m_ch=0;

			scanf("%d", &n);
			if(n==0)
				break;

			for(a=0; a<n;a++){
				double t;
				scanf("%lf", &t);
				M_used[a]=(int)(t*100+0.5);
				all_m += M_used[a];
			}

			qsort((void*)M_used, (size_t)a, sizeof(int), Compare);


			per_m = all_m/n;
			for(a=0;a<n;a++)
				M_Essential[a]= per_m;

			all_m%=n;

			for(a=0;a<all_m;a++)
				M_Essential[a]++;

			for(a=0; a<n;a++){
				m_ch += abs(M_used[a] - M_Essential[a]);
			}

			m_ch/=2;
			printf("$%.2f\n", m_ch/100.0);
		
		}
	}	
