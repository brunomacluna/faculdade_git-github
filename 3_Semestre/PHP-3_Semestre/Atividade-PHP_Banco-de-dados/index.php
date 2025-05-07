<?php
$erro = "";

// Conectar ao banco de dados
$conn = new mysqli("localhost", "root", "Baton665", "Atividade-PHP");

// Verificar conexão
if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $usuario = strtolower(trim($_POST["usuario"]));
    $senha = $_POST["senha"];

    // Buscar o usuário no banco
    $stmt = $conn->prepare("SELECT senha FROM login WHERE nome = ?");
    $stmt->bind_param("s", $usuario);
    $stmt->execute();
    $stmt->store_result();

    if ($stmt->num_rows == 1) {
        $stmt->bind_result($senha_db);
        $stmt->fetch();

        if ($senha === $senha_db) {
            header("Location: bem-vindo.php?user=" . urlencode($usuario));
            exit();
        } else {
            $erro = "Usuário ou senha inválidos.";
        }
    } else {
        $erro = "Usuário ou senha inválidos.";
    }

    $stmt->close();
}

$conn->close();
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
        <div class="d-grid mb-2">
          <button type="submit" class="btn btn-primary">Entrar</button>
        </div>
        <div class="d-grid">
          <a href="cadastrar.php" class="btn btn-secondary">Cadastre-se</a>
        </div>

      </form>
    </div>
  </div>

</body>
</html>
