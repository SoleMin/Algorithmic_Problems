#include <iostream>
#include<sstream>
#include<algorithm>
#include<cmath>
using namespace std;
#define highcard 0
#define onepair 1
#define twopair 2
#define threecards 3
#define straight 4
#define flush 5
#define fullhouse 6
#define fourcards 7
#define straightflush 8

#define tie 0
#define blackwin 1
#define whitewin 2

#define base 15
#define cards 5

#ifndef DEBUG_MODE

#endif

#ifdef DEBUG_MODE
string type[straightflush +1]={"highcard","onepair","twopair","threecards","straight","flush","fullhouse","fourcards","straightflush"};
#endif

int con(char a){
	string card="23456789TJQKA";
	for(int j=0;j<card.length();j++)
		if(a==card[j])
			return (j+2);
	
	
}
	

bool compare(int x,int y){
	return x>y;
}

void sorts(string hand[],int *c){
	for(int j=0;j<cards;j++)
		c[j]=con(hand[j][0]);
	
	sort(c,c+cards,compare);
}

long long unsigned getscore(int*c,int t){
	long long unsigned s=0;
	for(int j=0;j<cards;j++)
		s=s*base+c[j];
	
	return s*pow(base,t);
}

void swap(int &x,int &y){
	int temp=x;
	x=y;
	y=temp;
}

long long unsigned cardtype(int *c,int t,string hand[]){
	bool flags;
	char suits;
	
	switch(t){
		case highcard:
			return getscore(c,highcard);
			
		case onepair:
			for(int j=0;j<cards;j++)
				if(c[j]==c[j+1]){
					if(j>0){
						swap(c[j],c[0]);
						swap(c[j+1],c[1]);
					}
					return getscore(c,onepair);
				}
			break;
			
		case twopair:
			for(int j=0;j<cards-2;j++)
				if(c[j]==c[j+1]){
					for(int k=j+2;k<cards;k++)
						if(c[k]==c[k+1]){
							if(j>0){
								swap(c[j],c[0]);
								swap(c[j+1],c[1]);
							}
							if(k>2){
								swap(c[k],c[2]);
								swap(c[k+1],c[3]);
							}
							return getscore(c,twopair);
						}
				}
				break;
				case threecards:
				for(int j=0;j<cards-2;j++)
					if(c[j]==c[j+2]){
						if(j>0)
						{
				swap(c[j],c[0]);
							swap(c[j+1],c[1]);
							swap(c[j+2],c[2]);
						}					
						return getscore(c,threecards);

					}
				break;
				
				case straight:
				flags=true;
				for(int j=0;j<cards-1;j++)
					if(c[j]!=(c[j+1]+1)){
						
					
						flags=false;
						break;
					}
				if(flags)
					return getscore(c,straight);
				break;
				case flush:
				flags=true;
				suits=hand[0][1];
				for(int j=1;j<cards;j++)
					if(suits!=hand[j][1]){
						flags=false;
						break;
					}
				if(flags)
					return getscore(c,flush);
				break;
				
				case fullhouse:
				if(c[0]==c[2]&&c[3]==c[4])
					return getscore(c,fullhouse);
				if(c[0]==c[1]&&c[2]==c[4]){
					swap(c[2],c[0]);
					swap(c[3],c[1]);
					swap(c[4],c[2]);
					return getscore(c,fullhouse);
				}
				break;
				case fourcards:
				for(int j=0;j<cards-3;j++)
					if(c[j]==c[j+3]){
						if(j>0){
							swap(c[j],c[0]);
							swap(c[j+1],c[1]);
							swap(c[j+2],c[2]);
							swap(c[j+3],c[3]);
						}
						return getscore(c,fourcards);
					}
				break;
				case straightflush:
				if(cardtype(c,straight,hand)&&cardtype(c,flush,hand))
					return getscore(c,straightflush);
				break;
			}
			return 0;
	}

	long long unsigned getvalue(string hand[]){
		int car[5];
		sorts(hand,car);
		
		long long unsigned val=0;
		for(int j=8;j>=0;j--){
			val=cardtype(car,j,hand);
			if(val)
			{
				#ifdef DEBUG_MODE
				cout<<endl;
				cout<<"<Debug Begin>"<<endl;
				for(int k=0;k<cards;k++)
					cout<<hand[k]<<" ";
				cout<<endl;
				for(int k=0;k<cards;k++)
					cout<<car[k]<<" ";
				cout<<endl;
				cout<<"Card Type: "<<type[j]<<endl;
				cout<<"Value: "<<val<<endl;
				cout<<"<Debug End>"<<endl;
				cout<<endl;
				#endif
				
				return val;
			}
		}

	}
	
	int cardcompare(string fhand[],string shand[]){
		long long unsigned fval,sval;
		fval=getvalue(fhand);
		sval=getvalue(shand);
		return(fval==sval)?(tie):((fval>sval)?(blackwin):(whitewin));
		
	}
	
	int main(){
		string fhand[5],shand[5],l;
		string details[3]={"Tie.","Black wins.","White wins."};
		while(getline(cin,l)){
			istringstream iss(l);
			
			for(int j=0;j<5; j++){
				iss>>fhand[j];
			}
				for(int k=0;k<5;k++){
				iss>>shand[k];	
				}
			cout<<details[cardcompare(fhand,shand)]<<endl;
			
			}
		return 0;
		}
		

	
	
	