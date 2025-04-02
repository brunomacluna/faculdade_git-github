class Pessoa:
    def __init__(self, nome, idade, profissao):
        self.nome = nome
        self.idade = idade
        if idade >= 18:
            self.carteira_habilitacao = True
        else:
            self.carteira_habilitacao = False
        self.profissao = profissao

pessoa_1 = Pessoa("Ana", 21, "Analista Financeiro")
pessoa_2 = Pessoa("Pedro", 15, "Jovem Aprendiz")
pessoa_3 = Pessoa("Maria", 30, "Developer")
pessoa_4 = Pessoa("Fernanda", 20, "Arquiteta")

pessoas = []

pessoas.append(pessoa_1)
pessoas.append(pessoa_2)
pessoas.append(pessoa_3)
pessoas.append(pessoa_4)
print(f"Quantas pessoas nós temos: {len(pessoas)}\n")
for pessoa in pessoas:
    print(f"Nome: {pessoa.nome}, Idade: {pessoa.idade}, Profissão: {pessoa.profissao}, CNH: {pessoa.carteira_habilitacao}")
