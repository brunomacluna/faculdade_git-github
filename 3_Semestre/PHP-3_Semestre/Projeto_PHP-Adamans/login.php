<?php
session_start();

define('HOST', 'localhost');
define('USER', 'root');
define('PASS', 'adamanspc'); // se tiver senha, coloque aqui. Ex: '123456'
define('BASE', 'cadastro');

$conn = new mysqli(HOST, USER, PASS, BASE, 3306);

// Verifica se houve erro na conexão
if ($conn->connect_error) {
    die("Erro na conexão: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'] ?? '';
    $password = $_POST['password'] ?? '';

    $stmt = $conn->prepare("SELECT * FROM usuario WHERE user = ? AND senha = ?");
    $stmt->bind_param("ss", $username, $password);
    $stmt->execute();

    $result = $stmt->get_result();
    if ($result->num_rows === 1) {
        $_SESSION['user'] = $username;
        header("Location: index.php");
        exit();
    } else {
        echo "Usuário ou senha inválidos!";
    }

    $stmt->close();
}

$conn->close();
?>
