#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#define INF 0x3f3f3f3f
using namespace std;
int f[6000];
struct ab
{
    int w,s;
} a[6000];
bool cmp(ab a,ab b)
{
    return a.s<b.s;
}
int main()
{
    int N=0;
    for(; ~scanf("%d%d",&a[N].w,&a[N].s); N++);
    sort(a,a+N,cmp);
    int M=0,i,j;
    memset(f,INF,sizeof(f));
    f[0]=0;
    for(i=0; i<N; i++)
        for(j=M; j>=0; j--)
        {
            if(a[i].s>=f[j]+a[i].w&&f[j]+a[i].w<f[j+1])
            {
                f[j+1]=f[j]+a[i].w;
                if(j+1>M) M=j+1;
            }
        }
    printf("%d\n",M);
    return 0;
}