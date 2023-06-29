#include<string>
#include <bits/stdc++.h>
#include <cctype>
using namespace std;

char orig[]="the quick brown fox jumps over the lazy dog";
char alpha[128];
char sen[111][88];
//string sen[111];

void clear_sentences(){
  for(int i=0 ; i < 111; i++)
  for(int j=0 ; j < 88; j++)
  	sen[i][j]='\0';
}

void reset_alpha(){
  for(int i=0; i < 128; i++){
     alpha[i]='\0';
  }
}

bool check_substring_match(char c[]){
	 if(strlen(orig) > strlen(c)){
	 	//cout << "Length does not match " <<  endl;
    	return false;
	 }

	 //cout << "ARRAY = " << c << endl;
    for(int i=0;c[i];i++){
        if(orig[i]==' '&& c[i]!=' '){
            return false;
        }
    }
	 return true;
}

bool decrypt(char c[]){
    bool found = false; 
	 int i =0;
  
	 if(strlen(orig) > strlen(c))
       return false;
	
    for( i=0;c[i];i++){
	 	  //cout << "CAME HERE " << endl;
	     if(check_substring_match(c+i)){
		      found = true; 
	 	      //cout << "CAME HERE AGAIN= " << (c+i) << endl;
		      break;
		  }
    }
  
     if(found == true){ 

     	/*for(int j=0; j < 128;j++){
        alpha[j]=0;
    	}*/
		reset_alpha();

		for(int j=0; orig[j]  ; j++){
		   if((orig[j] != ' ') && (alpha[c[j+i]] != 0 && (alpha[c[j+i]] != orig[j]) ) ){
				
			   //cout << "MAP AGAIN " << c[j+i] << " -> " << orig[j] << endl;
				return false;
			}
		   alpha[c[j+i]] = orig[j];
			//cout << "MAP " << c[j+i] << " -> " << orig[j] << endl;
		}
     
	 	/*//Checking if the decryption actually works 
    	for(int j=i;c[j];j++){
        if(alpha[c[j]]!=orig[j] && alpha[c[j]]){
		      cout << "SHOULD NOT COME HERE " << endl;
            return false;
        }
        else{
            alpha[c[j]]=orig[j];
        }
       
      }*/
		return true;
	 }
    return false;
   
}

int main() {
string c;
int t;
cin>>t;
int num;
//getchar();
//getchar();
getline(cin,c);
getline(cin,c);

while(t--){
	//getchar();
	//getchar();
	clear_sentences();


	int flag=0;

// Read each sentence 
   num=0;
	while(getline(cin,c)){

      //cout << "SENTENCE = " << c << endl;
		//cout << "SIZE=" << c.size() << endl;

		if(c.size() <= 1 ){
		   //cout << "HAPPENED " << endl;
			break;
		}

		for(int i=0;i< c.size();i++)
			sen[num][i]=c[i];

   	num++;
   	//c="";
		c.clear();
	}
	//cout << "NUM=" << num << endl;


	for(int i=0;i<num;i++){
  		if(decrypt(sen[i])){
      	flag=1;
			//cout << "SENTENCE=" << sen[i] << endl;
      	break;
  		}
	}

	if(!flag)
		cout<<"No solution." << endl;
	else{
   	for(int i=0;i<num;i++){
          //cout << endl;
			 //cout << "SENTENCE=" << sen[i] << endl;
      	 for(int j=0;sen[i][j];j++){
			 	 if(isalpha(sen[i][j])){
          	 cout<<alpha[sen[i][j]];
				 }else{
          	 	cout<<sen[i][j];
				 }
       	}
       	cout<<endl;
   	}
	}

	if(t>0)
     cout<<endl;
}


return 0;
}