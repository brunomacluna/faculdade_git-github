<?php

class LojaVirtual {
    public $produtos;

    public function __construct() {
        $this->produtos = [];
    }

    public function cadastrarProduto($nome, $preco) {
        $this->produtos[] = ["nome" => $nome, "preco" => $preco];
        return "Produto cadastrado: $nome - Preço: R$$preco<br>";
    }

    public function gerarCarrinho() {
        if (empty($this->produtos)) {
            return "Nenhum produto no carrinho.<br>";
        } else {
            $lista = "Carrinho de compras:<br>";
            foreach ($this->produtos as $produto) {
                $lista .= "{$produto['nome']} - R$ {$produto['preco']}<br>";
            }
            return $lista;
        }
    }

    public function aplicarDesconto($percentual) {
        if ($percentual > 0) {
            $total = 0;
            foreach ($this->produtos as $produto) {
                $total += $produto["preco"];
            }
            $desconto = ($total * $percentual) / 100;
            $totalFinal = $total - $desconto;
            return "Total com desconto de $percentual%: R$$totalFinal<br>";
        } else {
            return "Desconto inválido.<br>";
        }
    }
}


$loja = new LojaVirtual();

echo $loja->cadastrarProduto("Laptop", 3500);
echo $loja->cadastrarProduto("Celular", 2000);
echo $loja->cadastrarProduto("Fone de ouvido", 150);

echo $loja->gerarCarrinho();
echo $loja->aplicarDesconto(10);

?>
