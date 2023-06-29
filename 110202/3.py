def num(card):
	num = 0
	if card[0] == 'T': num += 10
	elif card[0] == 'J': num += 11
	elif card[0] == 'Q': num += 12
	elif card[0] == 'K': num += 13
	elif card[0] == 'A': num += 14
	else: num += int(card[0])
	return 	num
while True:
	try:
		all_card = input().split()
		black = all_card[:5]
		white = all_card[5:]
		black_num = []
		white_num = []
		for i in black:
			black_num.append(num(i))
		for i in white:
			white_num.append(num(i))
		black_num.sort() # 오름차순으로 정렬
		white_num.sort()
		# 하이카드, 원페어, 쓰리카드, 포카드
		black_win = 0
		white_win = 0
		for i in black_num:
			if black_num.count(i) == 2: black_win += 3
			elif black_num.count(i) == 3: black_win += 8
			elif black_num.count(i) == 4: black_win += 15
			else: black_win += 1
		
		for i in white_num:
			if white_num.count(i) == 2: white_win += 3
			elif white_num.count(i) == 3: white_win += 8
			elif white_num.count(i) == 4: white_win += 15
			else: white_win += 1
		# 값이 동일한 경우
		if white_win == black_win:
			# 하이카드 플러시 판별
			if black_win == 5:
				for i in reversed(range(5)):
					if black_num[i] > white_num[i]:
						black_win += 1
						break
					elif black_num[i] < white_num[i]:
						white_win += 1
						break
					else: continue
			# 원페어
			if black_win == 9:
				b_one = 0
				w_one = 0
				high_b = []
				high_w = []
				for i in black_num:
					if black_num.count(i) == 2: b_one = i
					else: high_b.append(i)
				for i in white_num:
					if white_num.count(i) == 2: w_one = i
					else: high_w.append(i)
				if b_one > w_one:
					black_win += 1
				elif b_one < w_one:
					white_win += 1
				else:
					high_b.sort()
					high_w.sort()
					for i in reversed(range(3)):
						if high_b[i] > high_w[i]: black_win += 1
						elif high_b[i] < high_w[i]: white_win += 1
						else: continue
			# 투페어
			if black_win == 13:
				b_two = []
				w_two = []
				not_two_b = 0
				not_two_w = 0
				for i in black_num:
					if black_num.count(i) == 2: 
						b_two.append(i)
					elif black_num.count(i) == 1: not_two_b = i
					else: continue
				for i in white_num:
					if white_num.count(i) == 2:
						w_two.append(i)
					elif white_num.count(i) == 1: not_two_w = i
					else: continue
				b_two1 = set(b_two)
				black_two = sorted(list(b_two1))
				w_two1 = set(w_two)
				white_two = sorted(list(w_two1))
				if white_two[1] == black_two[1]:
					if black_two[0] > white_two[0]: black_win += 1
					elif black_two[0] < white_two[0]: white_win += 1
					else:
						if not_two_b > not_two_w: black_win += 1
						elif not_two_b < not_two_w: white_win += 1
				elif white_two[1] > black_two[1]: white_win += 1
				else: black_win += 1
			# 쓰리카드 포카드
			if black_win == 26 or black_win == 61:
				b_three_four = 0
				w_three_four = 0
				for i in black_num:
					if (black_num.count(i) == 3) or (black_num.count(i) == 4): b_three_four = i
				for i in white_num:
					if (white_num.count(i) == 3) or (white_num.count(i) == 4): w_three_four = i
				if b_three_four > w_three_four: black_win += 1
				elif b_three_four < w_three_four: white_win += 1
		# 스트레이트
		if black_num == list(range(black_num[0], black_num[4]+1)): black_win += 45
		if white_num == list(range(white_num[0], white_num[4]+1)): white_win += 45
		if (black_win == 50) and (white_win == 50):
			if black_num[4] > white_num[4]: black_win += 1
			elif black_num[4] < white_num[4]: white_win += 1
		# 플러시
		black_pat = []
		white_pat = []
		for j in black:
			black_pat.append(j[1])
		for j in white:
			white_pat.append(j[1])
		for k in black_pat:
			if black_pat.count(k) == 5:
				black_win += 10
			else: continue
		for k in white_pat:
			if white_pat.count(k) == 5:
				white_win += 10
			else: continue
		# 풀하우스
		# 포카드일 경우 점수 총합이 61점이 나오고 플러시는 55점이 나오므로 그 사이 점수 중에 고르기 위해
		# 쓰리카드와 원페어의 점수 총합이 30이므로 이 숫자에 2를 곱함.
		black_full = 0
		white_full = 0
		if black_win == 30: black_win *= 2
		if white_win == 30: white_win *= 2
		if (black_win == 60) and (white_win == 60):
			for i in black_num:
				if black_num.count(i) == 3: black_full = i
			for i in white_num:
				if white_num.count(i) == 3: white_full = i
			if black_full > white_full: black_win += 1
			elif black_full < white_full: white_win += 1
		# 스트레이트 플러시는 스트레이트와 플러시의 합으로 표현가능
		if (black_win == 100) and (white_num == 100):
			if max(black_num) > max(white_num): black_win += 1
			elif max(black_num) < max(white_num): white_win += 1
		# 결과
		if white_win < black_win: print("Black wins.")
		elif white_win > black_win: print("White wins.")
		else: print("Tie.")

	except EOFError:
			break