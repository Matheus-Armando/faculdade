'''6) Desenvolva um gerador de tabuada (C ou PYTHON), capaz de gerar a tabuada de qualquer número inteiro entre 1 a 10. 
O usuário deve informar de qual numero ele deseja ver a tabuada. '''

tabuada = int(input("Qual a tabuada desejada?\n"))

for i in range(11):
    resultado = tabuada * i 
    print(tabuada, " X ", i, " = ", resultado)