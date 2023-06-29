# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while True:
	try:
		first_word = input()
		second_word = input()
		
		check_first = [0 for i in range(26)]
		check_second = [0 for i in range(26)]
		
		for first_letter in first_word:
			check_first[ord(first_letter) - 97] += 1
		
		for second_letter in second_word:
			if check_first[ord(second_letter)- 97] > 0:
				check_first[ord(second_letter) - 97] -= 1
				check_second[ord(second_letter) - 97] += 1
				
		
		for i in range(26):
			for j in range(check_second[i]):
				print(chr(i+97), end="")
		
		print()
		
	except EOFError:
		break