def switchnum(n):
	if ord(n[0])>=48 and ord(n[0])<=57:
		return int(n[0])
	else:
		if n[0]=='T':
			return 10
		elif n[0]=='J':
			return 11
		elif n[0]=='Q':
			return 12
		elif n[0]=='K':
			return 13
		else:
			return 14

def straight(hand):
	seq=[]
	for i in range(5):
		seq.append(hand[i][0])
	tmp=seq[0]
	for j in range(1,5):
		if tmp+1!=seq[j]:
			return False
		tmp+=1
	return True

def Flush(hand):
	tmp=hand[0][1]
	for i in range(1,5):
		if tmp!=hand[i][1]:
			return False
	return True

def straight_Flush(hand):
	if straight(hand) and Flush(hand):
		return True
	else:
		return False

def four_card(hand):
	if hand[0][0] == hand[3][0]:
		return True
	elif hand[1][0] == hand[4][0]:
		return True
	else:
		return False
	
def Fullhouse(hand):
	if hand[0][0] == hand[2][0] and hand[3][0] == hand[4][0]:
		return True
	elif hand[0][0]==hand[1][0] and hand[2][0]==hand[4][0]:
		return True
	else:
		return False

def three_card(hand):
	if hand[0][0]==hand[2][0]:
		return True
	elif hand[1][0] == hand[3][0]:
		return True
	elif [2][0]==hand[4][0]:
		return True
	else:
		return False
	
def two_pair(hand):
	if (hand[0][0]==hand[1][0]) and (hand[2][0] == hand[3][0]):
		return True
	elif (hand[0][0]== hand[1][0]) and (hand[3][0] == hand[4][0]):
		return True
	elif (hand[1][0] == hand[2][0]) and (hand[3][0] == hand[4][0]):
		return True
	else:
		return False
	
def one_pair(hand):
	if hand[0][0]==hand[1][0]:
		return True
	elif hand[1][0] == hand[2][0]:
		return True 
	elif hand[2][0] == hand[3][0]:
		return True
	elif hand[3][0] == hand[4][0]:
		return True
	else:
		return False

def Check(hand):
	
	if straight_Flush(hand):
		return (10,hand[4][0])
	
	elif four_card(hand):
		return (9,hand[1][0])
	
	elif Fullhouse(hand):
		if hand[0][0]==hand[2][0] and hand[3][0]==hand[4][0]:
			return (8,hand[2][0],hand[3][0])
		elif hand[0][0]==hand[1][0] and hand[2][0]==hand[4][0]:
			return (8,hand[2][0],hand[0][0])
		
	elif Flush(hand):
		return (7,hand[4][0])
	
	elif straight(hand):
		return (6,hand[4][0])
	
	elif three_card(hand):
		if hand[0][0]==hand[2][0]:
			return (5,hand[0][0])
		elif hand[1][0]==hand[3][0]:
			return (5,hand[1][0])
		elif hand[2][0]==hand[4][0]:
			return (5,hand[2][0])
		
	elif two_pair(hand):
		if hand[0][0]==hand[1][0] and (hand[2][0]==hand[3][0]):
			return (4,hand[2][0],hand[0][0],hand[4][0])
		elif hand[0][0]==hand[1][0] and (hand[3][0]==hand[4][0]):
			return (4,hand[3][0],hand[0][0],hand[2][0])
		elif hand[1][0]==hand[2][0] and (hand[3][0]==hand[4][0]):
			return (4,hand[3][0],hand[1][0],hand[0][0])
		
	elif one_pair(hand):
		if hand[0][0]==hand[1][0]:
			return (3,0)
		elif hand[1][0]==hand[2][0]:
			return (3,1)
		elif hand[2][0]==hand[3][0]:
			return (3,2)
		elif hand[3][0]==hand[4][0]:
			return (3,3)
		
	else:
		return (2,hand[4][0])


	
try:
	while True:
		List=list(map(str,input().split()))
		Black_list=[List[i] for i in range(0,5)]
		White_list=[List[i] for i in range(5,10)]
		Black_list.sort()
		White_list.sort()
		score_B_list=[]
		score_W_list=[]
		
		for j in Black_list:
			score_B_list.append((switchnum(j),j[1]))

		for j in White_list:
			score_W_list.append((switchnum(j),j[1]))
			
		score_B_list.sort()
		score_W_list.sort()
		
		check_B=Check(score_B_list)
		check_W=Check(score_W_list)

		
		if check_B[0]>check_W[0]:
			print('Black wins.')
		elif check_B[0]<check_W[0]:
			print('White wins.')
		elif check_B[0]==check_W[0]:
			
			if check_B[0]==8:
				if check_B[1]>check_W[1]:
					print('Black wins.')
				elif check_B[1]<check_W[1]:
					print('White wins.')
				else:
					if check_B[2]>check_W[2]:
						print('Black wins.')
					elif check_B[2]<check_W[2]:
						print('White wins')
					else:
						print('Tie.')
				
					
			
			elif check_B[0]==4:
				if check_B[1]>check_W[1]:
					print('Black wins.')
				elif check_B[1]<check_W[1]:
					print('White wins.')
				else:
					if check_B[2]>check_W[2]:
						print('Black wins')
					elif check_B[2]<check_W[2]:
						print('White wins.')
					else:
						if check_B[3]>check_W[3]:
							print('Black wins.')
						elif check_B[3]<check_W[3]:
							print('White wins.')
						else:
							print('Tie.')
							
			elif	check_B[0]==3:
				if score_B_list[check_B[1]][0]>score_W_list[check_W[1]][0]:
					print('Black wins.')
				elif score_B_list[check_B[1]][0]<score_W_list[check_W[1]][0]:
					print('White wins.')
				else:
				
					score_B_list.pop(check_B[1])
					score_B_list.pop(check_B[1])
					score_W_list.pop(check_W[1])
					score_W_list.pop(check_W[1])
					
					for i in range(2,-1,-1):
						if score_B_list[i][0]>score_W_list[i][0]:
							print('Black wins.')
							break
						elif score_B_list[i][0]<score_W_list[i][0]:
							print('White wins.')
							break
					if i==0 and score_B_list[0][0]==score_W_list[0][0]:
						print('Tie.')

			else: #하이카드 규칙
				for i in range(4,-1,-1):
					if score_B_list[i][0]>score_W_list[i][0]:
						print("Black wins.")
						break
					elif score_B_list[i][0]<score_W_list[i][0]:
						print('White wins.')
						break
				if i==0 and score_B_list[0][0]==score_W_list[0][0]:
					print('Tie.')
				
except EOFError:
	print()

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		