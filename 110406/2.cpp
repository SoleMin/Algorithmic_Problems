#include <iostream>
#include <string>
#include <algorithm>
#include <string.h>


using namespace std;

#define MAX_TAXI_LENGTH 21
#define MAX_RECORDS     1000
#define TOTAL_HOURS     24


struct photo{
    char name[MAX_TAXI_LENGTH];
    int d,h,m,word,distance;
};

int get_abs(int abs){
   if(abs < 0){
	 abs = - abs;
	}

	 return abs;
}

void print_record(photo &rec){
   cout << rec.name << " ";
   cout << rec.d << ":" << rec.h << ":" << rec.m << " ";
	if(rec.word == 0){
		cout << "enter ";
	}else{
		cout << "exit  ";
	}
	cout << rec.distance << endl;
}

void print_records(photo *n,int total){
   cout << "=== PRINT RECORDS .TOTAL = " << total << endl;
   for (int i=0 ; i< total; i++){
	  print_record(n[i]);
	}
}

bool compare(photo &x, photo &y){
    int cmp=strcmp(x.name,y.name);
    if(cmp!=0){
        return cmp < 0;
    }
    if(x.d!=y.d){
        return x.d<y.d;
    }
    if(x.h!=y.h){
        return x.h<y.h;
    }
    if(x.m!=y.m){
        return x.m<y.m;
    }
    return x.word<y.word;
}

void billing(struct photo *n,unsigned int *fare,int total_records){

	for(int i=0 ; i < total_records-1; i++){
		 if(strcmp (n[i].name ,n[i+1].name) !=0){
			    continue;
		} 

		if(n[i].word == 0 && n[i+1].word == 1){
			unsigned distance = get_abs(n[i+1].distance - n[i].distance);
			unsigned total_cents = distance * fare[n[i].h];
			double price = ((double)total_cents /100) + 3.00;
			printf("%s $%.2f\n",n[i].name,price);
		}
	}
}

void work(){
   string c;
   unsigned  fare[TOTAL_HOURS];
   string temp;
	struct photo n[MAX_RECORDS];
	int total_records =0;

   for(int i=0; i < TOTAL_HOURS; i++){
     	cin >> fare[i];
   }

	//cin.ignore();

   //while( getline(cin,c) && c!=""){
   while( getline(cin,c)  ){
	  //cout << "CHAR =" << c << endl;
		if(c.size() > 1){
         char cc[8];
         sscanf(c.c_str(), "%s %*d:%d:%d:%d %s %d", n[total_records].name, &n[total_records].d, &n[total_records].h, &n[total_records].m, cc, &n[total_records].distance);
         n[total_records].word= (cc[1]=='n')?0:1;
         total_records++;
		}
		else{
		  if(c.size() <=1   && total_records > 0){
		    break;
		  }
		}
		c.clear();
   }

	//cout << "TOTAL_RECORDS =" << total_records << endl;

   sort(n,n+total_records,compare);
	//print_records(n,total_records);
	billing(n,fare,total_records);

}


int main()
{
    int t;

    cin>>t;
    getchar();
    getchar();

	 //cout << "TEST CASES = " << t << endl;


    while(t--){


		  //print_records(n,total_records);
		  //print_records(n,total_records);
		  work();

		  if(t >=1){
		   cout << endl;
		  }
    }

    return 0;
}