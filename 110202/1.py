def encode_card(card):
	result = 0
	if card[0] == 'T':
		result += 100
	elif card[0] == 'J':
		result += 110
	elif card[0] == 'Q':
		result += 120
	elif card[0] == 'K':
		result += 130
	elif card[0] == 'A':
		result += 140
	else:
		result += (ord(card[0]) - ord('0')) * 10
		
	if card[1] == 'H':
		result += 1
	elif card[1] == 'D':
		result += 2
	elif card[1] == 'S':
		result += 3
	elif card[1] == 'C':
		result += 4
	return result


def check_rank(deck_num, deck_shape):
	if len(set(deck_shape)) == 1 and deck_num[4] - deck_num[0] == 4:
		return 9, deck_num[4]
	
	same_card = 0
	number = 0
	for num in deck_num:
		if deck_num.count(num) >= same_card:
			same_card = deck_num.count(num)
			number = num	
			
	if same_card == 4:
		return 8, number
	elif same_card == 3 and len(set(deck_num)) == 2:
		return 7, number
	elif len(set(deck_shape)) == 1:
		return 6, deck_num[4]
	elif deck_num[4] - deck_num[0] == 4:
		return 5, deck_num[4]
	elif same_card == 3:
		return 4, number
	elif same_card == 2:
		if len(set(deck_num)) == 3:
			return 3, number
		return 2, number
	else:
		return 1, deck_num[4]

	
while True:
	try:
		cards = input().split()
		for i in range(len(cards)):
			cards[i] = encode_card(cards[i])
		black_deck = sorted(cards[:5])
		black_deck_number = list(map(lambda x: x // 10, black_deck))
		black_deck_shape = list(map(lambda x: x % 10, black_deck))
		white_deck = sorted(cards[5:])
		white_deck_number = list(map(lambda x: x // 10, white_deck))
		white_deck_shape = list(map(lambda x: x % 10, white_deck))
		black_deck_rank = check_rank(black_deck_number, black_deck_shape)
		white_deck_rank = check_rank(white_deck_number, white_deck_shape)
	
		if black_deck_rank[0] > white_deck_rank[0]:
			print('Black wins.')
		elif black_deck_rank[0] < white_deck_rank[0]:
			print('White wins.')
		else:
			if black_deck_rank[1] > white_deck_rank[1]:
				print('Black wins.')
			elif black_deck_rank[1] < white_deck_rank[1]:
				print('White wins.')
			else:
				if black_deck_number != white_deck_number:
					for i in range(4, -1, -1):
						if black_deck_number[i] > white_deck_number[i]:
							print('Black wins.')
							break
						elif black_deck_number[i] < white_deck_number[i]:
							print('White wins.')
							break
				else:
					print('Tie.')
	except EOFError:
		break
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	