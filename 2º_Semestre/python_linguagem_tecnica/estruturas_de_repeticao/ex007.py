# 7. Escreva um programa que solicite ao usuário um valor N, entre 1 e 10, e calcule a
# tabuada desse número. A tabuada deve ser exibida de maneira organizada,
# mostrando cada operação de multiplicação, de 0 a 10, e o respectivo resultado.
# Discuta como o programa realiza o cálculo da tabuada e formata os resultados.

numero = int(input("Digite um número de [1] a [10]: "))
while (numero < 1 or numero > 10):
    numero = int(input("Valor inválido, digite um número de [1] a [10]: "))
    if numero > 0 and numero < 11:
        break

print(11 * "=")
for i in range(0, 11):
    total = numero * i
    print(f"{numero} x {i} = {total}")
    print(11 * "=")


# Usei o while para forçar o usuário a colocar um valor válido
# O programa usa o loop for para multiplicar o número que o usuário
# inseriu por todos os números do range de zero a 10 e depois imprime
# cada calculo
# Acresentei um separador com a string "=" para melhorar a visualização