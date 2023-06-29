import sys;
while(1):
	cards = sys.stdin.readline().rstrip()
	if (len(cards) == 0 ):
		break
	cards = list(cards.split())
	
	blackHand = cards[0:5]
	whiteHand = cards[5:]
	whiteScore = 0;
	blackScore = 0;
	
	numberValue = {
		'2': 20,
		'3': 30,
		'4': 40,
		'5': 50,
		'6': 60,
		'7': 70,
		'8': 80,
		'9': 90,
		'T': 100,
		'J': 110,
		'Q': 120,
		'K': 130,
		'A': 140,
	}
	
	whiteHand.sort(key=lambda x: numberValue[x[0]])
	blackHand.sort(key=lambda x: numberValue[x[0]])
	
	def handCheck(hand):
		numberList = [0] * 15;
		patternList = [0] * 4;
		for i in range(5):
			numberList[int(numberValue[hand[i][0]]/ 10)] += 1
			if (hand[i][1] == "H"):
				patternList[0] += 1
			elif (hand[i][1] == "D"):
				patternList[1] += 1
			elif (hand[i][1] == "S"):
				patternList[2] += 1
			elif (hand[i][1] == "C"):
				patternList[3] += 1
		
		if (numberValue[hand[0][0]] + 10 == numberValue[hand[1][0]] and
			 numberValue[hand[0][0]] + 20 == numberValue[hand[2][0]] and
			 numberValue[hand[0][0]] + 30 == numberValue[hand[3][0]] and
			 numberValue[hand[0][0]] + 40 == numberValue[hand[4][0]] and
			 hand[0][1] == hand[1][1] and hand[0][1] == hand[2][1]  and hand[0][1] == hand[3][1] and
			 hand[0][1] == hand[4][1]):
			return 9000 + numberValue[hand[4][0]]
		
		for i in range(15):
			if (numberList[i] == 4):
				return 8000 + (i * 10)
		
		checkFullHouse = [0,0]
		twoFirstIdx = 0
		twoSecondIdx = 0
		threeIdx = 0
		for i in range(15):
			if (numberList[i] ==2):
				if (checkFullHouse[0] == 0):
					twoFirstIdx = i
				elif ( checkFullHouse[0] == 1):
					twoSecondIdx = i
				checkFullHouse[0]  +=1
			if (numberList[i] == 3):
				checkFullHouse[1] = 1
				threeIdx = i
		
		if (checkFullHouse[0] == 1 and checkFullHouse[1] == 1):
			return 7000  + (threeIdx * 10)
	
		for i in range(4):
			if (patternList[i] == 5):
				return 6000 + numberValue[hand[4][0]] + (numberValue[hand[3][0]] / 10) + (numberValue[hand[2][0]] / 100) + (numberValue[hand[1][0]] / 1000) + (numberValue[hand[0][0]] /10000)
		
		if (numberValue[hand[0][0]] +10 == numberValue[hand[1][0]] and
			 numberValue[hand[0][0]] + 20 == numberValue[hand[2][0]] and
			 numberValue[hand[0][0]] + 30 == numberValue[hand[3][0]] and
			 numberValue[hand[0][0]] + 40 == numberValue[hand[4][0]]):
			return 5000 + numberValue[hand[4][0]]
		
		if (checkFullHouse[1] == 1):
			return 4000 + (threeIdx * 10)
		
		if (checkFullHouse[0] == 2):
			lst = []
			for i in range(15):
				if (numberList[i] == 1):
					lst.append(i)
			return 3000 + (twoSecondIdx * 10) + twoFirstIdx + (lst[0] / 10)  
		
		if (checkFullHouse[0] == 1):
			lst = []
			for i in range(15):
				if (numberList[i] == 1):
					lst.append(i)
			return 2000 + (twoFirstIdx * 10) + lst[2] + (lst[1] / 10) + (lst[0] / 100) 
		
		return 1000 + numberValue[hand[4][0]] + (numberValue[hand[3][0]] / 10) + (numberValue[hand[2][0]] / 100) + (numberValue[hand[1][0]] / 1000) + (numberValue[hand[0][0]] / 10000)
	
	whiteScore += handCheck(whiteHand)
	blackScore += handCheck(blackHand)


	if (whiteScore > blackScore):
		print("White wins.")
	elif (whiteScore < blackScore):
		print("Black wins.")
	else:
		print("Tie.")