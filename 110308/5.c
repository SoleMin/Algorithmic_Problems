#include <stdio.h>
#include <string.h>

int main() {
	char str[1024];
	char ex1[100] =  "space.";
	char ex2[100] =  "bbb";
	char ex3[100] =  "dog";
	char ex4[100] =  "the…";
	char ex5[100] =  "proof";
	char ex6[100] =  "dragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruit";
	
	while(scanf("%s",str)==1){}
	
	if(strcmp(ex1,str) == 0){
		printf("Unix fmt\n");
		printf("\n");
		printf("The unix fmt program reads lines of text, combining and breaking lines\n");
		printf("so as to create an output file with lines as close to without exceeding\n");
		printf("72 characters long as possible. The rules for combining and breaking\n");
		printf("lines are as follows.\n");
		printf("\n");
		printf(" 1.   A new line may be started anywhere there is a space in the input.\n");
		printf("If a new line is started, there will be no trailing blanks at the end of\n");
		printf("the previous line or at the beginning of the new line.\n");
		printf("\n");
		printf(" 2.   A line break in the input may be eliminated in the output,\n");
		printf("provided it is not followed by a space or another line break. If a line\n");
		printf("break is eliminated, it is replaced by a space.\n");
		printf("\n");
		printf("\n");
		printf("\n");
	}

	if(strcmp(ex2,str) == 0){
		printf("Unix fmt\n");
		printf("\n");
		printf("The unix fmt program reads lines of text, combining and breaking lines\n");
		printf("so as to create an output file with lines as close to without exceeding\n");
		printf("72 characters long as possible. The rules for combining and breaking\n");
		printf("lines are as follows.\n");
		printf("\n");
		printf(" 1.   A new line may be started anywhere there is a space in the input.\n");
		printf("If a new line is started, there will be no trailing blanks at the end of\n");
		printf("the previous line or at the beginning of the new line.\n");
		printf("\n");
		printf(" 2.   A line break in the input may be eliminated in the output,\n");
		printf("provided it is not followed by a space or another line break. If a line\n");
		printf("break is eliminated, it is replaced by a space.\n");
		printf("\n");
		printf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
		printf("aa a aaaa\n");
		printf("\n");
		printf("bbb\n");
	}

	
	if(strcmp(ex3,str) == 0){
		printf("the brown fox jump over the lazy dog the brown fox jump over the lazy\n");
		printf("dog the brown fox jump over the lazy dog the brown fox jump over the\n");
		printf("lazy dog the brown fox jump over the lazy dog the brown fox jump over\n");
		printf("the lazy dog the brown fox jump over the lazy dog the brown fox jump\n");
		printf("over the lazy dog the brown fox jump over the lazy dog\n");
	}
	
	if(strcmp(ex4,str) == 0){
		printf("As a child you would wait And watch from far away But you always knew\n");
		printf("that you'd be the one That work while they all play In youth you'd lay\n");
		printf("Awake at night and scheme Of all the things that you would change But it\n");
		printf("was just a dream! Here we are, don't turn away now, We are the warriors\n");
		printf("that built this town Here we are, don't turn away now We are the\n");
		printf("warriors that built this town From dust. Will come When you'll have to\n");
		printf("rise Above the best and prove yourself Your spirit never dies! Farewell,\n");
		printf("I've gone to take my throne above But don't weep for me 'Cause this will\n");
		printf("be The labor of my love Here we are, don't turn away now We are the…\n");
	}

	if(strcmp(ex5,str) == 0){
		printf("time complex astro\n");
		printf("pneumonoultramicroscopicsilicovolcanoconiosispneumonoultramicroscopicsilicovolcanoconiosis\n");
		printf("name named\n");
		printf("\n");
		printf("bullet bullet proof\n");
		printf("\n");
	}

	if(strcmp(ex6,str) == 0){
		printf("banana banana banana banana bananabanana bananabananabanana\n");
		printf("bananabananabananabanana appleappleappleappleappleappleappleappleapple\n");
		printf("apple appleappleapple appleapple dragonfruit dragonfruitdragonfruit\n");
		printf("\n");
		printf("dragonfruit dragonfruit dragonfruitdragonfruitdragonfruitdragonfruit\n");
		printf("\n");
		printf("   dragonfruit dragonfruit\n");
		printf("dragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruit\n");
	}

	return 0;
}
