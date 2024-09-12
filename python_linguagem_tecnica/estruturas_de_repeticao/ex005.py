# 5. Implemente um programa que leia uma sequência de números positivos,
# encerrando a leitura quando o número zero for inserido. O programa deve contar
# quantos números pares e ímpares foram inseridos, além de calcular a média dos
# números pares e a média geral dos números lidos. Inclua uma explicação de como o
# programa diferencia números pares de ímpares.

soma = 0
soma_par = 0
soma_impar = 0
contador = 0
contador_par = 0
contador_impar = 0
valor = 0

while (True):
    valor = int(input("Digite um número: "))
    if valor == 0:
        break
    while (valor < 0):
        valor = int(input("Digite um valor positivo: "))

    soma += valor
    contador += 1
    # se valor divido por 2 tiver resto zero esse número é par, senão é impar
    if valor % 2 == 0:
        soma_par += valor
        contador_par += 1
    else:
        soma_impar += valor  
        contador_impar += 1  

   
if contador > 0:
    media = soma / contador
else:
    print("Nenhum valor inserido.")    

print(f"A média geral dos números é {media:.2f}")
print(f"A quantidade de números pares é {contador_par}")
print(f"A quantidade de números ímpares é {contador_impar}")

if contador_par > 0:
    media_par = soma_par / contador_par
    print(f"A média dos números pares é {media_par:.2f}")
else: 
    print("Nenhum valor par inserido.")



