<?php
// Lista de usuários cadastrados (nome => senha)
$usuarios = [
  "ana" => "1234",
  "bruno" => "1234",
  "carla" => "1234",
  "daniel" => "1234",
  "elisa" => "1234"
];

$erro = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $usuario = strtolower(trim($_POST["usuario"]));
    $senha = $_POST["senha"];

    if (array_key_exists($usuario, $usuarios) && $usuarios[$usuario] === $senha) {
        // Login válido, redirecionar para página de boas-vindas
        header("Location: bem-vindo.php?user=" . urlencode($usuario));
        exit();
    } else {
        $erro = "Usuário ou senha inválidos.";
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="style.css">
</head>
<body class="bg-light">

  <div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card p-4 shadow" style="width: 100%; max-width: 400px;">
      <h4 class="text-center mb-4">Login</h4>
      
      <!-- Exibir mensagem de erro, caso exista -->
      <?php if ($erro): ?>
        <div class="alert alert-danger"><?= $erro ?></div>
      <?php endif; ?>

      <form method="POST">
        <div class="mb-3">
          <label for="usuario" class="form-label">Usuário</label>
          <input type="text" class="form-control" id="usuario" name="usuario" required>
        </div>
        <div class="mb-3">
          <label for="senha" class="form-label">Senha</label>
          <input type="password" class="form-control" id="senha" name="senha" required>
        </div>
        <div class="d-grid">
          <button type="submit" class="btn btn-primary">Entrar</button>
        </div>
      </form>
    </div>
  </div>

</body>
</html>
