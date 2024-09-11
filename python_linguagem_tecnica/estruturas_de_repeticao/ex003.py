# 3. Crie um programa que solicite ao usuário uma quantidade indefinida de valores
# numéricos. O programa deve calcular e exibir a média aritmética dos números
# inseridos, além de contar quantos desses números são positivos e quantos são
# negativos. Finalmente, calcule e apresente a porcentagem de números positivos e
# negativos. Considere que o usuário deve inserir pelo menos um número positivo e
# um negativo.

qtd = int(input("Quantos números você quer inserir? "))
qtd_positivo = 0
qtd_negativo = 0
montante = 0
sentinela = False
for i in range(1, qtd + 1):
    valor = int(input(f"Digite o número {i}: "))
    montante = montante + valor
    if valor >= 0:
        qtd_positivo = qtd_positivo + 1
    else:
        qtd_negativo += 1

    if i + 1 == qtd:
        if qtd_positivo == 0:
            print("Você só digitou números negativos.")
            while (True):                
                valor = int(input(f"Digite o número {i + 1}:"))
                if valor >= 0:
                    qtd_positivo = qtd_positivo + 1
                    montante = montante + valor
                    sentinela = True
                    break
        elif qtd_negativo == 0:
            print("Você só digitou números positivos.")
            while (True):
                valor = int(input(f"Digite o número {i + 1}:"))
                if valor >= 0:
                    qtd_negativo = qtd_negativo + 1
                    montante = montante + valor
                    sentinela = True
                    break

print(f"A média aritmética é: {montante}")
print(f"A porcentagem de negativo é: {qtd_negativo / qtd * 100}")
print(f"A porcentagem de positivo é: {qtd_positivo / qtd * 100}")
