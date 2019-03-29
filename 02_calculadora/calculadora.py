class Calculadora():
    def __init__(self, maxBat):
        self.bateria = 0
        self.maxBat = maxBat
    
    def sum(self, a,b):
        if(self.bateria > 0):
            self.bateria -= 1
            return a+b
        else: 
            return "Bateria insuficiente"
        
    def div(self, a, b):
        if(self.bateria > 0):
            self.bateria -= 1
            if (b == 0):
                return "Divisão por 0"
            return a/b
        else: 
            return "Bateria insuficiente"
    
    def mult(self, a, b):
        if self.bateria > 0:
            self.bateria -= 1
            return a*b
        else: 
            return "Bateria insuficiente"
    
    def charge(self, m):
        if (m<= self.maxBat):
            self.bateria += m
    
    def __str__(self):
      return "bateria: " + str(self.bateria) + "/" + str(self.maxBat)


calc = Calculadora(0)

print ("Digite init _maxCarga, charge _value, sum _a _b, div _a _b, mult _a _b, show ou end")
line = " "
while line != "end":
  line = input()
  ui = line.split(" ")
  
  if ui[0] == "end":
    break
  elif ui[0] =="show":
    print(calc)
  elif ui[0] == "init":
    calc.maxBat = int(ui[1])
  elif ui[0] == "charge":
    calc.charge(int(ui[1]))
  elif ui[0] == "sum":
    a = (int(ui[1]))
    b = (int(ui[2]))
    print(calc.sum(a,b))
  elif ui[0] == "div":
    a = (int(ui[1]))
    b = (int(ui[2]))
    print(calc.div(a,b))
  elif ui[0] == "mult":
    a = (int(ui[1]))
    b = (int(ui[2]))
    print(calc.mult(a,b))
  else:
    print ("Comando invalido")