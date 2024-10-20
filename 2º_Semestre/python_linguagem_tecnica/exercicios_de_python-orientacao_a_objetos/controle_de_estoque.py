class Produto:
    def __init__(self, codigo, nome, quantidade):
        self.codigo = codigo
        self.nome = nome
        self.quantidade = quantidade

class Estoque:
    def __init__(self):
        self.produtos = {}

    def adicionar_produto(self, produto):
        self.produtos[produto.codigo] = produto

    def remover_produto(self, codigo):
        if codigo in self.produtos:
            del self.produtos[codigo]
            print(f"Produto '{codigo}' removido com sucesso.")
        else:
            print("Produto não encontrado.")

    def listar_produtos(self):
        print("Produtos no estoque:")
        for produto in self.produtos.values():
            print(f"Código: {produto.codigo}, Nome: {produto.nome}, Quantidade: {produto.quantidade}")

    def verificar_estoque(self):
        produtos_em_estoque = {produto.nome for produto in self.produtos.values() if produto.quantidade > 10}
        return produtos_em_estoque

estoque = Estoque()

while True:
    print(10 * "~", "Menu", 10 * "~")
    print("[1] Adicionar produto.")
    print("[2] Remover produto.")
    print("[3] Listar produtos.")
    print("[4] Verificar produtos com mais de 10 unidades.")
    print("[5] Sair.")
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        codigo = (input("Digite o código do produto: "))
        nome = input("Digite o nome do produto: ")
        quantidade = int(input("Digite a quantidade do produto: "))
        produto = Produto(codigo, nome, quantidade)
        estoque.adicionar_produto(produto)

    elif opcao == "2":
        codigo = input("Digite o código do produto a ser removido: ")
        estoque.remover_produto(codigo)

    elif opcao == "3":
        estoque.listar_produtos()

    elif opcao == "4":
        produtos_com_estoque = estoque.verificar_estoque()
        if produtos_com_estoque:
            print("Produtos com mais de 10 unidades no estoque:")
            for produto in produtos_com_estoque:
                print(produto)
        else:
            print("Nenhum produto com mais de 10 unidades no estoque.")

    elif opcao == "5":
        print("Saindo do programa.")
        break

    else:
        print("Opção inválida. Tente novamente.")
