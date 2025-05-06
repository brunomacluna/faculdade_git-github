<?php
if(!empty($codigo = $_GET['codigo']))
{
include_once("conexao.php");
$codigo = $_GET["codigo"];
$sql = "select * from usuarios where codigo=$codigo";
$res = $conn->query($sql);
if ($res==true) {
    while ($row = mysql_fetch_assoc($res))
    {
        $nome = $row['nome'];
        $senha = $row['senha'];
        $email = $row['email'];
        $cpf = $row['cpf'];
        $data = $row['data'];
    }
} else {
    print("<scritp>alert('Dados não encontrados')</script>");
}
}
?>
<!doctype html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criando crud PHP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        h1 {
            text-align: center;
            color: blue;
        }
    </style>
  </head>
  <body>
    <div class="container">
        <h1><b>Atualizar dados de Usuário</b></h1>
        <hr>
    <form class="row g-3" action="EditarSalvar.php" method="post">
        <div class="col-12">
            <label for="inputAddress" class="form-label">Nome</label>
            <input type="text" class="form-control" name="nome" value="<?php echo $nome?>">
          </div>
          <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Senha</label>
            <input type="password" class="form-control" name="senha" value="<?php echo $senha?>">
          </div>
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label">Email</label>
          <input type="email" class="form-control" name="email" value="<?php echo $email?>">
        </div>
        <div class="col-md-6">
          <label for="inputAddress2" class="form-label">CPF</label>