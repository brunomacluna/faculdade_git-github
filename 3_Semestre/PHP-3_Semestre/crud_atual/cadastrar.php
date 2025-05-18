<?php
include('conexao.php');
$nome = $_POST['nome'];
$senha = $_POST['senha'];
$email = $_POST['email'];
$cpf = $_POST['cpf'];
$data = $_POST['data'];

$sql = "insert into usuarios values(null,'{$nome}','{$senha}','{$email}','{$cpf}','{$data}');";

$res = $conn -> query($sql);
if ($res == true){
    print("<script> alert('Cadastro efetuado com sucesso!');</script>");
    print("<script> location.href='crud.html'; </script>");   
}else{
    print("<script> alert('Erro ao cadastrar! Verifique!');</script>");
}