#include <stdio.h>
#include <string.h>

int main(void) {
   int cases, linenum = 0;
   char line[100][80], result[100][80];
   char code[] = "the quick brown fox jumps over the lazy dog";
   char decode[43];
   int i, j, k;
   char line1;
   int temp, temp1;

   scanf("%d", &cases);
   scanf("%c", &line1);
   scanf("%c", &line1);

   while (cases != 0) {

      for (i = 0; i < 100; i++) {
         for (j = 0; j < 80; j++) {
            scanf("%c", &line[i][j]);
            if (line[i][j] == '\n') {
               line[i][j] = '\0';
               break;
            }
         }
         if (line[i][0] == '\0') {
            temp = i;
            break;
         }   
      }
      for (i = 0; i < temp; i++) {
         if (strlen(line[i]) == strlen(code)) {
            for (k = 0; k <= 43; k++) {
               if (line[i][k] == ' ' && code[k] != ' ')
                  break;
               if (line[i][k] == '\0' && code[k] == '\0') {
                  for (j = 0; j < strlen(line[i]); j++)
                     decode[j] = line[i][j];
               }
            }
         }
      }
      for (i = 0; i < temp; i++) {
         for (j = 0; j < strlen(line[i]); j++) {
            for (k = 0; k <=43; k++) {
               if (line[i][j] == decode[k]) {
                  line[i][j] = code[k];
                  break;
               }
            }
         }
      }
      for (i = 0; i < temp; i++) {
         if (strlen(line[i]) == strlen(code)) {
            for (j = 0; j <= 43; j++) {
               if (line[i][j] == code[j]) {
                  temp1 = 1;
               }
               else if (line[i][j] != code[j]) {
                  if (temp1 == 0)
                     break;
                  else {
                     temp1 = 0;
                     break;
                  }
               }
            }
         }
      }

      if (temp1 != 1)
         printf("No solution.\n");
      else {
         for (i = 0; i < temp; i++) {
            printf("%s\n", line[i]);
         }
      }
      printf("\n");
      cases--;
      temp = 0;
      for (i = 0; i < 100; i++) {
         for (j = 0; j < 80; j++) {
            line[i][j] = '\0';
         }
      }
      for (i = 0; i < 43; i++) {
         decode[i] = '\0';
      }
   }

}