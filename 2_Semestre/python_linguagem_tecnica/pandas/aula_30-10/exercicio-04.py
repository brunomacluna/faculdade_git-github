import pandas as pd 

df = pd.read_excel("/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas/aula_30-10/dados_exemplo.xlsx"
    , sheet_name="Sheet1")

#Agrupar por Produto e calcular a soma das quantidades vendidas
total_vendido_por_produto = df.groupby('Produto', as_index=False) ['Quantidade'].sum() 

# Renomear a coluna para deixar claro que é o total vendido 
total_vendido_por_produto.rename(columns={'Quantidade': 'Total Vendido'}, inplace=True)

#Exibir o resultado 
print(total_vendido_por_produto)