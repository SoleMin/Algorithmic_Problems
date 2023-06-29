#include <iostream>
#include <string>
using namespace std;
int confirm(string ch, int num){
	int count=0;
	for(int i= num; i<ch.length();i++){
		if(ch[i]==' '||ch[i]=='\n')
			break;
		if(ch[i]!=' '||ch[i] !='\n')
			count++;
	}
	return count;
}
int main() {
	string line="";
	string str="";
	string file="";
	string nullst="";
	string corr="";
	int count=0;
	
		while(1){
			if(cin.eof())
				break;
			getline(cin, line);
			str+=line+"\n";
		}
	
	for(int i=0; i<str.length(); i++){
		if(str[i]=='\n'&&str[i-1]=='\n'){
			file += str[i];
			file += str[i];
		}
		else if(str[i]=='\n'&&str[i-1]!='\n'){
			file+=" ";
		}
		else 
			file+=str[i];
	}
	
	for(int i=0;i<file.length(); i++){
		if(count==0&&confirm(file,i)>72){
			count=0;
			for(int j=0;j<confirm(file,i); i++)
				nullst+=file[i];
			i+=confirm(file,i);
			nullst+="\n";
		}
		else if(confirm(file,i)>72){
			count=0;
			nullst+="\n";
			for(int j=0; j<confirm(file,i); i++)
				nullst+=file[i];
			i+=confirm(file,i);
			nullst+="\n";
			
		}
		else if(file[i]!='\n'){
			if(file[i]!=' '&&count+confirm(file,i)>72){
				nullst +="\n";
				count=0;
				nullst+=file[i];
				count++;
			}
			else if(file[i]==' '&&count+confirm(file,i)>72){
				nullst+="\n";
				count=0;
			}
			else {
				nullst+=file[i];
				count++;
			}
		}
		else if(file[i]=='\n'){
			nullst+=file[i];
			count =0;
		}
	}
	for(int i=0; i<nullst.length();i++){
		if(nullst[i+1]=='\n')
			if(nullst[i]==' ')
				i++;
		corr+=nullst[i];
	}
	cout<<corr;
	return 0;
}