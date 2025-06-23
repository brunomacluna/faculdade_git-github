<?php
// Inicia a sessão PHP para gerenciar mensagens de sucesso/erro e redirecionamentos
session_start();

// Inclui o arquivo de conexão com o banco de dados
require_once 'conexao.php';

// Verifica se a requisição foi feita via método POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = trim($_POST['username']);
    $password = $_POST['password']; // Senha em texto puro
    $confirm_password = $_POST['confirm_password']; // Confirmação de senha

    // 1. Validação: Campos vazios
    if (empty($username) || empty($password) || empty($confirm_password)) {
        $_SESSION['cadastro_error'] = "Por favor, preencha todos os campos.";
        header("Location: cadastro.php");
        exit();
    }

    // 2. Validação: Senhas não conferem
    if ($password !== $confirm_password) {
        $_SESSION['cadastro_error'] = "As senhas não coincidem.";
        header("Location: cadastro.php");
        exit();
    }

    // 3. Validação: Comprimento mínimo da senha (opcional, mas recomendado)
    if (strlen($password) < 6) { // Exemplo: senha com no mínimo 6 caracteres
        $_SESSION['cadastro_error'] = "A senha deve ter no mínimo 6 caracteres.";
        header("Location: cadastro.php");
        exit();
    }

    try {
        // 4. Validação: Verificar se o username já existe no banco de dados
        $stmt = $pdo->prepare("SELECT id FROM usuarios WHERE username = :username");
        $stmt->bindParam(':username', $username);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            $_SESSION['cadastro_error'] = "Nome de usuário já existe. Escolha outro.";
            header("Location: cadastro.php");
            exit();
        }

        // 5. Hash da senha: Importante para segurança!
        $hashed_password = password_hash($password, PASSWORD_DEFAULT);

        // 6. Inserir novo usuário no banco de dados
        $stmt = $pdo->prepare("INSERT INTO usuarios (username, senha) VALUES (:username, :senha)");
        $stmt->bindParam(':username', $username);
        $stmt->bindParam(':senha', $hashed_password);

        if ($stmt->execute()) {
           $_SESSION['cadastro_success'] = "Cadastro realizado com sucesso! Faça login.";
           header("Location: cadastro.php"); // Altere para redirecionar para a página de cadastro
           exit();
        } else {
            $_SESSION['cadastro_error'] = "Erro ao cadastrar usuário. Tente novamente.";
            header("Location: cadastro.php");
            exit();
        }

    } catch (PDOException $e) {
        // Em caso de erro no banco de dados
        $_SESSION['cadastro_error'] = "Erro no banco de dados: " . $e->getMessage();
        header("Location: cadastro.php");
        exit();
    }
} else {
    // Se a página for acessada diretamente sem POST, redireciona para o cadastro
    header("Location: cadastro.php");
    exit();
}
?>