x = int(input())
y = int(input())
region = 0
if(x>0 and y>0): region=1
elif(x<0 and y>0): region=2
elif(x<0 and y<0): region=3
else: region=4
print(region)