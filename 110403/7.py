case = int(input())

for i in range(case):
	space = input()
	
	people = int(input())
	cases = []
	for j in range(people):
		cases.append(int(input()))
		
	cases.sort()
	anyway = 0
	while(people>=4):
		way1 = cases[1] + cases[0] + cases[people-1] + cases[1]
		way2 = cases[people-1] + cases[0] + cases[people-2] + cases[0]
		
		if(way1>way2):
			anyway += way2
		else:
			anyway += way1
			
		people -=2
		
	if(people == 3):
		way = cases[2] + cases[1] + cases[0] + anyway
	elif(people == 2):
		way = cases[1] + anyway
	elif(people == 1):
		way = cases[0] + anyway
	
	
	print(way)
	print(" ")
	
	
	
	