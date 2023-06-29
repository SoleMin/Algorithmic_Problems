
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	 public static class hanoicalac{
        int hn,h4n;
       BigInteger[] hanoi = new BigInteger[10001];
       BigInteger[] hanoi4 = new BigInteger[10001];

        public void calchanoi(int n){
            for(;hn<=n;hn++){
                hanoi[hn] = hanoi[hn-1].add(hanoi[hn-1]);
                hanoi[hn] = hanoi[hn].add(BigInteger.valueOf(1));
            }
        }

        public void solve(int n){
            int k;
            BigInteger temp;
            for(;h4n<=n;h4n++){
                hanoi4[h4n]=hanoi4[h4n-1].add(hanoi4[h4n-1]);
                hanoi4[h4n]=hanoi4[h4n].add(hanoi[1]);
                for(k=h4n-2;k>0;k--){
                    calchanoi(h4n-k);
                    temp=hanoi4[k].add(hanoi4[k]);
                    temp=temp.add(hanoi[h4n-k]);
                    if(hanoi4[h4n].compareTo(temp)==1)
                        hanoi4[h4n]=temp.add(BigInteger.valueOf(0));
                    else
                        break;
                }
            }
        }
    }
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
        hanoicalac hanoicalac = new hanoicalac();
        hanoicalac.hanoi[1]=BigInteger.valueOf(1);
        hanoicalac.hanoi4[0]=BigInteger.valueOf(0);
        hanoicalac.hanoi4[1]=BigInteger.valueOf(1);
        hanoicalac.h4n=2;
        hanoicalac.hn=2;
        ArrayList<BigInteger> arrayList = new ArrayList<>();

        while (input.hasNextLine()){
            int disk = input.nextInt();
            if(input.hasNextLine())input.nextLine();
            hanoicalac.solve(disk);
            arrayList.add(hanoicalac.hanoi4[disk]);
        }
        for(BigInteger a:arrayList){
            System.out.println(a);
        }

	}
}