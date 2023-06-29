# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
import math
while(1):
	n = int(sys.stdin.readline())
	if (n == 0):
		break
	arr = [];
	for i in range(n):
		arr.append(float(sys.stdin.readline()))
	
	avg = sum(arr) / float(n)
	
	ans = 0;
	for i in range(n):
		if (arr[i] > avg):
			ans += math.floor((arr[i] - avg) * 100) / 100
	
	
	print("$%.2f" % ans)