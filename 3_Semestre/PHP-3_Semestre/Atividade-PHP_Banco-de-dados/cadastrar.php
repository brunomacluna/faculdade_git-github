<?php
$mensagem = "";

// Conectar ao banco de dados
$conn = new mysqli("localhost", "root", "Baton665", "Atividade-PHP");

// Verificar conexão
if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = strtolower(trim($_POST["nome"]));
    $senha = $_POST["senha"];

    // Verificar se o nome já está cadastrado
    $stmt = $conn->prepare("SELECT id FROM login WHERE nome = ?");
    $stmt->bind_param("s", $nome);
    $stmt->execute();
    $stmt->store_result();

    if ($stmt->num_rows > 0) {
        $mensagem = "Nome de usuário já cadastrado.";
    } else {
        // Inserir novo usuário
        $stmt = $conn->prepare("INSERT INTO login (nome, senha) VALUES (?, ?)");
        $stmt->bind_param("ss", $nome, $senha);
        
        if ($stmt->execute()) {
            $mensagem = "Usuário cadastrado com sucesso!";
        } else {
            $mensagem = "Erro ao cadastrar usuário.";
        }
    }

    $stmt->close();
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Cadastro</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card p-4 shadow" style="width: 100%; max-width: 400px;">
    <h4 class="text-center mb-4">Cadastrar Novo Usuário</h4>

    <?php if ($mensagem): ?>
      <div class="alert alert-info"><?= $mensagem ?></div>
    <?php endif; ?>

    <form method="POST">
      <div class="mb-3">
        <label for="nome" class="form-label">Nome de usuário</label>
        <input type="text" class="form-control" id="nome" name="nome" required>
      </div>
      <div class="mb-3">
        <label for="senha" class="form-label">Senha</label>
        <input type="text" class="form-control" id="senha" name="senha" required>
      </div>
      <div class="d-grid">
        <button type="submit" class="btn btn-success">Cadastrar</button>
      </div>
    </form>
    <div class="d-grid mt-3">
        <a href="index.php" class="btn btn-secondary">Voltar para login</a>
    </div>
  </div>
</div>

</body>
</html>
