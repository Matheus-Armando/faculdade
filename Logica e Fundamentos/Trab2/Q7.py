'''7) As Organizações Tabajara resolveram dar um aumento de salário aos seus colaboradores e lhe contraram para desenvolver o programa que calculará os reajustes.
Faça um programa que recebe o salário de um colaborador e o reajuste segundo o seguinte critério, baseado no salário atual:
salários até R$ 280,00 (incluindo) : aumento de 20%
salários entre R$ 280,00 e R$ 700,00 : aumento de 15%
salários entre R$ 700,00 e R$ 1500,00 : aumento de 10%
salários de R$ 1500,00 em diante : aumento de 5% Após o aumento ser realizado, informe na tela:
o salário antes do reajuste;
o percentual de aumento aplicado;
o valor do aumento;
o novo salário, após o aumento.
'''

salario = int(input("Digite seu salario atual\n"))
'''taxaA = 0.2
taxaB = 0.15
taxaC = 0.1
taxaD = 0.05'''

if salario <= 280:
    taxa = 0.2
    reajuste = (salario*taxa)
    salarioAjustado = salario + reajuste
elif 280 < salario <= 700:
    taxa = 0.15
    reajuste = (salario*taxa)
    salarioAjustado = salario + reajuste
elif 700 < salario <= 1500:
    taxa = 0.1
    reajuste = (salario*taxa)
    salarioAjustado = salario + reajuste
else:
    taxa = 0.05
    reajuste = (salario*taxa)
    salarioAjustado = salario + reajuste

print("O seu salário era: R$", salario,
       "\nA taxa de aumento foi de: ", taxa, "%\n Valor do aumento: R$", reajuste,
       "\nSalário reajustado: R$", salarioAjustado)