<?php
// A tag PHP e session_start() devem ser a PRIMEIRA coisa no arquivo
session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro - Tech_Livro</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Tech_Livro</h1>
        <p>Crie sua conta</p>
    </header>

    <main>
        <div class="cadastro-box">
            <?php
            // Exibe a mensagem de erro/sucesso se existir na sessão
            if (isset($_SESSION['cadastro_error'])) {
                echo '<div class="message-box error-message">' . htmlspecialchars($_SESSION['cadastro_error']) . '</div>';
                unset($_SESSION['cadastro_error']);
            }
            if (isset($_SESSION['cadastro_success'])) {
                echo '<div class="message-box success-message">' . htmlspecialchars($_SESSION['cadastro_success']) . '</div>';
                unset($_SESSION['cadastro_success']);
            }
            ?>
            <img src="imagens/login.jpg" alt="Cadastro Image" class="cadastro-image">
            <form id="cadastroForm" action="cadastro_processa.php" method="post">
                <div class="input-group">
                    <label for="username">Usuário:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="input-group">
                    <label for="confirm_password">Confirmar Senha:</label>
                    <input type="password" id="confirm_password" name="confirm_password" required>
                </div>
                <button type="submit" class="botao-cadastro-submit">Cadastrar</button>
            </form>
            <a href="login.php" class="botao-voltar-login">Já tem uma conta? Faça Login</a>
        </div>
    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> Tech_Livro</p>
    </footer>
</body>
</html>