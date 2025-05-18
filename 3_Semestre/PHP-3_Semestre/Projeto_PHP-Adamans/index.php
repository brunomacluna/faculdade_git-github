<?php
session_start();
if(!isset($_SESSION['user'])){
    header("Location: index.html");
    exit();
}
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela inicial</title>
    <style>
        body{
            background-color: lightblue;
            font-family: verdana;
        }
    </style>
</head>
<body>
    <h2>Tela inicial do Sistema</h2>
    <p>Bem vindo(a): <?php echo $_SESSION['user'];?></p>
    <a href="logout.php">Sair</a>
</body>