class Funcionario:
    def __init__(self, nome, departamento, salario):
        self.nome = nome
        self.departamento = departamento
        self.salario = salario

class GerenciadorFuncionarios:
    def __init__(self):
        self.funcionarios = []

    def adicionar_funcionario(self, funcionario):
        self.funcionarios.append(funcionario)
        print(f"Funcionário '{funcionario.nome}' adicionado com sucesso.")

    def excluir_funcionario(self, nome):
        for funcionario in self.funcionarios:
            if funcionario.nome == nome:
                self.funcionarios.remove(funcionario)
                print(f"Funcionário '{nome}' removido com sucesso.")
                return
        print(f"Funcionário '{nome}' não encontrado.")

    def listar_funcionarios_por_departamento(self, departamento):
        encontrados = [f"Nome: {funcionario.nome}, Salário: {funcionario.salario:.2f}" for funcionario in self.funcionarios if funcionario.departamento == departamento]
        if encontrados:
            print(f"Funcionários no departamento '{departamento}':")
            for funcionario in encontrados:
                print(funcionario)
        else:
            print(f"Nenhum funcionário encontrado no departamento '{departamento}'.")


gerenciador = GerenciadorFuncionarios()

while True:
    print(10 * "~", "Menu", 10 * "~")
    print("[1] Adicionar funcionário.")
    print("[2] Listar funcionários por departamento.")
    print("[3] Remover funcionário.")
    print("[4] Sair.")
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        nome = input("Digite o nome do funcionário: ")
        departamento = input("Digite o departamento do funcionário: ")
        salario = float(input("Digite o salário do funcionário: "))
        funcionario = Funcionario(nome, departamento, salario)
        gerenciador.adicionar_funcionario(funcionario)

    elif opcao == "2":
        departamento = input("Digite o departamento: ")
        gerenciador.listar_funcionarios_por_departamento(departamento)

    elif opcao == "3":
        nome = input("Digite o nome do funcionário para ser removido: ")
        gerenciador.excluir_funcionario(nome)

    elif opcao == "4":
        print("Saindo do programa.")
        break

    else:
        print("Opção inválida. Tente novamente.")
