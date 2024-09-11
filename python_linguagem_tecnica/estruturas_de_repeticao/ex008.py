# 8. Desenvolva um programa que receba um valor inicial A e imprima a sequência de
# operações necessárias para calcular o fatorial de A, além de exibir o resultado final
# do cálculo. Como exemplo, mostre a sequência de multiplicações e o resultado final
# para o fatorial de 5. Explique como o programa gerencia o processo de multiplicação
# em sequência.

print("===========")
print("1 x 1 = 1")
print("===========")
print("1 x 2 = 2")
print("===========")
print("2 x 3 = 6")
print("===========")
print("6 x 4 = 24")
print("===========")
print("24 x 5 = 120")
print("===========")
print("O fatorial de 5 é 120")
print("===========")
print("O programa multiplica todos os números inteiros e positivos menores ou iguais ao número escolhido")
print(" ")
# A variavél "resultado" tem que começar com 1, porque se fosse com zero iria estragar a multiplicação
resultado = 1
# Precisei da ajuda do ChatGPT para criar essa variavél "resultado_parcial", pois não conseguia imprimir os calculos
resultado_parcial = 0
numero = int(input("Digite um número a ser fatorado: "))
# Usei esse loop para forçar um número positivo
while (numero <= 0):
    numero = int(input("ALERTA - Digite um número positivo: "))
    if numero > 0:
        break
print(11 * "=")
# Usei o for para calcular o fatorial, iniciando de 1 e indo até número que o usuário escolher
for i in range(1, numero + 1):
    # Aqui se guarda o resultado parcial para imprimir para o usuário
    resultado_parcial = resultado 
    # Multiplica o valor de "resultado" por i e atualiza o valor de "resultado" para continuar o loop
    # Aqui também tive ajudo da IA para saber como se calculava um fatorial
    resultado *= i


    # Imprime os resultados a cada iteração
    print(f"{resultado_parcial} x {i} = {resultado}")
    
    print(11 * "=") 
print(f"O fatorial de {numero} é {resultado}")

    
