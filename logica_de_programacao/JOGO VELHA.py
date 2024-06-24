# ----- Funções do usuário -----
def criaMatriz():
    return [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

def apresentaMatriz(mat):
    print(mat[0][0], "|", mat[0][1], "|", mat[0][2])
    print("-" * 10)
    print(mat[1][0], "|", mat[1][1], "|", mat[1][2])
    print("-" * 10)
    print(mat[2][0], "|", mat[2][1], "|", mat[2][2])

def posicaoOcupada(matriz, posicao):
    linha = (posicao - 1) // 3
    coluna = (posicao - 1) % 3
    if matriz[linha][coluna] == "X" or matriz[linha][coluna] == "O":
        return True
    else:
        return False

def registrajogada(matriz, posicao, jogador):
    linha = (posicao - 1) // 3
    coluna = (posicao - 1) % 3
    matriz[linha][coluna] = jogador
    return matriz

def verificadoganhador(matriz):
    for linha in range(3):
        if matriz[linha][0] == matriz[linha][1] == matriz[linha][2] or \
        matriz[0][coluna] == matriz[1][coluna] == matriz[2][coluna]:
            return True
    

    if matriz[0][0] == matriz[1][1] == matriz[2][2]:
        return True
    if matriz[0][2] == matriz[1][1] == matriz[2][0]:
        return True
    
    return False

print("*** JOGO DA VELHA ***\n")
print("Desafie o seu colega no jogo da velha.\n")
print("Regras:")
print(" a) O primeiro jogador participará com a letra X e o segundo com a letra O.")
print(" b) Os números de 1 a 9 representam as posições que estão livres.")
print(" c) O vencedor será o primeiro jogador a preencher uma linha, uma coluna ou uma diagonal.\n")

matriz = criaMatriz()
jogador = "X"

for c in range(9):
    print()
    apresentaMatriz(matriz)
    print()

    posicao = int(input(f"(Jogador {jogador}) Informe a posição desejada (1-9): "))

    if posicao < 1 or posicao > 9 or posicaoOcupada(matriz, posicao):
        print("\nPosição inválida ou já ocupada. Tente novamente.")
        continue

    matriz = registrajogada(matriz, posicao, jogador)

    if c >= 4:
        if verificadoganhador(matriz):
            print(f"\nJogador {jogador} venceu!\n")
            break

    jogador = "O" if jogador == "X" else "X"

else:
    print("\nJogo terminado sem vencedor.")
    apresentaMatriz(matriz)

print("\nFim do jogo!")

