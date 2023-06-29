#include <iostream>
#include <cstring>
using namespace std;
int main() {
	char input[1000]={0,};
	char word[1000]={0,};
	char seventwo[1000]={0,};
	int i, j, num = 0, count=0, k , pls, l, tmp, lo, ch, tmp2;
	for(;cin.getline(input,1000);){
		if(input[0] == '\0'){
			if(seventwo[num-1] == ' '){
						for(lo=(num-1);seventwo[lo] == ' ';lo--){
							seventwo[lo] = '\0';
						}
					}
			cout << seventwo << endl;
			for(k=0;k<1000;k++){
						seventwo[k] = NULL;
					}
					num = 0;
					count = 0;
			cout << endl;
			continue;
		}
		tmp = strlen(input);
		ch=0;
		if(tmp >= 72){
			for(lo=0;lo<72;lo++){
				if(input[lo] == ' ')
					ch++;
			}
			if(ch==0){
				if(seventwo[num-1] == ' '){
						for(lo=(num-1);seventwo[lo] == ' ';lo--){
							seventwo[lo] = '\0';
						}
					}
				tmp2 = strlen(seventwo);
				if(tmp2 != 0)
					cout << seventwo << endl;
				num = 0;
				count = 0;
				cout << input << endl;
				for(k=0;k<1000;k++){
					seventwo[k] = NULL;
					input[k] = NULL;
				}
				continue;
			}
		}
		for(i=0, j=0;i<=tmp;i++, j++){
			if((input[i] == ' ') || (input[i] == '\0')){
				pls = j;
				if(count+pls<=72){
					for(k=0;k<j;k++, num++){
						seventwo[num] = word[k];
					}
					if(input[i] == ' ' || (input[i] == '\0')){
						seventwo[num] = ' ';
						num++;
						pls++;
					}
					for(l=0;l<1000;l++){
						word[l] = NULL;}
					count = count + pls;
				}
				else{
					if(seventwo[num-1] == ' '){
						for(lo=(num-1);seventwo[lo] == ' ';lo--){
							seventwo[lo] = '\0';
						}
					}
					cout << seventwo << endl;
					for(k=0;k<1000;k++){
						seventwo[k] = NULL;
					}
					num = 0;
					count = 0;
					for(k=0;k<j;k++, num++){
						seventwo[num] = word[k];
					}
					seventwo[num] = ' ';
					num++;
					pls++;
					for(l=0;l<1000;l++){
						word[l] = NULL;}
					count = count + pls;
				}
				j=(-1);
			}
			else{
				word[j] = input[i];
			}
		}
		for(i=0;i<1000;i++){
			word[i] = NULL;
			input[i] = NULL;
		}
	}
	cout << seventwo;
	return 0;
}