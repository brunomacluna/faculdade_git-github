<?php
// Inicia a sessão PHP para acessar as mensagens de erro
session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Tech_Livro</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Tech_Livro</h1>
        <p>Acesse sua área restrita</p>
    </header>

    <main>
        <div class="login-box">
            <?php
            // Exibe a mensagem de erro se existir na sessão
            if (isset($_SESSION['login_error'])) {
                echo '<div class="error-message">' . htmlspecialchars($_SESSION['login_error']) . '</div>';
                unset($_SESSION['login_error']); // Remove a mensagem após exibi-la
            }
            ?>
            <img src="imagens/login.jpg" alt="Login Image" class="login-image">
            <form action="login_processa.php" method="post">
                <div class="input-group">
                    <label for="username">Usuário:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="botao-login">Entrar</button>
            </form>
            <div class="cadastro-link">
                <p>Não tem uma conta?</p>
                <a href="cadastro.php" class="botao-cadastro">Cadastre-se</a>
            </div>
            <a href="index.php" class="botao-voltar">Voltar à Página Inicial</a>
        </div>
    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> Tech_Livro</p>
    </footer>
</body>
</html>