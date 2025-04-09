<?php 
error_reporting(E_ALL);
ini_set('display_errors', 1);

include_once('conexao.php');

$nome = $_POST['nome'];
$senha = $_POST['senha'];
$email = $_POST['email'];
$cpf = $_POST['cpf'];
$data = $_POST['data']; // Verifique se esse campo existe no formulário

$sql = "INSERT INTO usuarios (nome, senha, email, cpf, data) 
        VALUES ('{$nome}', '{$senha}', '{$email}', '{$cpf}', '{$data}');";


$res = $conn->query($sql);

if ($res) {
    echo "<script>alert('Cadastro efetuado com sucesso!');</script>";
    echo "<script>location.href='crud.html';</script>";
} else {
    echo "<script>alert('Erro ao cadastrar! Verifique!');</script>";
}
?>
