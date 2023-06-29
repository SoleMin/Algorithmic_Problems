import sys;
T = int(sys.stdin.readline());
idx = 0;
sys.stdin.readline();
while(idx < T):
	fee = list(map(int,sys.stdin.readline().split()))
	dataList = []
	while(1):
		data = list(sys.stdin.readline().rstrip().split())
		if (len(data) == 0):
			break
		dataList.append(data)
		
	dataList.sort(key=lambda x: x[1])
	carData = {}
	
	for data in dataList:
		if data[0] not in carData:
			carData[data[0]] = [data]
		else:
			carData[data[0]].append(data)
	
	ansData = {}
	
	for car in carData:
		startTime = ""
		startPoint = 0
		endPoint = 0
		stack = []
		for item in carData[car]:
			if(item[2] == "enter"):
				startTime = item[1]
				startPoint = int(item[3])
				stack.append([startPoint, startTime]);
				monthCheck = [0] * 13;
			elif (item[2] == "exit"):
				endPoint = int(item[3])
				if (len(stack) > 0):
					startData = stack.pop(0)
					hour = int(startData[1][6:8])
					x = fee[hour]
					total = x *  abs(endPoint - startData[0]) * 0.01
					if car not in ansData:
						ansData[car] = total + 3;
					else:
						ansData[car] += total + 1;
					
	
	newData = dict(sorted(ansData.items()))
	
	ans = []
	for item in newData:
		ans.append("%s $%.2f" % (item, newData[item]))
	
	print("\n".join(ans) +"\n")
	
	idx+=1