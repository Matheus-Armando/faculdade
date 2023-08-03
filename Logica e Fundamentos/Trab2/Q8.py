"""8) Faça um Programa , C ou PYTHON, que peça os 3 lados de um triângulo. O programa deverá informar se os valores podem ser um triângulo. 
Indique, caso os lados formem um triângulo, se o mesmo é: equilátero, isósceles ou escaleno.
Dicas:
Três lados formam um triângulo quando a soma de quaisquer dois lados for maior que o terceiro;
Triângulo Equilátero: três lados iguais;
Triângulo Isósceles: quaisquer dois lados iguais;
Triângulo Escaleno: três lados diferentes;
"""
ladoA = float(input("1 lado\n"))
ladoB = float(input("2 lado\n"))
ladoC = float(input("3 lado\n"))

if ladoA + ladoB > ladoC and ladoA + ladoC > ladoA and ladoC + ladoB > ladoA:
    if ladoA == ladoB == ladoC:
        triangulo = "Equilatero"
    elif ladoA == ladoB or ladoA == ladoB or ladoC == ladoB:
        triangulo = "isosceles"
    else:
        triangulo = "escaleno"
    print("Triangulo", triangulo)
else:
    print("Esses valores não geram um triangulo")
