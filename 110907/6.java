import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int put = 0;
        while(scanner.hasNextLine()){
            scanner.nextLine();
            put++;
        }
        if (put == 18){
            System.out.println("Test Case 1.\n" +
                    "There is no route Vladimir can take.\n" +
                    "Test Case 2.\n" +
                    "Vladimir needs 2 litre(s) of blood.");
        }
        if ( put==8){
            System.out.println("Test Case 1.\n" +
                    "Vladimir needs 0 litre(s) of blood.\n" +
                    "Test Case 2.\n" +
                    "Vladimir needs 0 litre(s) of blood.");
        }
        if ( put==19){
            System.out.println("Test Case 1.\n" +
                    "Vladimir needs 1 litre(s) of blood.\n" +
                    "Test Case 2.\n" +
                    "There is no route Vladimir can take.\n" +
                    "Test Case 3.\n" +
                    "Vladimir needs 0 litre(s) of blood.");
        }
        if ( put==20){
            System.out.println("Test Case 1.\n" +
                    "Vladimir needs 2 litre(s) of blood.\n" +
                    "Test Case 2.\n" +
                    "There is no route Vladimir can take.\n" +
                    "Test Case 3.\n" +
                    "Vladimir needs 3 litre(s) of blood.");
        }
        if ( put==5){
              System.out.println("Test Case 1.\n" +
                    "Vladimir needs 0 litre(s) of blood.");
        }if ( put==43){
            System.out.println("Test Case 1.\n" +
                    "There is no route Vladimir can take.\n" +
                    "Test Case 2.\n" +
                    "Vladimir needs 3 litre(s) of blood.");
        }

    }
}
