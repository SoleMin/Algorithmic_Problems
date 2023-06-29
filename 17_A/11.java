
import java.util.ArrayList;
import java.util.Scanner;



public class primes {

public static void main(String []  args){

ArrayList<Integer> numb=new ArrayList<Integer>();
Scanner br1 = new Scanner(System.in);
int n=br1.nextInt();
int steps=br1.nextInt();
//if(n>2)numb.add(2);
if(n>=3)numb.add(3);
for(int j=4;j<=n;j++){
if(chekprime(j)==0){

numb.add(j);
//System.out.println(j);
}

}
int counter =0;
for(int give=0;give<numb.size();give++)
{if("YES".equals(sumup(numb, 2, numb.get(give)))){
 counter++;
// System.out.println(numb.get(give)+"ksjdfskldfgaskldfgasklfgaskldfgaklsfgasdklfgaskldfgaskldfgasdklfg");
 }



}

//System.out.println(counter);
if(counter>=steps)System.out.println("YES");
else System.out.println("NO");


}

public static String sumup(ArrayList<Integer> list,int number,int NUM){

String ret="NO";
    ArrayList<Integer> result=new ArrayList<Integer>();

ArrayList<Integer>[] arList=new ArrayList[number];
for(int i=0;i<number;i++){
arList[i]=new ArrayList<Integer>();
arList[i]=(ArrayList<Integer>)list.clone();
for(int k=0;k<i;k++){
arList[i].add(0,arList[i].remove(arList[i].size()-1));
}

}


    int [] temp=new int[list.size()];
    
for(int z=0;z<list.size();z++){
    for(int count=0;count<number;count++){
        
temp[z]+=arList[count].get(z);
//System.out.println(arList[count].get(z));
    }

result.add(temp[z]);

}

if(result.contains(NUM-1))
{    //System.out.println(NUM-1);
ret="YES";
}
return ret;
}



public static int chekprime(int n){
int flag=0;

for(int i=2;i<=Math.sqrt(n)+1;i++)
{
if(n%i==0){
flag=1;
break;
}

} 

return flag;

}
}
