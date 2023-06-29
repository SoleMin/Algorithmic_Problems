# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
#user_input = int(input())
#print ("Hello Goorm! Your input is " + user_input)

house = int(input())

for i in range(house): 
	rela = [int(x) for x in input().split()] #분리
	num = rela[0] #집 갯수
	
	loc = sorted(rela[1:]) #집들 위치
	mid = loc[num // 2] # 중앙값
	st = 0 #기준
	for i in loc: #거리재기
		st += abs(i-mid)
	
	print(st)
	

	