# 차를 왼쪽에 놓을지 오른쪽에 놓을지 결정하는 함수
def search(car_left, id, remind_left, dp, flag):
    if dp[id][remind_left] == -1:
        # id가 car_left와 같거나, 남은 길이가 0이면, dp[id][remind_left] = 0
        if id == len(car_left) or remind_left == 0:
            dp[id][remind_left]=0
        # 남은 길이가 현재 차의 길이보다 같으면, 왼쪽에 넣을지 오른쪽에 넣을지 고민
        elif remind_left >= car_left[id]:
            # 오른쪽에 넣었을 경우를 계산
            v1 = search(car_left, id+1, remind_left, dp, flag)
            # 왼쪽에 넣었을 경우를 계산
            v2 = car_left[id]+search(car_left, id+1, remind_left-car_left[id], dp, flag)

            # 왼쪽에 넣는 경우 더 많이 놓을 수 있는 경우(왼쪽에 자리가 더 많이 남은 경우)
            if v2 >= v1:
                '''코드작성'''
                dp[id][remind_left]=search(car_left, id+1, remind_left-car_left[id], dp, flag)
                flag[id][remind_left] = True
            # 오른쪽에 배를 놓는 경우가 더 많이 놓을 수 있는 경우(오른쪽에 자리가 더 많이 남은 경우)
            else:
                '''코드작성'''
                dp[id][remind_left]=search(car_left, id+1, remind_left, dp, flag)

        # 왼쪽에 남은 길이보다 차 길이가 크면, 오른쪽에 넣어주기
        elif remind_left < car_left[id]:
            dp[id][remind_left]=search(car_left, id+1, remind_left, dp, flag)

    return dp[id][remind_left]

# input
testcase = int(input())
for _ in range(testcase):
    _ = input() # white space

    length = int(input())*100   # 페리의 길이. 단위가 미터이기에 100을 곱해준다.

    car_left = []
    car_length = 0              # 모든 차의 길이를 저장할 variable

    # 자동차 길이 입력받기
    temp = int(input())
    while temp != 0:
        car_length+=temp
        # 차의 길이의 총 합이 페리의 길이(오른쪽, 왼쪽 둘 다 포함해서)보다 길지 않아야한다.
        if car_length <= length*2:
            car_left.append(temp)
        temp = int(input())


    # -1이면 그 길이까지는 아무것도 없는것
    dp = [[-1 for _ in range(length+1)] for _ in range(len(car_left)+1)]
    # 왼쪽에 차를 놓은 경우에 True를 표시하는 dp
    flag = [[False for _ in range(length+1)] for _ in range(len(car_left)+1)]


    search(car_left, 0, length, dp, flag)
    curr = length

    count = 0
    right_sum = 0

    for i in range(len(car_left)):
        # 왼쪽에 차가 놓아진 경우
        if flag[i][curr]:
            curr -= car_left[i]
            count += 1
        # 오른쪽에 차가 놓아진 경우
        elif right_sum+car_left[i] <= length:
            right_sum += car_left[i]
            count += 1

    print(count)
    print()