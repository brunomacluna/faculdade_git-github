import pandas as pandas
import matplotlib.pyplot as plt

dados_vendas = pandas.read_excel('/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas_grafico/dados_vendas.xlsx')

dados_vendas['Data'] = pandas.to_datetime(dados_vendas["Data"], format="%d/%m/%Y")

dados_vendas["Ano"] = dados_vendas["Data"].dt.year
dados_vendas["Mes"] = dados_vendas["Data"].dt.month

vendas_mensais = dados_vendas.groupby(["Ano", "Mes"])["Total_Venda"].sum().reset_index()


plt.figure(figsize=(12, 6))
for ano in vendas_mensais["Ano"].unique():
    dados_ano = vendas_mensais[vendas_mensais["Ano"] == ano]
    plt.plot(dados_ano["Mes"], dados_ano["Total_Venda"], marker='o', label=str(ano))


plt.title("Tendência Mensal de Vendas as Longo dos Anos")
plt.xlabel("Mês")
plt.ylabel("Total de Vendas")
plt.xticks(range(1, 13), ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"])
plt.yticks(range(0, int(vendas_mensais["Total_Venda"].max()) + 5000, 5000))
plt.legend(title="Ano")
plt.tight_layout()
#plt.show()
# Salvando o gráfico como uma imagem 
plt.savefig('/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas_grafico/grafico_vendas.png') 
print("Gráfico salvo como 'grafico_vendas.png'")