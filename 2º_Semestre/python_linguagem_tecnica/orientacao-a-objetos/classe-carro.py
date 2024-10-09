class Carro:
    def __init__(self, marca, modelo, ano, fipe):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
        self.fipe = fipe

    def relatorio(self):
        print("******Saída do objeto carro******")
        print(f"Marca do carro: {self.marca}")
        print(f"Modelo do carro: {self.modelo}")
        print(f"Ano do carro: {self.ano}")
        print(f"Fipe do carro: {self.fipe}")

objeto_1 = Carro("Toyota", "Corolla", 2020, float(110000))

marca = str(input("Digite a marca do carro: "))
modelo = str(input("Digite o modelo do carro: "))
ano = int(input("Digite o ano do carro: "))
fipe = float(input("Digite o valor da fipe: "))
objeto_2 = Carro(marca, modelo, ano, fipe)

#print("Mostrar o primeiro carro")
#print(f"Marca {objeto_1.marca} - Modelo {objeto_1.modelo} - Ano {objeto_1.ano} - Fipe {objeto_1.fipe}")
#print("Mostrar o segundo carro")
#print(f"Marca {objeto_2.marca} - Modelo {objeto_2.modelo} - Ano {objeto_2.ano} - Fipe {objeto_2.fipe}")

objeto_1.relatorio()
objeto_2.relatorio()




