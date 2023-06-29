import java.util.Scanner;

public class Main {

   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int Testcase = scan.nextInt();
      scan.nextLine();
      scan.nextLine();
      for (int t = 0; t < Testcase; t++) {
         int Rows = scan.nextInt();
         int Columns = scan.nextInt();
         scan.nextLine();
         char grid[][] = new char[Rows][Columns];
         for (int i = 0; i < Rows; i++) {
            String line = scan.nextLine();
            String linetolower = line.toLowerCase();
            for (int j = 0; j < Columns; j++)
               grid[i][j] = linetolower.charAt(j);
         }
         int k = scan.nextInt();
         scan.nextLine();
         String[] search = new String[k];
         for (int index = 0; index < k; index++) {
            search[index] = scan.nextLine();
            String tolower = search[index].toLowerCase(); // 입력을 소문자로 변형
            int x = 1000, y = 10000, count = 0;
            for (int i = 0; i < Rows; i++)
               for (int j = 0; j < Columns; j++)
                  if (grid[i][j] >= 65 && grid[i][j] <= 90)
                     grid[i][j] = (char) (grid[i][j] + 32); // 그리드를 소문자로
            for (int i = 0; i < Rows; i++) {
               for (int j = 0; j < Columns; j++) {
                  if (grid[i][j] == tolower.charAt(0)) {
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 수직 검사
                        if (i + l >= Rows)
                           break;
                        if (grid[i + l][j] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 수평 검사
                        if (j + l >= Columns)
                           break;
                        if (grid[i][j + l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 우하향 검사
                        if (i + l >= Rows || j + l >= Columns)
                           break;
                        if (grid[i + l][j + l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }

                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 수직(reverse) 검사
                        if (i - l < 0)
                           break;
                        if (grid[i - l][j] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 우상향 검사
                        if (i - l < 0 || j + l >= Columns)
                           break;
                        if (grid[i - l][j + l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 수평(reverse) 검사
                        if (j - l < 0)
                           break;
                        if (grid[i][j - l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 우하향(reverse) 대각선 검사
                        if (i - l < 0 || j - l < 0)
                           break;
                        if (grid[i - l][j - l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                     count = 0;
                     for (int l = 1; l < tolower.length(); l++) { // 우상향(reverse) 검사
                        if (i + l >= Rows || j - l < 0)
                           break;
                        if (grid[i + l][j - l] != tolower.charAt(l)) {
                           break;
                        } else {
                           if (++count == tolower.length() - 1)
                              if (i < x) {
                                 x = i;
                                 y = j;
                              }
                        }
                     }
                  }
               }
            }
            System.out.println((x + 1) + " " + (y + 1));
         }
         System.out.println();
      }
   }
}// 회귀 사용?? 불가.
//입력 받고 단어 검사 할때 앞글자가 동일하면 우측,하단,대각선이 같은지 검사. 
/*
 * 1
 * 
 * 8 11 abcDEFGhigg hEbkWalDork FtyAwaldORm FtsimrLqsrc byoArBeDeyv Klcbqwikomk
 * strEBGadhrb yUiqlxcnBjf 1 Dagbert
 * 
 */