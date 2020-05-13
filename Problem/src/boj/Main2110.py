import sys

N, C = map(int, input().split())

nums = []

for i in range(N):
    nums.append(int(input()))
nums.sort()
l = 1
r = nums[N-1] - nums[0]
ans = r
while l<=r:
    mid = int((l+r)/2)
    now = nums[0]
    cnt = 1
    for i in range(1, N):
        # print(i)
        d = nums[i] - now
        if d >= mid:
            now = nums[i]
            cnt = cnt+1
    # print(mid, cnt)
    if cnt >= C:
        l = mid+1
        ans = mid
    else:
        r = mid-1


print(ans)
