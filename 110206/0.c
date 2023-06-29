#include <stdio.h>
#include <string.h>
int main() {
	int num;
	int m;
	int n;
	char name[5000][100];
	char name1[5000][100];
	char Nonmoon[5000];
	int i,j,k,l,z;
	int cnt =0;
	int cnt1 = 0;
	int cnt2[5000]={0,};
	char line;
	int cmp;
	int cmp1;
	char *Erdos = "Erdos, P.";
	int arr[5000];
	int result[5000];
	int temp = 0;
	
	scanf("%d", &num);
	
	while(num!=0){
		scanf("%d %d", &m,&n);
		scanf("%c", &line);
		l=0;
		for(i=0;i<5000;i++){
			for(j=0;j<100;j++){
				name[i][j] = '\0';
				name1[i][j] = '\0';
			}
		}
		for(i=0;i<5000;i++){
			cnt2[i] = 0;
			
		}
		for(i=0;i<5000;i++){
			arr[i] = 0;
			result[i] = 0;
		}
		cnt = 0;
		cnt1 = 0;// 초기화
		for(i=0;i<100;i++){	
			if(cnt1 == m)							// 케이스수가 m이랑 같으면 빠져나감
				break;
			for(j=0;j<100;j++){
				scanf("%c",&name[i][j]); // 이름 받기
				if(name[i][j] ==',')
					cnt++;
				if(cnt==2){
					name[i][j] ='\0';
					scanf("%c", &line);
					cnt=0;
					cnt2[l]++;
					break;               	// ,가 2번나오면 빠져나감
				}
				if(name[i][j]==':'){		// :입력 받으면 
					name[i][j] = '\0';
					cnt2[l]++;
					if(l>0)
						cnt2[l] += cnt2[l-1];
					l++;
					gets(Nonmoon);				// 논문 입력받음
					cnt1++;								// 케이스 수 증가
					cnt = 0;
					break;
				}
			}
		}
		for(i=0;i<100;i++){
				cmp = strcmp(name[i], Erdos); 
				if(cmp ==0){						// 이름이 에르되시랑 같으면
					for(j=0;j<m;j++){
						if(i<cnt2[j]){
							if(j<1){
								for(k=0;k<cnt2[j];k++)
									arr[k] = 1;		// 같이 논문쓴 애들 1
								break;
							}
							else{
								for(k=cnt2[j-1];k<cnt2[j];k++)
									arr[k] = 1;
								break;
							}
						}
					}
				}	
		}
		
		
		
		for(i=0;i<100;i++){									// 이름 같은애들 값 똑같이 만들기
			if(name[i] == '\0')
				break;
			if(arr[i] == 0){
				for(j=0;j<100;j++){
					if(arr[j]==1){
						cmp = strcmp(name[i],name[j]);
						if(cmp == 0){
							arr[i] = arr[j];
						}
					}
				}
			}
		}
		
		for(i=0;i<m;i++){ 				// 에르되시 수1인 애들이랑 논문 쓴애들 2로 만들기
			k=0;
			
			cnt = 0;
			if(i>0){
				for(j=cnt2[i-1];j<cnt2[i];j++){
					k++;
					if(arr[j] ==1)
						cnt++;
				}
				if(k!=cnt && cnt !=0){
					for(z = cnt2[i-1];z<cnt2[i];z++){
						if(arr[z] == 0 )
							arr[z] = 2;
					}
				}
			}
			else{
				for(j=0;j<cnt2[i];j++){
					k++;
					if(arr[j]==1)
						cnt++;
				}
				if(k!=cnt && cnt != 0){
					for(z=0;z<cnt2[i];z++){
						if(arr[z]==0)
							arr[z] = 2;
					}
				}
			}
				
		}
		
	
		for(i=0;i<100;i++){				// 2인 애들 다른논문에서도 2로 만들기
			if(name[i] == '\0')
				break;
			if(arr[i]==0){
				for(j=0;j<100;j++){
					if(arr[j]==2){
						cmp= strcmp(name[i],name[j]);
						if(cmp ==0){
							arr[i] = arr[j];
						}
					}
				}
			}
		}
		for(i=0;i<m;i++){
			k=0;
			cnt = 0;
			if(i>0){
				for(j=cnt2[i-1];j<cnt2[i];j++){
					k++;
					if(arr[j]==2)
						cnt++;
				}
				if(k!=cnt && cnt != 0){
					for(z=cnt2[i-1];z<cnt2[i];z++){
						if(arr[z] == 0)
							arr[z] = 3;
					}
				}
			}
			else{
				for(j=0;j<cnt2[i];j++){
					k++;
					if(arr[j] == 2)
						cnt++;
				}
				if(k!=cnt && cnt != 0){
					for(z=0;z<cnt2[i];z++){
						if(arr[z]==0)
							arr[z]=3;
					}
				}
			}
			
		}
		for(i=0;i<100;i++){
			if(name[i] =='\0')
				break;
			if(arr[i]==0){
				for(j=0;j<100;j++){
					if(arr[j] == 3){
						cmp = strcmp(name[i],name[j]);
						if(cmp == 0){
							arr[i] = arr[j];
						}
					}
				}
			}
		}
		for(i=0;i<m;i++){
			k=0;
			cnt = 0;
			for(j=cnt2[i-1];j<cnt2[i];j++){
				k++;
				if(arr[j]==3)
					cnt++;
			}
			if(k!=cnt && cnt != 0){
				for(z=0;z<cnt2[i];z++){
					if(arr[z]==0)
						arr[z]=4;
				}
			}
		}
		
		for(i=0;i<n;i++){							// 이름 입력받기
			for(j=0;j<100;j++){
				scanf("%c", &name1[i][j]);
				if(name1[i][j] == '\n'){
					name1[i][j] = '\0';
					break;
				}
			}
		}
		for(i=0;i<n;i++){
			for(j=0;j<100;j++){
				cmp = strcmp(name1[i],name[j]);
				if(cmp ==0){
					result[i] = arr[j];
				}
			}
		}
		
		temp++;
		printf("Scenario %d\n", temp);
		for(i=0;i<n;i++){
			cmp = strcmp(name1[i],Erdos);
			if(cmp == 0)
				printf("%s 0\n", name1[i]);
			else{
				if(result[i] == 0)
					printf("%s infinity\n", name1[i]);
				else
					printf("%s %d\n",name1[i], result[i]);
			}
		}
		num--;
	}
}

