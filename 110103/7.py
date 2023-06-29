	# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
import math

res = []

while True:
	num = int(input())
	if num == 0:
		break
	money_list = []
	rest_money = 0
	
	for i in range(num):
		money = float(input())
		money_list.append(money)
	
	avg = sum(money_list)/num
	
	plus = 0
	minus = 0
	for i in money_list:
		tmp = i - avg
		if tmp > 0:
			plus += tmp
		else:
			minus += tmp
	
	rest_money = min(abs(minus),plus)
	rest_money = abs(math.trunc(minus * 100)/100)
	print("${0:0.2f}".format(rest_money))	
# 	money_list.sort(reverse=True)

# 	avg = round(round((sum(money_list)/num),3),3)
# 	# avg = math.ceil(math.ceil(sum(money_list)))
	
# 	result = 0
	
	


