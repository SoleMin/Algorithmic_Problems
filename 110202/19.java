import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] arrayBlack = new String[5];
            String[] arrayWhite = new String[5];

            String[] shapeBlack = new String[5];
            String[] shapeWhite = new String[5];
            int[] numBlack = new int[5];
            int[] numWhite = new int[5];
            int additionBlack =0;
            int additionWhite =0;

            String s = input.nextLine();
            String[] array = s.split(" ");

            for (int i = 0; i < array.length; i++) {
                if (i <5 ) {
                    arrayBlack[i] = array[i];
                } else {
                    arrayWhite[i-5] = array[i];
                }
               
            }

            String[] temp = SplitArrayNumsAndShape(arrayBlack);
            //black cards
            
            for (int i = 0; i < temp.length; i++) {
                if (i%2==0) {
                    if (temp[i].equals("T") ||temp[i].equals("J")||temp[i].equals("Q") ||temp[i].equals("K") ||temp[i].equals("A")) {
                    if(temp[i].equals("T"))
                        numBlack[i/2] = 10;
                    if(temp[i].equals("J"))
                        numBlack[i/2] = 11;
                    if(temp[i].equals("Q"))
                        numBlack[i/2] = 12;
                    if(temp[i].equals("K"))
                        numBlack[i/2] = 13;
                    if(temp[i].equals("A"))
                        numBlack[i/2] = 14;
                    } else{
                        numBlack[i/2] = Integer.parseInt(temp[i]);
                    }

                } else{
                    if (temp[i].equals("C")) {
                        shapeBlack[(i-1)/2] = "C";
                    }
                    if (temp[i].equals("D")){
                        shapeBlack[(i-1)/2] = "D";

                    }
                    if (temp[i].equals("H")){
                        shapeBlack[(i-1)/2] = "H";

                    }
                    if (temp[i].equals("S")){
                        shapeBlack[(i-1)/2] = "S";

                    }
                }
            }

            //white cards
            temp =  SplitArrayNumsAndShape(arrayWhite);
          
            for (int i = 0; i < temp.length; i++) {
                if (i%2==0) {
                    if (temp[i].equals("T") ||temp[i].equals("J")||temp[i].equals("Q") ||temp[i].equals("K") ||temp[i].equals("A")) {
                    if(temp[i].equals("T"))
                        numWhite[i/2] = 10;
                    if(temp[i].equals("J"))
                        numWhite[i/2] = 11;
                    if(temp[i].equals("Q"))
                        numWhite[i/2] = 12;
                    if(temp[i].equals("K"))
                        numWhite[i/2] = 13;
                    if(temp[i].equals("A"))
                        numWhite[i/2] = 14;
                    } else{
                        numWhite[i/2] = Integer.parseInt(temp[i]);
                    }

                } else{
                    if (temp[i].equals("C")) {
                        shapeWhite[(i-1)/2] = "C";
                    }
                    if (temp[i].equals("D")){
                        shapeWhite[(i-1)/2] = "D";
                    }
                    if (temp[i].equals("H")){
                        shapeWhite[(i-1)/2] = "H";
                    }
                    if (temp[i].equals("S")){
                        shapeWhite[(i-1)/2] = "S";
                    }
                }
            }

            if (checkCard(shapeBlack, numBlack) > checkCard(shapeWhite, numWhite) ) {
                System.out. println("Black wins.");
            } 
            if (checkCard(shapeBlack, numBlack) < checkCard(shapeWhite, numWhite) ) {
                System.out.println("White wins.");
            }
            if (checkCard(shapeBlack, numBlack) == checkCard(shapeWhite, numWhite)){
                if (additionWhite == additionBlack && numBlack[4]== numWhite[4]&&numBlack[1]== numWhite[1]&&numBlack[3]== numWhite[3]&&numBlack[2]== numWhite[2]&&numBlack[0] == numWhite[0]) {
                    System.out.println("Tie.");
                } else{
                    System.out.println(result(numBlack, numWhite));

                }
                
            }
        }
    }
    static private String result(int[] black, int[] white) {
        for (int i = 0; i < 5; i++) {
            if (black[4-i] > white[4-i]) {
                return "Black wins.";
            }
            if (black[4-i] < white[4-i]) {
                return "White wins.";
            }

        }
        return "Tie.";
        
    }

     static int checkCard(String[] shape, int[] num){
        Arrays.sort(num);
        if ( (num[0] == num[1] -1 && num[1] == num[2] -1 && num[2] == num[3] -1 && num[3] == num[4] -1)  && (isSameShape(shape)))  {
            return 9;//stp
        }
        if (isFourCard(num)) {
            return 8;
        }
        if (isFullHouse(num)) {
            return 7;
        }
        if (isFlush(shape)) {
            return 6;
        }
        if (isStraight(num)) {
            return 5;
        }
        if (isTri(num)) {
            return 4;
        }
        if (isTwo(num)) {
            return 3;
        }
        if (isOne(num)) {
            return 2;
        }
        return 1;
    }

    private static boolean isOne(int[] num) {
        if (num[0] == num[1] || num[1] == num[2] || (num[2] == num[3] || num[3] == num[4])) {
            return true;
        } else{
            return false;
        }
    }
    private static boolean isTwo(int[] num) {
        if ((num[0] == num[1] && num[1] == num[2]) || (num[2] == num[3] && num[3] == num[4])) {
            return true;
        } else{
            return false;
        }
    }
    private static boolean isTri(int[] num) {
        if ((num[0] == num[1] && num[1] == num[2] && num[2] == num[3]) || (num[1] == num[2] && num[2] == num[3] && num[3] == num[4])) {
            return true;
        } else{
            return false;
        }
    }
    private static boolean isStraight(int[] num) {
        if ((num[0] == num[1] -1 && num[1] == num[2] -1 && num[2] == num[3] -1 && num[3] == num[4] -1) ) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isFlush(String[] shape) {
        if (isSameShape(shape)){
            return true;
        } else {
            return false;
            
        }
    }
    private static boolean isFullHouse(int[] num) {
        if ((num[0] == num[1] && num[2] == num[3] && num[3] == num[4]) ||  (num[4] == num[3] && num[2] == num[1] && num[1] == num[0])) {
            return true;
        } else {
           return false;
        }
    }
    private static Boolean isFourCard(int[] num) {
            if (num[0] == num[1] && num[1] == num[2] && num[2] == num[3] || num[1] == num[2] &&num[2] == num[3] && num[3] == num[4]) {
                return true;
            } else {
                return false;
            }
    }

    static String[] SplitArrayNumsAndShape(String[] card){
        String[] temp2 = new String[2];
        String[] temp = new String[10];
        int temp3 = 0;
        for (int i = 0; i < 5; i++) {
                temp2 = card[i].split("");
            for (int j = 0; j+1+temp3 < 10; j = j+2) {
                temp[j+temp3] = temp2[0];
                temp[j+1+temp3] = temp2[1];
            }
            temp3 = temp3 +2;
        }
        return temp;
    
    }
    static private Boolean isSameShape(String[] shape){
        return (shape[0].equals(shape[1]) && shape[1].equals(shape[2]) && shape[2].equals(shape[3]) && shape[3].equals(shape[4]));
    }
}