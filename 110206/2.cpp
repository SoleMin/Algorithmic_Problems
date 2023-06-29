#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 5000
char erd[] = "Erdos, P.";

struct my
{
	char name[100];
	int num;
};
struct my fuc[MAX];
int check[MAX] = {0, };
char allstr[MAX][500];
int person_num;
int ructfind(char* tmp)
{
	for(int i=0; i< MAX; i++)
		if(strcmp(fuc[i].name, tmp)==0)
			return i;
	return -1;
}
int strfind(char * des, char* find)
{
	char tmp[100];
	for(int i=0; i<=strlen(des) - strlen(find); i++)
	{
		strncpy(tmp, &(des[i]), strlen(find));
		tmp[strlen(find)] = '\0';
		if(strcmp(tmp, find) == 0)
			return i;
	}
	return -1;
}
void namecut(char* str)
{
	int prev=0;
	char name[100];
	for(int i=1; str[i-1] != ':'; i++)
	{
		if((str[i]==',' && str[i-1] == '.') || (str[i] == ':' && str[i-1] == '.')){
			strncpy(name, &str[prev], i-prev);
			name[i - prev] = '\0';
			if(ructfind(name) == -1){
				strcpy(fuc[person_num].name, name);
				if(strcmp(name, erd) == 0)
					fuc[person_num++].num=0;
				else
					fuc[person_num++].num=99999;
			}
			prev = i+2;
		}
	}
}
void nameset(char *str, int n)
{
	int prev = 0;
	char name[50];
	for(int i=1; str[i-1] != ':'; i++)
	{
		if((str[i] == ',' && str[i-1] == '.') || (str[i] == ':' && str[i-1] == '.'))
		{
			strncpy(name, &str[prev], i-prev);
			name[i-prev] = '\0';
			if(fuc[ructfind(name)].num > n)
				fuc[ructfind(name)].num = n;
			prev = i+2;
		}
	}
}

int main()
			 {
				 int T, t, P, p, N, n, i, j, min, S;
				 char tmp[50];
				 scanf("%d", &T);
				 for(t=0; t<T; t++)
				 {
					 person_num = 0;
					 for(i=0; i<MAX; i++) check[i]=0;
					 for(i=0; i<MAX; i++){
						 fuc[i].num = -1;
						 fuc[i].name[0] = '\0';
					 }
					 scanf("%d %d", &P, &N);
					 fgets(tmp, 50, stdin);
					 
					 for(p=0; p<P; p++)
						 fgets(allstr[p], MAX, stdin);
					 
					 for(p=0; p<P; p++)
						 namecut(allstr[p]);
					 
					 for(p=0; p<P; p++)
						 if(strfind(allstr[p], erd) >= 0)
							 nameset(allstr[p], 1);
					 
					 for(S=0; fuc[S].num >= 0; S++);
					 
					 for(i=0; i<S; i++)
					 {
						 for(min = 0; check[min] != 0; min++);
						 for(j=0; j<S; j++){
							 if(check[j] == 0 && fuc[min].num > fuc[j].num)
								 min = j;
						 }
						 check[min]=1;
						 for(p=0; p<P; p++){
							 if(strfind(allstr[p], fuc[min].name) >= 0)
								 nameset(allstr[p], fuc[min].num + 1);
						 }
					 }
					 printf("Scenario %d\n", t+1);
					 for(n=0; n<N; n++)
					 {
						 fgets(tmp, 20, stdin);
						 tmp[strlen(tmp)-1] = '\0';
						 printf("%s ", tmp);
						 (fuc[ructfind(tmp)].num > 90000) ? printf("infinity\n") : printf("%d\n", fuc[ructfind(tmp)].num);
					 }
				 }
			 }