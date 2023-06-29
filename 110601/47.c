#include <stdio.h>
#include <string.h>
#define MAXDIGIT 100

static char a[MAXDIGIT+1],b[MAXDIGIT+1];
static char fib[3][MAXDIGIT+1];
static int lengthA,lengthB,length[3];
static int result;


int input()
{
	int i;
	char tempA[MAXDIGIT+1],tempB[MAXDIGIT+1];
	scanf("%s",tempA);
	scanf("%s",tempB);
	
	if(tempA[0]=='0' && tempB[0]=='0')
		return 0;
	
	lengthA= strlen(tempA);
	lengthB= strlen(tempB);
	
	for(i=0;i<lengthA;i++)
		a[i]=tempA[lengthA-i-1]-'0';
	for(i=0;i<lengthB;i++)
		b[i]=tempB[lengthB-i-1]-'0';
	return 1;
}

int compare(int fi,char* num,int len)
{
	int i;
	if(length[fi]<len)
		return -1;
	if(length[fi]>len)
		return 1;
	for(i=len-1;i>=0;i--)
	{
		if(fib[fi][i]<num[i])
			return -1;
		if(fib[fi][i]>num[i])
			return 1;
	}
	return 0;
}

void plus(int target,int a,int b)
{
	int len=0,carry=0;
	for(;len<length[a] && len<length[b];len++)
	{
		fib[target][len]=(fib[a][len]+fib[b][len]+carry);
		if(fib[target][len]>=10)
			carry=1;
		else
			carry=0;
		fib[target][len]%=10;
	}	
	if(len<length[a])
	{
		for(;len<length[a];len++)
		{
			fib[target][len]=(fib[a][len]+carry);
			if(fib[target][len]>=10)
				carry=1;
			else
				carry=0;
			fib[target][len]%=10;
		}
	}
	else
	{
		for(;len<length[b];len++)
		{
			fib[target][len]=(fib[b][len]+carry);
			if(fib[target][len]>=10)
				carry=1;
			else
				carry=0;
			fib[target][len]%10;
		}
	}
	if(carry)
		fib[target][len++]=1;
	length[target]=len;
}

void main() 
{
	int i;
	while(input())
	{
		length[0]=length[1]=1;
		fib[0][0]=fib[1][0]=1;
		for(i=1;compare(i%3,a,lengthA)<0;i++)
			plus((i+1)%3,i%3,(i-1)%3);
		result=i;
		for(;compare(i%3,b,lengthB)<=0;i++)
			plus((i+1)%3,i%3,(i-1)%3);
		result=i-result;
		printf("%d\n",result);
	}
}
