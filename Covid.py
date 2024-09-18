loop = True

while loop:
    q1 = input("Do you have a fever?: ")
    q2 = input("Do you have cough?: ")
    q3 = input("Do you have difficulty breathing?: ")

    if (q1 == q1.lower("Yes")) or (q2 == q2.lower("Yes") or (q3 == q3.lower("Yes"):
        print("You may have COVID-19 symptoms. Please consult healthcare professional")
    else:
        print("You do not exhibit significant COVID-19 symptoms. Stay Safe!")
    answer = input("Do you want to check again?")
    if answer == 'Yes' or 'No':
        loop = True
    else:
        loop = False
    