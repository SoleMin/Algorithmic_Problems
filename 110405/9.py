n = int(input())

for i in range(n):
	blank = input()
	step = int(input())
	
	test_case = []
	for j in range(step):
		test_case.append(list(map(int,input().split())))
		
	number_case =[]
	for idx,value in enumerate(test_case):
		 number_case.append([idx+1,value[0],value[1]])
	
	for x in range(len(number_case)-1,0,-1):
		for y in range(0,x):
			if number_case[y][2]/number_case[y][1] < number_case[y+1][2]/number_case[y+1][1]:
				number_case[y],number_case[y+1] = number_case[y+1],number_case[y]
			elif number_case[y][2]/number_case[y][1] == number_case[y+1][2]/number_case[y+1][1]:
				if number_case[y][1] >= number_case[y+1][1]:
					number_case[y],number_case[y+1] = number_case[y+1],number_case[y]
				
	for j in number_case:
		print(j[0],end=" ")
	print()
	print()
	

