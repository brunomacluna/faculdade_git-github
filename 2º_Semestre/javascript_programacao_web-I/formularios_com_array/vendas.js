function calculaDesconto(valor) {
    return valor * 0.1;
}
const vendas = [];
let tabela = document.getElementById("tabela");

function preencherVetor() {
    let nome = document.getElementById("nome").value;
    let valor = document.getElementById("valor").value;
    let desconto = calculaDesconto(valor);
    vendas.push({
        nome,
        valor,
        desconto
    });
}