import random

# Normally a teeth rot 45 days if you dont do anything
# There is a person and sometimes brush her/his teeths with 36% probability
# That increases the rot time
# (e.g. one brush increase 1 days)
# This person sometimes drink acidic drinks two times a day with %79 probability. 
# That increases the roting progress speed
# (e.g. 2 days earlier if person dont brush her/his teeths)
# Make a simulation.Run it for 1000 times.Find the average time to roting the person's teeth


def teethRot(probBrush,probAcidicDrink):
    totalTime = 0
    for i in range(1000):
        day = 45
        time = 0
        while True:
            time += 1
            brushes = random.random()
            drinksAcidic = random.random()
            if brushes <= probBrush:
                day += 1
            if drinksAcidic <= probAcidicDrink:
                day -= 2
            if day <= 0:
                break
        totalTime += time
    average =  totalTime/1000
    print(f"Average Time to Rot:{average}") 

probabilityOfBrush = random.uniform(0,.7)
probabilityOfDrink = 1 - probabilityOfBrush
teethRot(probabilityOfBrush,probabilityOfDrink)
print(f"Probability of brushing :{round((probabilityOfBrush*100),2)}%")
print(f"Probability of acidic drinks :{round((probabilityOfDrink*100),2)}%")
    


