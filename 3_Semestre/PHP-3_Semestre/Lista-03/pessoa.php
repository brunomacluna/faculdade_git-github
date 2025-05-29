<?php

class Pessoa {
    public $nome;
    public $idade;

    public function __construct($nome, $idade) {
        $this->nome = $nome;
        $this->idade = $idade;
    }

    public function exibirDados() {
        return "Nome: $this->nome - Idade: $this->idade anos";
    }
}


$pessoa1 = new Pessoa("Bruno", 44);
echo $pessoa1->exibirDados();

?>
