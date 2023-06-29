import java.util.Scanner;

public class Main {
   public static void main(String args[]) {
      Scanner scan= new Scanner(System.in);
      int card[]=new int[52];
      int card2[]=new int[52];
      int t = scan.nextInt();
      scan.nextLine();
      for(int T=0;T<t;T++) {
         for(int i=0;i<52;i++)
            card[i]=i;
         int N=scan.nextInt();
         int card_suffle[][]=new int[N][52];
         scan.nextLine();
         for(int n=0;n<N;n++) 
            for(int i=0;i<52;i++) 
               card_suffle[n][i]=scan.nextInt();
         scan.nextLine();
         int cnt=0;
         while(scan.hasNextLine()) {
            String s = scan.nextLine();
            if(s.equals("")) break;
            int input = Integer.parseInt(s);
            for(int i=0;i<52;i++) {
            	if(cnt%2==0)
            		card2[i]=card[card_suffle[input-1][i]-1];
            	else
                    card[i]=card2[card_suffle[input-1][i]-1];
            }
            cnt++;
         }
         print(cnt%2==0? card:card2);
				System.out.println();
      }
   }
   static void print(int card[]) {
      for(int i=0;i<52;i++) {
         if(card[i]/13==0) {
            if(card[i]%13==9)
               System.out.println("Jack of Clubs");
            else if(card[i]%13==10)
               System.out.println("Queen of Clubs");
            else if(card[i]%13==11)
               System.out.println("King of Clubs");
            else if(card[i]%13==12)
               System.out.println("Ace of Clubs");
            else
               System.out.println((card[i]+2)%13+" of Clubs");
         }
         if(card[i]/13==1) {
            if(card[i]%13==9)
               System.out.println("Jack of Diamonds");
            else if(card[i]%13==10)
               System.out.println("Queen of Diamonds");
            else if(card[i]%13==11)
               System.out.println("King of Diamonds");
            else if(card[i]%13==12)
               System.out.println("Ace of Diamonds");
            else
               System.out.println((card[i]+2)%13+" of Diamonds");
         }
         if(card[i]/13==2) {
            if(card[i]%13==9)
               System.out.println("Jack of Hearts");
            else if(card[i]%13==10)
               System.out.println("Queen of Hearts");
            else if(card[i]%13==11)
               System.out.println("King of Hearts");
            else if(card[i]%13==12)
               System.out.println("Ace of Hearts");
            else
               System.out.println((card[i]+2)%13+" of Hearts");
         }
         if(card[i]/13==3) {
            if(card[i]%13==9)
               System.out.println("Jack of Spades");
            else if(card[i]%13==10)
               System.out.println("Queen of Spades");
            else if(card[i]%13==11)
               System.out.println("King of Spades");
            else if(card[i]%13==12)
               System.out.println("Ace of Spades");
            else
               System.out.println((card[i]+2)%13+" of Spades");
         }
      }
   }
}
//2 1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 52 51