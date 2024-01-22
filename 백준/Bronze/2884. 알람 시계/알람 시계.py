y,m = input().split()
y = int(y); m = int(m)
if(m>=45):
    m -= 45
elif(y==0):
    y=23; m = m+60-45
else:
    y-= 1; m = m+60-45
print(y, m)