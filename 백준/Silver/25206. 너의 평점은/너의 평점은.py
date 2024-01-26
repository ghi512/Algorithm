grades = ['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', '', 'F']
sumOfGrade = 0
sumOfCredit = 0
for _ in range(20):
    x,credit,grade = input().split()
    if grade=='P': pass
    else:
        sumOfGrade += (4.5 - grades.index(grade) * 0.5) * float(credit)
        sumOfCredit += float(credit)
print(sumOfGrade/sumOfCredit)