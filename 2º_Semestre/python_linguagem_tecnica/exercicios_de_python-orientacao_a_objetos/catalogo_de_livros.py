class Livro:
    def __init__(self, titulo, autor, ano_publicacao, genero):
        self.titulo = titulo
        self.autor = autor
        self.ano_publicacao = ano_publicacao
        self.genero = genero

class Biblioteca:
    def __init__(self):
        self.livros = {}
                
    def adicionar_livro(self,livro):
        genero = livro.genero
        if genero not in self.livros:
            self.livros[genero] = []
        self.livros[genero].append(livro.titulo)
             

    def remover_livro(self,titulo):
        encotrado = False
        for genero, titulos in self.livros.items():
            if titulo in titulos:
                titulos.remove(titulo)
                print(f"Livro '{titulo}' removido com sucesso.")
                encotrado = True
                break
        if not encotrado:
            print(f"Livro não encontrado.")    
        

    def listar_livros_por_genero(self, genero):
        if genero in self.livros:
            return self.livros[genero]
        else:
            return[]

biblioteca = Biblioteca()        

while True:
    print(10 * "~","Menu", 10 * "~")
    print("[1] Adicionar livro.")
    print("[2] Listar livros por gênero.")
    print("[3] Remover livro.")
    print("[4] Sair.")
    opcao = input("Escolha uma opção: ")
   

    if opcao == "1":
        titulo = input("Digite o título do livro: ")
        autor = input("Digite o autor do livro: ")
        ano_publicacao = int(input("Digite o ano de publicação: "))
        genero = input("Digite o gênero do livro: ")
        livro = Livro(titulo, autor, ano_publicacao, genero)
        biblioteca.adicionar_livro(livro)

    elif opcao == "2":
        genero = input("Digite o gênero: ") 
        livros = biblioteca.listar_livros_por_genero(genero)
        if livros:
            print("Livros encontrados:")
            for titulo in livros:
                print(titulo)
        else:
            print("Nenhum livro desse gênero foi encontrado.")

    elif opcao == "3":
        titulo = input("Digite o titulo do livro para ser Removido: ")
        biblioteca.remover_livro(titulo)

    elif opcao == "4":
        print("Saindo do programa.")
        break

    else:
        print("Opção inválida. Tente novamente")