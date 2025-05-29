<?php

class Aluno {
    public $nome;
    public $matricula;
    public $notas;

    public function __construct($nome, $matricula, $notas) {
        $this->nome = $nome;
        $this->matricula = $matricula;
        $this->notas = $notas;
    }

    public function calcularMedia() {
        $soma = array_sum($this->notas);
        $quantidade = count($this->notas);
        return $quantidade > 0 ? $soma / $quantidade : 0;
    }

    public function verificarSituacao() {
        $media = $this->calcularMedia();
        return $media >= 7 ? "Aprovado" : "Reprovado";
    }
}

// Criando um objeto da classe Aluno
$aluno1 = new Aluno("Bruno", "123456", [10, 8, 9, 10]);

echo "Nome: {$aluno1->nome}<br>";
echo "Matrícula: {$aluno1->matricula}<br>";
echo "Média: " . number_format($aluno1->calcularMedia(), 2) . "<br>";
echo "Situação: " . $aluno1->verificarSituacao();

?>
