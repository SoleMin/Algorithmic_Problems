# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys;
while(1):
	data = sys.stdin.readline().rstrip()
	if (len(data) == 0) :
		break
	data = data.lstrip();
	letters = 0
	words = 1
		
	for i in range(0, len(data)):
		if ( data[i] == " " or data[i] == "\t"):
			continue
		if ( data[i-1] == " " or data[i - 1] == "\t" ):
			words += 1;
		letters += 1
		
	
	print("%s %s" % (letters, words))
		

	
