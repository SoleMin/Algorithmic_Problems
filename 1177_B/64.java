//package test_1177a;

import java.util.Scanner;


import java.util.Scanner;

    public class test1177b{
        public  static  void main(String[] args){
            Scanner sc = new Scanner(System.in);
            long k =  sc.nextLong();
            long k1 =0,k2 = 0;
            long p = 1;
            String str="";
            for (int i=1; i<=12;i++){
                if (k>= k1 && k <= k1 + p * 9 *i){
                    // Нашли порядок
                    long kk = ((k - k1) % i);

                    k2 = p  + (k - k1) / i -1;
                    if (kk != 0) k2 ++;
                    str =""+ k2;
                    if(str.length() > i) {
                        k2--;
                        str =""+ k2;
                        kk =0;
                    }
                    if(kk > 0){
                        System.out.println(str.charAt((int)kk-1));
                    }else{
                        System.out.println(str.charAt(i-1));
                    }
                    break;
                }else {
                    k1 += p * 9 *i;
                    p = p * 10;
                }
            }

        }
    }
