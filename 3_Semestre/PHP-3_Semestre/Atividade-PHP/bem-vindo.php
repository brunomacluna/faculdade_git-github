<?php
$user = isset($_GET['user']) ? htmlspecialchars($_GET['user']) : "Usuário";
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Bem-vindo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-success text-white d-flex justify-content-center align-items-center vh-100">
  <div class="text-center">
    <h1>Bem-vindo, <?= ucfirst($user) ?>!</h1>
    <p>Login realizado com sucesso.</p>
    <a href="index.php" class="btn btn-light mt-3">Sair</a>
  </div>
</body>
</html>
