<?php

class Paciente {
    public $nome;
    public $idade;
    public $historicoConsultas;

    public function __construct($nome, $idade) {
        $this->nome = $nome;
        $this->idade = $idade;
        $this->historicoConsultas = [];
    }

    public function adicionarConsulta($consulta) {
        $this->historicoConsultas[] = $consulta;
        return "Consulta adicionada: $consulta<br>";
    }

    public function exibirConsultas() {
        if (empty($this->historicoConsultas)) {
            return "Nenhuma consulta realizada.<br>";
        } else {
            return "Histórico de Consultas:<br>" . implode("<br>", $this->historicoConsultas);
        }
    }
}

$paciente1 = new Paciente("Bruno", 44);

echo $paciente1->adicionarConsulta("Consulta de rotina - 01/05/2025");
echo $paciente1->adicionarConsulta("Exame de sangue - 15/05/2025");
echo $paciente1->exibirConsultas();

?>
