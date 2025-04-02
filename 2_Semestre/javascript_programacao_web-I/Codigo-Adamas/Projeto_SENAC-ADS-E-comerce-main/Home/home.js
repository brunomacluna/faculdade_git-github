async function buscarProdutos(termo) {
    if (!termo) {
        alert("Termo de busca não informado");
        return;
    }

    const url = `https://api.mercadolibre.com/sites/MLB/search?q=${termo}`;

    try {
        const resposta = await fetch(url);
        const dados = await resposta.json();
        const { results } = dados;
        return results;
    } catch (erro) {
        console.error("Erro ao buscar produtos:", erro);
        alert("Erro ao buscar produtos. Tente novamente mais tarde.");
    }
}

// Função para iniciar a busca e exibir resultados
async function realizarBusca() {
    const input = document.getElementById("inputBusca");
    const termoBusca = input.value.trim();


    // Exibir um carregando enquanto busca
    const listaProdutos = document.getElementById("listaProdutos");
    listaProdutos.innerHTML = "<p>Carregando...</p>";

    const produtos = await buscarProdutos(termoBusca);
    exibirProdutos(produtos);
}

// Função para exibir produtos na página
function exibirProdutos(produtos) {
    const listaProdutos = document.getElementById("listaProdutos");
    listaProdutos.innerHTML = ""; // Limpa a lista antes de exibir novos produtos

    if (!produtos || produtos.length === 0) {
        listaProdutos.innerHTML = "<p>Nenhum produto encontrado.</p>";
        return;
    }
    produtos.forEach((produto) => {

        const item = document.createElement("div");
        item.className = "produto";
        item.innerHTML = `
            <img src='${produto.thumbnail}' />
            <h3>${produto.title}</h3>
            <p>Preço: R$ ${produto.price.toFixed(2).replace('.', ',')}</p>
            <a href="${produto.permalink}" target="_blank">Ver produto</a>
            <button onclick="adicionarAoCarrinho('${produto.title}', ${produto.price})">Adicionar ao Carrinho</button>
        `;
        listaProdutos.appendChild(item);
    });
}

// Função para adicionar produtos ao carrinho
function adicionarAoCarrinho(nome, preco) {
    const cartProducts = document.getElementById("cart-products");
    const divProduto = document.createElement("div");
    divProduto.innerHTML = `<p>${nome} - R$ ${preco.toFixed(2).replace('.', ',')}</p>`;
    cartProducts.appendChild(divProduto);
}

document.getElementById('inputBusca').addEventListener('keyup', function (event) {
    if (event.key === 'Enter') {
        realizarBusca();
    }
});

