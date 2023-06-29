# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys;
while(1):
	input = sys.stdin.readline().rstrip()
	if (len(input) == 0):
		break;
		
	if(input[0] =='0'):
		hexNum = int(input, 16)
		print(hexNum)
	else:
		decNum = hex(int(input))
		print(decNum[0:2] + decNum[2:].upper())
		
	
		