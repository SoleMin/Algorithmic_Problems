#include<cstring>
#include<algorithm>
#include<cstdio>
#include<cmath>
#include<iostream>
using namespace std;


int main()
{
    int t;
    cin>>t;
    getchar();
    getchar();
    while(t--){
        int num;
        int sum=0;
        cin>>num;
        //if(num>1000)
        //{
          //  break;
        //}
        int a[num];
        
        for(int i=0;i<num;i++){
            cin>>a[i];
        }
        sort(a,a+num);
        int z=num;
        while (z>=4){
            
            sum=sum+min(a[0]*2+a[z-1]+a[z-2],a[0]+a[1]*2+a[z-1]);
            z=z-2;
        }
        if(z==3){
            sum=sum+a[0]+a[1]+a[2];
        }
        else if(z==2){
            sum=sum+a[1];
        }
        else{
            sum=sum+a[0];
        }
        
        cout<<sum;
        cout<<endl;
        
        /*while(num>=4){
        if(2*a[0]+a[num-1]+a[num-2]< a[0]+a[1]*2+a[num-1]){
        cout<<a[0]<<" "<<a[num-1];
        cout<<endl;
        cout<<a[0]<<endl<<a[0]<<" "<<a[num-2]<<endl<<a[0];
        cout<<endl;
        }
        else{
            cout<<a[0]<<" "<<a[1];
        cout<<endl;
        cout<<a[0]<<endl<<a[num-2]<<" "<<a[num-1]<<endl<<a[1];
        cout<<endl;
        }
        num=num-2;
        }
        if(num==1){
            cout<<a[0]<<endl;
        }
        else if(num==2){
            cout<<a[0]<<" "<<a[1]<<endl;
        }
        
        else if(num==3){
            cout<<a[0]<<" "<<a[1]<<endl;
            cout<<a[0]<<endl;
            cout<<a[0]<<" "<<a[2]<<endl;
        }*/
        if(t>0){
            cout<<"\n";
        }
        
    }

    return 0;
}
