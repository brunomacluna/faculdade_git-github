def soma(a, b):
    return a + b

def multiplicacao(a, b):
    return a * b

def subtracao(a, b):
    return a - b

def divisao (a, b):
    if b == 0:
        print("Não se pode dividir por 0.")
        return -9999
    else: 
        return a / b
    
def usuario():
    v1 = int(input("Digite o primeiro valor: "))
    v2 = int(input("Digite o segundo valor: "))
    operacao = input("Digite [+] para adição,  [-] para subtração, [*] para multiplicação e [/] para divisão: ")

    if operacao == "+":
        print(f"O resultado da adição é {soma(v1, v2)}")
    elif operacao == "-":
        print(f"O resultado da subtração é {subtracao(v1, v2)}")
    elif operacao == "*":
        print(f"O resutado da multiplicação é {multiplicacao(v1, v2)}")
    elif operacao == "/":
        retorno = divisao(v1, v2)
        if retorno != -9999:
            print(f"O resultado da divisão é {divisao(v1,v2)}")
    else:
        print("Operação inválida.")

usuario()