#include <stdio.h>
#include <string.h>

void sort(char a[]) {
   int i;
   int j;
   char temp;
   for (i = 0; i < strlen(a); i++) {
      for (j = i; j < strlen(a); j++) {
         if (a[i] > a[j]) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
         }
      }
   }
}

int main(void) {
   char a[1000], b[1000];
   int count[1000] = { 0, };
   int count1[1000] = { 0, };
   char result[1000];
   char result1[1000];
   char temp;
   int i, j, k,l;

   while (gets(a)) {
      gets(b);
      sort(a);
      for (i = 0; i < strlen(a); i++) {
         for (j = 0; j < strlen(b); j++) {
            if (a[i] == b[j]) {
               count[i] += 1;
            }
         }
      }
      sort(b);
      for (i = 0; i < strlen(b); i++) {
         for (j = 0; j < strlen(a); j++) {
            if (b[i] == a[j]) {
               count1[i] += 1;
            }
         }
      }
      k = 0;
      for (i = 0; i < strlen(a); i++) {
         if (count[i] > 0) {
            result[k] = a[i];
            k++;
         }
      }
      l = 0;
      for (i = 0; i < strlen(b); i++) {
         if (count1[i] > 0) {
            result1[l] = b[i];
            l++;
         }
      }
      if (k > l) {
         for (i = 0; i < l; i++) {
            printf("%c", result1[i]);
         }
      }
      else if (k == l) {
         for (i = 0; i < l; i++) {
            printf("%c", result1[i]);
         }
      }
      else {
         for (i = 0; i < k; i++) {
            printf("%c", result[i]);
         }
      }
      printf("\n");
      k = 0;
      l = 0;
      for (i = 0; i < 1000; i++) {
         a[i] = '\0';
         b[i] = '\0';
         result[i] = '\0';
         result1[i] = '\0';
         count[i] = 0;
         count1[i] = 0;
      }
   }

}