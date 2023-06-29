size = int(input())

while(size != 0):
	total = {1:1,2:2,3:2,4:3,5:3,6:4,7:4,8:4}
	jump = 3
	n = 5
	k = 9
	
	if(size<=6):
		print(total[size])
		size = int(input())
		continue
	
	while(k<=size):
		total[k] = n
		
		if total[k] in total.keys():
			jump = total[n]
			k = k + jump
			#jump = total[n]
			
		else:
			k = k +jump
			
		n+=1
	#if(size<6):
	#	total = {1:1,2:2,3:2,4:3,5:3}
	#	total[k] = total[size]
#if(size<=6):
	#print(total[size])
	
	print(n-1)
	size = int(input())
