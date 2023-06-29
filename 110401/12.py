# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
'''def qs(array):
	if len(array) <= 1:
		return array
	pivot = array[len(array) // 2]
	left, right, mid = [], [], []
	for x in array:
		if x < pivot:
			left.append(x)
		elif x > pivot:
			right.append(x)
		else:
			mid.append(x)
	return qs(left) + mid + qs(right)'''
import numpy as np

test_case = input()

for i in range(int(test_case)):
	
	case = list(input().split())
	test1 = list(map(int, case))
	test = test1[1:]
	test.sort()
	
	arr1 = np.array(test)
	house = test[len(test)//2]
	
	sub = arr1-(house)
	result = sum(abs(sub))
	print (result)