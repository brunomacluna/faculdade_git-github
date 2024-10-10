class Aluno:
    def __init__(self, nome, notas):
        self.nome = nome
        self.notas = notas

    def calcuca_media(self):
        if len(self.notas) == 3:
            return (((self.notas[0] + self.notas[1])/2) + self.notas[2]) / 2
        return sum(self.notas) / len(self.notas)
    
    def imprimir(self):
        media = self.calcuca_media()
        if media >= 6:
            print(f"Aluno Aprovado, Nome {self.nome} com Média {media}")
        else:
            print(f"Aluno Reprovado, Nome {self.nome} com Média {media}")

obj_aluno = Aluno("Pedro", (2.5, 7.0, 7.5))

print("***Mostrando Notas***")
out = "("
for nota in obj_aluno.notas:
    out = out + str(nota) + " "

out = out + ")"
print(out)
obj_aluno.imprimir()