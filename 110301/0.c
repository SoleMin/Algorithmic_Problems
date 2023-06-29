#include <stdio.h>
#include <string.h>
int main() {
	char keyBoard1[] = "`1234567890-=";
	char keyBoard2[] = "QWERTYUIOP[]\\";
	char keyBoard3[] = "ASDFGHJKL;'";
	char keyBoard4[] = "ZXCVBNM,./";
	char buf[128] = "";
	while(1)
	{
		if(fgets(buf, 128, stdin) == NULL)
			break;
		for (int i = 0; buf[i] != '\0'; i++)
			if (buf[i] == ' ')
				printf(" ");
			else if (strchr(keyBoard1, buf[i]) != NULL)
				printf("%c", *(strchr(keyBoard1, buf[i]) - 1));
			else if (strchr(keyBoard2, buf[i]) != NULL)
				printf("%c", *(strchr(keyBoard2, buf[i]) - 1));
			else if (strchr(keyBoard3, buf[i]) != NULL)
				printf("%c", *(strchr(keyBoard3, buf[i]) - 1));
			else if (strchr(keyBoard4, buf[i]) != NULL)
				printf("%c", *(strchr(keyBoard4, buf[i]) - 1));
		printf("\n");
	}
}
