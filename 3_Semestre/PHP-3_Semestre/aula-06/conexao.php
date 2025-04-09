<?php 


define('HOST', 'localhost');
define('USER', 'root'); 
define('PASS', 'Baton665');
define('BASE', 'cadastro1');

// Ajuste para conexão via socket (Arch/Manjaro)
$conn = new mysqli(HOST, USER, PASS, BASE, null, '/run/mysqld/mysqld.sock');

if ($conn->connect_error) {
    die('Erro na conexão: ' . $conn->connect_error);
}
?>
