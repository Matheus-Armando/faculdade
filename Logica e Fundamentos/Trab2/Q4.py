'''4) Faça um programa(C ou Python) que peça uma nota, entre zero e dez. 
Mostre uma mensagem caso o valor seja inválido e continue pedindo até que o usuário informe um valor válido.'''


while True:
    nota = float(input("Digite uma nota de 1 a 10\n"))
    if 0 <= nota <= 10:
        break
    else:
        print("Nota invalida, digite novamente.")

print("Sua nota foi", nota)

