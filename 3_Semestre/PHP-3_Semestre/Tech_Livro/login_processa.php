<?php
// Inicia a sessão PHP, é fundamental para gerenciar o estado do usuário logado
session_start();

// Inclui o arquivo de conexão com o banco de dados
require_once 'conexao.php';

// Verifica se os dados foram enviados via POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = trim($_POST['username']);
    $password = trim($_POST['password']);

    // Validação básica para evitar campos vazios
    if (empty($username) || empty($password)) {
        $_SESSION['login_error'] = "Por favor, preencha todos os campos.";
        header("Location: login.php");
        exit();
    }

    try {
        // Prepara a consulta SQL para buscar o usuário pelo username
        $stmt = $pdo->prepare("SELECT id, username, senha FROM usuarios WHERE username = :username");
        $stmt->bindParam(':username', $username);
        $stmt->execute();

        // Obtém o resultado
        $user = $stmt->fetch(PDO::FETCH_ASSOC);

        // Verifica se o usuário foi encontrado e se a senha está correta
        if ($user && password_verify($password, $user['senha'])) {
            // Login bem-sucedido: Armazena informações do usuário na sessão
            $_SESSION['logged_in'] = true;
            $_SESSION['user_id'] = $user['id'];
            $_SESSION['username'] = $user['username'];

            // Redireciona para a página do CRUD
            header("Location: crud.php");
            exit();
        } else {
            // Login falhou: Mensagem de erro e redireciona de volta para login.php
            $_SESSION['login_error'] = "Usuário ou senha inválidos.";
            header("Location: login.php");
            exit();
        }

    } catch (PDOException $e) {
        // Em caso de erro no banco de dados
        $_SESSION['login_error'] = "Erro no banco de dados: " . $e->getMessage();
        header("Location: login.php");
        exit();
    }
} else {
    // Se a página for acessada diretamente sem POST, redireciona para o login
    header("Location: login.php");
    exit();
}
?>