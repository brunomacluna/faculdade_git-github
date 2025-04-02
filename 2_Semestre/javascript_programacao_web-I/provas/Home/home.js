//Etapa 2

// Função 1: Realiza a requisição à API do Mercado Livre com base em um termo de pesquisa
function buscarProdutosAPI(query) {
    // Verifica se um termo foi passado; se não, exibe um alerta
    if (!query) {
        alert('Termo de busca não informado');
        return;
    }

    // Faz a requisição à API usando fetch e passa o termo de pesquisa na URL
    return fetch(`https://api.mercadolibre.com/sites/MLB/search?q=${query}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na requisição à API'); // Verifica se a resposta está ok
            }
            return response.json(); // Converte a resposta para JSON
        })
        .then(data => data.results) // Extrai a lista de produtos do JSON retornado
        .catch(error => console.error('Erro ao buscar os produtos:', error)); // Lida com erros de requisição
}

// Função 2: Faz a busca ao capturar o termo digitado pelo usuário
function buscarPorTermo() {
    // Captura o campo de entrada e extrai o termo de pesquisa
    const campoPesquisa = document.getElementById('campo-pesquisa');
    const termoPesquisa = campoPesquisa.value.trim(); // Remove espaços em branco do termo

    // Chama a função de busca e passa o termo capturado
    buscarProdutosAPI(termoPesquisa)
        .then(produtos => {
            if (produtos) {
                renderizarProdutos(produtos); // Chama a função para renderizar produtos, se encontrados
            } else {
                console.log('Nenhum produto encontrado para o termo informado');
            }
        });
}

// Função 3: Renderiza os produtos na tela com HTML e CSS
function renderizarProdutos(produtos) {
    // Seleciona o container onde os produtos serão exibidos
    const container = document.getElementById('produtos-container');
    container.innerHTML = ''; // Limpa o conteúdo anterior

    // Verifica se há produtos na lista
    if (produtos.length === 0) {
        container.innerHTML = '<p>Nenhum produto encontrado.</p>';
        return;
    }

    // Percorre a lista de produtos e cria os elementos HTML dinamicamente
    produtos.forEach(produto => {
        const produtoDiv = document.createElement('div'); // Cria um div para o produto
        produtoDiv.classList.add('produto'); // Adiciona uma classe para estilização

        const titulo = document.createElement('h2'); // Cria o título do produto
        titulo.innerText = produto.title; // Define o texto do título
        titulo.classList.add('produto-titulo'); // Adiciona uma classe para o título

        const imagem = document.createElement('img'); // Cria a imagem do produto
        imagem.src = produto.thumbnail; // Define a URL da imagem
        imagem.alt = produto.title; // Adiciona texto alternativo à imagem
        imagem.classList.add('produto-imagem'); // Adiciona uma classe para a imagem

        const preco = document.createElement('p'); // Cria o parágrafo para o preço
        preco.innerText = `R$ ${produto.price.toFixed(2)}`; // Define o texto com o preço formatado
        preco.classList.add('produto-preco'); // Adiciona uma classe para o preço

        const botaoAdicionar = document.createElement('button'); // Cria o botão "Adicionar ao Carrinho"
        botaoAdicionar.innerText = 'Adicionar ao Carrinho';
        botaoAdicionar.classList.add('btn-adicionar'); // Adiciona uma classe ao botão

        // Adiciona os elementos criados ao container do produto
        produtoDiv.appendChild(titulo);
        produtoDiv.appendChild(imagem);
        produtoDiv.appendChild(preco);
        produtoDiv.appendChild(botaoAdicionar);

        // Adiciona o produto ao container principal
        container.appendChild(produtoDiv);
    });
}

// Adiciona o evento ao botão de pesquisa para iniciar a busca
document.addEventListener('DOMContentLoaded', () => {
    const botaoPesquisar = document.getElementById('botao-pesquisar');
    botaoPesquisar.addEventListener('click', buscarPorTermo);
    console.log('Evento de clique adicionado ao botão de pesquisa');
});
