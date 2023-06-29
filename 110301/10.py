# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while(1):
	try:
		user_input = input()


		word = {'2':'1','3':'2','4':'3','5':'4','6':'5','7':'6','8':'7','9':'8','0':'9','-':'0','=':'-','W':'Q','E':'W','R':'E','T':'R','Y':'T','U':'Y','I':'U','O':'I','P':'O','[':'P',']':'[','S':'A','D':'S','F':'D','G':'F','H':'G','J':'H','K':'J','L':'K',';':'L','X':'Z','C':'X','V':'C','B':'V','N':'B','M':'N',',':'M','.':',','/':'.'}

		list(user_input)
		ran = len(user_input)

		af = ['0']*ran

		for i in range(ran):
			if user_input[i] in word.keys():
				af[i] = word[user_input[i]]
			else:
				af[i] = user_input[i]

		aft = ''
		for i in range(ran):
			aft = aft + af[i] 

		print(aft)
	except EOFError:
		break
		