<?php

class Produto {
    public $nome;
    public $preco;

    public function __construct($nome, $preco) {
        $this->nome = $nome;
        $this->preco = $preco;
    }

    public function exibir() {
        return "Produto: $this->nome - Preço: R$$this->preco";
    }
}


$produto1 = new Produto("Laptop", 3500);
$produto2 = new Produto("Celular", 2000);
$produto3 = new Produto("Fone de ouvido", 150);


echo $produto1->exibir() . "<br>";
echo $produto2->exibir() . "<br>";
echo $produto3->exibir();

?>
