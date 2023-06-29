# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys;
while (1):
	input =  sys.stdin.readline()
	if (len(input) == 0):
		break;
	
	low, high = map(int, input.split(" "))
	ansLow = low
	ansHigh = high
	if (low > high):
		tmp = high
		high = low
		low = tmp
	max_length = 0;
	
	for i in range(low, high + 1):
		n = i;
		length = 1
		while(n != 1):
			if (n & 1):
				n = n * 3  + 1
				length += 1
			while(not( n & 1)):
				n = n >> 1
				length += 1
		
		if (length > max_length):
			max_length = length
			
	print(ansLow, ansHigh, max_length)
				
	