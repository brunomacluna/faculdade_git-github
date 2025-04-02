# Função para criar a matriz inicial do jogo da velha
def criaMatriz():
    return [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

# Função para apresentar a matriz na tela
def apresentaMatriz(mat):
    for linha in mat:
        print(linha[0], "|", linha[1], "|", linha[2])
        if linha != mat[-1]:
            print("-" * 10)

# Função para verificar se a posição está ocupada
def posicaoOcupada(matriz, posicao):
    linha = (posicao - 1) // 3
    coluna = (posicao - 1) % 3
    return matriz[linha][coluna] == "X" or matriz[linha][coluna] == "O"

# Função para registrar a jogada do jogador
def registraJogada(matriz, posicao, jogador):
    linha = (posicao - 1) // 3
    coluna = (posicao - 1) % 3
    matriz[linha][coluna] = jogador
    return matriz

# Função para verificar se há um vencedor
def verificaGanhador(matriz):
    # Verifica linhas e colunas
    for i in range(3):
        if matriz[i][0] == matriz[i][1] == matriz[i][2] or matriz[0][i] == matriz[1][i] == matriz[2][i]:
            return True
    
    # Verifica diagonais
    if matriz[0][0] == matriz[1][1] == matriz[2][2] or matriz[0][2] == matriz[1][1] == matriz[2][0]:
        return True
    
    return False

# Função para reiniciar a matriz do jogo
def reiniciaJogo():
    return criaMatriz()

print("*** JOGO DA VELHA ***\n")
print("Desafie o seu colega no jogo da velha.\n")
print("Regras:")
print(" a) O primeiro jogador participará com a letra X e o segundo com a letra O.")
print(" b) Os números de 1 a 9 representam as posições que estão livres.")
print(" c) O vencedor será o primeiro jogador a preencher uma linha, uma coluna ou uma diagonal.\n")

# Loop principal do jogo
while True:
    matriz = criaMatriz()  # Inicia a matriz do jogo
    jogador = "X"  # Começa com o jogador X

    for rodada in range(9):
        print()
        apresentaMatriz(matriz)
        print()

        posicao = int(input(f"(Jogador {jogador}) Informe a posição desejada (1-9): "))

        if posicao < 1 or posicao > 9 or posicaoOcupada(matriz, posicao):
            print("\nPosição inválida ou já ocupada. Tente novamente.")
            continue

        matriz = registraJogada(matriz, posicao, jogador)

        if rodada >= 4:  # Só verifica ganhador a partir da 5ª jogada
            if verificaGanhador(matriz):
                print(f"\nJogador {jogador} venceu!\n")
                break

        jogador = "O" if jogador == "X" else "X"  # Alterna entre X e O

    else:
        print("\nJogo terminado sem vencedor.")
        apresentaMatriz(matriz)

    # Pergunta se deseja jogar novamente
    jogarNovamente = input("Deseja jogar novamente? (s/n): ").strip().lower()
    if jogarNovamente != "s":
        break  # Sai do loop principal se não quiser jogar novamente

print("\nFim do jogo!")
