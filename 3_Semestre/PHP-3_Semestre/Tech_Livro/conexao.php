<?php

// Definições de conexão com o banco de dados
define('DB_HOST', 'localhost'); // Host do banco de dados (geralmente localhost no XAMPP)
define('DB_NAME', 'tech_livro'); // Nome do banco de dados criado
define('DB_USER', 'root');     // Usuário do banco de dados (root por padrão no XAMPP)
define('DB_PASS', '');         // Senha do banco de dados (vazio por padrão no XAMPP)

try {
    // String de conexão DSN (Data Source Name)
    $dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=utf8mb4";

    // Opções para a conexão PDO
    $options = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION, // Lança exceções em caso de erro
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,     // Retorna linhas como arrays associativos
        PDO::ATTR_EMULATE_PREPARES   => false,                // Desativa a emulação de prepared statements para maior segurança
    ];

    // Cria uma nova instância PDO
    $pdo = new PDO($dsn, DB_USER, DB_PASS, $options);

    // echo "Conexão bem-sucedida!"; // Remova ou comente esta linha em produção

} catch (PDOException $e) {
    // Em caso de erro na conexão, exibe a mensagem de erro
    // Em ambiente de produção, logar o erro e exibir uma mensagem genérica
    die("Erro na conexão com o banco de dados: " . $e->getMessage());
}

?>