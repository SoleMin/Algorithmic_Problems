import sys;
T = sys.stdin.readline().rstrip()
P = sys.stdin.readline().rstrip()

def computeJump(P):
	m = len(P)
	jump = [0] * m
	begin = 1
	match = 0
	
	while(begin + match < m):
		if(P[begin + match] == P[match]):
			match += 1
			jump[begin + match - 1] = match
		else:
			if(match == 0):
				begin += 1
			else:
				begin += match - jump[match - 1]
				match = jump[match - 1]
	
	return jump
	
jump = computeJump(P)

n = len(T);
m = len(P);

ans = []

begin = 0
match = 0


while(begin <= n - m):
	if (match < m and T[begin+match] == P[match]):
		match += 1
	
		if (match == m):
			ans.append(begin + 1)
	else:
		if(match == 0):
			begin += 1
		else:
			begin += match - jump[match - 1]
			match = jump[match - 1]


print(len(ans))	
print(" ".join(map(str,ans)))





