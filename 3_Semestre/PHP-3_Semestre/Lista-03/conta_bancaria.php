<?php

class ContaBancaria {
    public $numeroConta;
    public $titular;
    public $saldo;

    public function __construct($numeroConta, $titular, $saldoInicial) {
        $this->numeroConta = $numeroConta;
        $this->titular = $titular;
        $this->saldo = $saldoInicial;
    }//construtor

    public function depositar($valor) {
        if ($valor > 0) {
            $this->saldo += $valor;
            return "Depósito de R$$valor realizado com sucesso!";
        } else {
            return "Valor inválido para depósito.";
        }
    }//depositar


    public function sacar($valor) {
        if ($valor > 0 && $valor <= $this->saldo) {
            $this->saldo -= $valor;
            return "Saque de R$$valor realizado com sucesso!";
        } else {
        return "Saldo insuficiente ou valor inválido.";
        }
    }//sacar

    public function exibirConta(){
        return "Titular - $this->titular<br>Conta - $this->numeroConta<br>Saldo - R$$this->saldo<br>";
    }//exibirConta

    public function exibirSaldo() {
        return "Saldo atual: R$$this->saldo";
    }
}//class


$conta1 = new ContaBancaria("12345-6", "Bruno", 10000);

echo $conta1->exibirConta() . '<br>';
echo $conta1->exibirSaldo() . "<br>";
echo $conta1->depositar(500) . "<br>";
echo $conta1->exibirSaldo() . "<br>";
echo $conta1->sacar(300) . "<br>";
echo $conta1->exibirSaldo();

?>
