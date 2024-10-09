# 3. Crie um programa que solicite ao usuário uma quantidade indefinida de valores
# numéricos. O programa deve calcular e exibir a média aritmética dos números
# inseridos, além de contar quantos desses números são positivos e quantos são
# negativos. Finalmente, calcule e apresente a porcentagem de números positivos e
# negativos. Considere que o usuário deve inserir pelo menos um número positivo e
# um negativo.

soma = 0
contador = 0
cont_positivo = 0
cont_negativo = 0

quantidade = int(input("Digite quantos valores você vai inserir: "))
for i in range(1, quantidade + 1):
    contador += 1
    valor = int(input(f"Insira o valor {contador}: "))
    soma += valor
        
    if valor >= 0:
        cont_positivo += 1
    else:
        cont_negativo += 1    

    if i == quantidade - 1 and cont_positivo == 0:
        print(f"ALERTA => nenhum valor positivo inserido")
        
        while (cont_positivo == 0):
          valor = int(input("Insira um valor positivo: "))
          if valor > 0:
              soma += valor
              cont_positivo += 1
              break
        break          

    if i == quantidade - 1 and cont_negativo == 0:
        print("ALERTA => nenhum valor negativo inserido")

        while (cont_negativo == 0):
            valor = int(input("Insira um valor negativo: "))      
            if valor < 0:
                soma += valor
                cont_negativo += 1
                break
        break            
media = soma / quantidade

print(f"A média dos valores é de: {media:.2f}")
print(f"A porcentagem de números negativos é de: {cont_negativo * 100 / quantidade:.2f}%")
print(f"A porcentagem de números positivos é de: {cont_positivo * 100 / quantidade:.2f}%")