#include<stdio.h>
#include<string.h>
#define BUFFER 1000
int main()
{
    char ar[2][BUFFER+2],temp[BUFFER+2],check;
    int i,j,k,line1,line2,flag[BUFFER+2];
    while(gets(ar[0]))
    {
        line1=strlen(ar[0]);
        gets(ar[1]);
        line2=strlen(ar[1]);
        for(i=0; i<BUFFER+2; i++)
            flag[i]=0;
        if(line1>line2)
        {
            strcpy(temp,ar[0]);
            strcpy(ar[0],ar[1]);
            strcpy(ar[1],temp);
            temp[0]='\0';
            line1^=line2^=line1^=line2;
        }
      temp[0]='\0';
        for(i=0,j=0; i<line1; i++)
            for(k=0; k<line2; k++)
                if(ar[0][i]==ar[1][k] && flag[k]==0)
                {
                    temp[j]=ar[0][i];
                    j++;
                    flag[k]=1;
                    break;
                }
        for(i=0; i<j; i++)
            for(k=i+1; k<j; k++)
                if(temp[i]>temp[k])
                {
                    check=temp[i];
                    temp[i]=temp[k];
                    temp[k]=check;
                }
        temp[k]='\0';
        puts(temp);
    }
    return 0;
}