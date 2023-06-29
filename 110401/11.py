# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n = int(input())
for i in range(n):
	test_case = list(map(int,input().split()))
	house_num = test_case[0]
	test_case = test_case[1:]

	test_case.sort()
	median = test_case[house_num//2]
	
	result = 0
	for i in test_case:
		if i == median:
			continue
		result += abs(median-i)
		
	print(result)
		