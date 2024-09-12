# 4. Desenvolva um programa que receba uma série de números de forma contínua até
# que um valor negativo seja inserido. O programa deve contar quantos números caem
# dentro dos seguintes intervalos: [0-25], [26-50], [51-75], [76-100]. Depois que o valor
# negativo for inserido, exiba o total de números contados em cada intervalo e faça
# uma breve análise dos resultados.

soma_um = 0
soma_dois = 0
soma_tres = 0
soma_quatro = 0
valor = 0

while (valor == 0 or valor > 0):
    valor = int(input("Digite um valor: "))

    if valor < 0:
        break
    elif valor <= 25:
        soma_um += 1
    elif valor <= 50:
        soma_dois += 1
    elif valor <= 75:
        soma_tres += 1
    elif valor <=100:
        soma_quatro += 1


print(f"A quantidade de número entre 0 e 25 é: {soma_um}")
print(f"A quantidade de número entre 26 e 50 é: {soma_dois}")
print(f"A quantidade de número entre 51 e 75 é: {soma_tres}")
print(f"A quantidade de número entre 76 e 100 é: {soma_quatro}")

