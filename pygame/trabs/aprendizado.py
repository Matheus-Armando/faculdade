#Faça um Programa que peça dois números e imprima o maior deles.
sexo = input("Digite F para feminino e M para masculino\n")

sexo_u = sexo.upper()

if sexo_u == 'F':
    print ("feminino")

elif sexo_u == 'M':
    print("masculino")

else:
    print ('sexo invalido')