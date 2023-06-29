#include <stdio.h>
#include <string.h>
#include <math.h>

typedef struct photo_record {
   char carnum[24];
   int month;
   int day;
   int hour;
   int mm;
   int time;
   char type[6];
   int gate;
}record;

int main(void) {
   int cases, i, j, count = 0, k;
   char line, data[50];
   int fare[24];
   char result[1000][50];
   char ctemp[50];
   record rec[1000];
   record temp;
   double fee[1000];
   double inttemp;
   int n;
   scanf("%d", &cases);
   scanf("%c", &line);

   while (cases != 0) {
      for (i = 0; i < 24; i++)
         scanf("%d ", &fare[i]);
     count = 0; 
      while (gets(data) && strlen(data) != 0) {
         sscanf(data, "%s %d:%d:%d:%d %s %d", rec[count].carnum, &rec[count].month, &rec[count].day, &rec[count].hour, &rec[count].mm, rec[count].type, &rec[count].gate);
         rec[count].time = (rec[count].day * 10000) + (rec[count].hour * 100) + rec[count].mm;

         count++;

      }

      
      for (i = 0; i < count; i++) {
         for (j = 0; j < count; j++) {
            if (rec[i].time < rec[j].time) {
               temp = rec[i];
               rec[i] = rec[j];
               rec[j] = temp;
            }
         }
      }
      k = 0;
      for (i = 0; i < count; i++) {
         for (j = i; j < count; j++) {
            if (strcmp(rec[i].carnum, rec[j].carnum) == 0) {
               if (strcmp(rec[i].type, rec[j].type) == 0)
                  continue;
               else if (strcmp("enter", rec[i].type) == 0 && strcmp("exit", rec[j].type) == 0) {
                  strcpy(result[k], rec[i].carnum);
                  fee[k] = (double)(fare[rec[i].hour] * abs(rec[j].gate - rec[i].gate) + 300) / 100;
                  k++;
                  break;
               }
            }
         }

      }

      for (i = 0; i < k; i++) {
         for (j = 0; j < k; j++) {
            if (strcmp(result[i], result[j]) < 0) {
               strcpy(ctemp, result[i]);
               strcpy(result[i], result[j]);
               strcpy(result[j], ctemp);

               inttemp = fee[i];
               fee[i] = fee[j];
               fee[j] = inttemp;
            }
         }
      }

      for (i = 0; i < k; i++) {
         printf("%s $%.2lf\n", result[i], fee[i]);
      }
      printf("\n");
			for(i=0;i<k;i++){
				for(j=0;j<1000;j++)
					result[i][j] = '\0';
			}
		 	for(i=0;i<count;i++){
				for(j=0;j<1000;j++){
					rec[i].carnum[j] = '\0';
					rec[i].type[j] = '\0';
				}
			}


      cases--;
   }
}