testcase = int(input())

for _ in range(testcase):
    s1 = input()
    s2 = input()

    dp = [0 for _ in range(len(s2) + 1)]
    dp[0] = 1

    for i in s1:
        for j, s2_ch in reversed(list(enumerate(s2))):
            # 두 문자열이 같으면 dp에 저장된 값 중 왼쪽 상단의 값과 바로 위의 값을 더해서 저장한다.
            if i == s2_ch:
                dp[j + 1] += dp[j] 
            # 두 문자열이 같지않으면 바로 위의 값을 저장해준다
    print(dp[len(s2)])
