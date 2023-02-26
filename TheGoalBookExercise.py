#This program based on The Goal book's example. 
#Here we are trying to calculate which values affects efficiency.

import random

class Machine():
    def __init__(self,name,stock,taken,given):
        self.name = name
        self.stock = stock
        self.taken = taken
        self.given = given

    def taking(self,supply):
        self.taken = supply
        self.stock += self.taken
    
    def giving(self):
        self.given = random.randint(0,6)
        if self.given > self.stock:
            self.given = self.stock
            self.stock = 0
            return self.given
        else:
            self.stock -= self.given
            return self.given
        

names = ['M1','M2','M3','M4']
machines = [Machine(i,0,0,0) for i in names] #[M1,M2,M3,M4]
total_supply = 0
output = 0

for j in range(10000):
    supply = random.randint(0,6)
    total_supply += supply
    #print('\n')
    #print(f'Supply: {supply}')
    for i in range(len(machines)):
        if i == 0:
            machines[i].taking(supply)
            
        else:
            machines[i].taking(machines[i-1].giving())
            if i == len(machines)-1:
                output += machines[i].giving()

    #for i in machines:
        #print(i.stock,end=' ')
    #print(total_supply,output)

efficiency = output / total_supply
print(f'Efficiency: {efficiency*100}')

