#include<iostream>
#include<cmath>

using namespace std;

static int check[100];
static double dot[100][2], minval[100], result;

int main()
{
   int Testcase;
   
   cin>>Testcase;
   
   for(int i=0;i<Testcase;i++)
   {
      int num,check[100]={0},Sel;
      double dot[100][2], minval[100], result=0;
      
      cin >> num;
      for(int y=0;y<num;y++)
      {
         cin >> dot[y][0] >> dot[y][1];
      }
      
      check[0]=1;
      for(int j=1;j<num;j++)
      {
         minval[j]=sqrt(pow(dot[0][0]-dot[j][0], 2)+pow(dot[0][1]-dot[j][1], 2));
      }
      for(int j=0;j<num-1;j++)
      {
         Sel = -1;
         for(int k=0;k<num;k++)
         {
            if(check[k] == 1)
               continue;
            if(Sel == -1 || minval[Sel] > minval[k])
               Sel=k;
         }
         result += minval[Sel];
         check[Sel]=1;
         
         for(int k=0;k<num;k++)
         {
            if(check[k]==1)
               continue;
            if(minval[k]>sqrt(pow(dot[Sel][0]-dot[k][0], 2)+pow(dot[Sel][1]-dot[k][1], 2)))
               minval[k]=sqrt(pow(dot[Sel][0]-dot[k][0], 2)+pow(dot[Sel][1]-dot[k][1], 2));
         }
      }
      
      if(i>0)
         cout<<endl;
      cout<<fixed;
      cout.precision(2);
      cout<<result<<endl;
   }
   
   return 0;
}