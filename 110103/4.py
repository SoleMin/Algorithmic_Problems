# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
sumAll = 0.0
data = []
allCentList = []

while True:
	n = int(sys.stdin.readline())
	
	if n == 0:
		break
	data.append([sys.stdin.readline().strip() for i in range(n)])

	
	
for index, item in enumerate(data):
	ilist = []
	for value in data[index]:
		dollor, cent = value.split('.')
		intDollor = int(dollor)
		intCent = int(cent)
		ilist.append(intDollor * 100 + intCent)
		
	allCentList.append(ilist)


for index, value in enumerate(allCentList):
	sumAll = sum(value)
	avgAll = sumAll / len(value)
	taken:float = 0.0
	given:float = 0.0
	
	for value in allCentList[index]:
		centValue = value - avgAll
		if centValue < 0:
			taken += -(int(centValue)) / 100.0
		else:
			given += int(centValue) / 100.0
	
	if taken > given:
		print(f"${taken:.2f}")
	else:
		print(f"${given:.2f}")
	


		