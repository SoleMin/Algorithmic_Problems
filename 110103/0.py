# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math

n = int(input())
while n != 0:
	l = []
	
	sum = 0
	for _ in range(n):
		a = float(input()) * 100
		l.append(a)
		sum += a

	l.sort(reverse=True)
	
	result = 0
	if sum % n == 0:
		mean = int(sum / n)
		for i in l:
			result += abs(i - mean)
		result /= 2
		print('${0:.2f}'.format(result/100))
	else:
		cnt = int(sum % n)
		mean = int((sum-cnt)/n)

		p = [mean] * n
		for i in range(cnt):
			p[i] += 1
		
		for i in range(n):
			result += abs(p[i] - l[i])
			
		print('${0:.2f}'.format((result/2)/100))
	
	n = int(input())